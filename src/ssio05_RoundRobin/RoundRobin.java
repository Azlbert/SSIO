/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssio05_RoundRobin;

import java.util.LinkedList;
import java.util.TimerTask;

/**
 *
 * @author Usuario
 */
public class RoundRobin extends TimerTask{
    private byte miliSegundos = 0;
    private byte segundos = 0;
    private byte minutos = 0;
    
    public static long tiempoTotal = 0;
    public static long _Tinicio = 0;
    public static long _tme = 0;
    public static final long tiempoBloqueo = 1000;
    public static long quantum;

    private final int maximoDeProcesosEnMemoria = 6;
    
    private final IManipulo manipular;
    private Estado estado;
    
    private Proceso enEjecucion;
    
    public RoundRobin(IManipulo manipular){
        this.manipular = manipular;
        this.estado = Estado.Esperando;
    }
    
    @Override
    public void run() {
        if(estado == Estado.Esperando || estado == Estado.Pausa){
            return;
        } else if(sinProcesosPorProcesar()){
            estado = Estado.Esperando;
            return;
        }
        
        ajustarTiempo();
        ajustarProcesos();
        ajustarBloqueados();
        
        if((enEjecucion = Procesos.Ejecucion.peek()) == null)  return;
        
        switch (estado) {
            case Ejecucion:
                long tiempoTranscurrido = tiempoTotal - _Tinicio;
                if(tiempoTranscurrido > _tme)
                    terminarProcesoEnEjecucion();
                else if(tiempoTranscurrido > quantum)
                    regresarProcesoEnEjecucion();
                manipular.actualizarTiemposDelProcesoEnEjecucion(tiempoTranscurrido,(_tme-tiempoTranscurrido));
                manipular.actualizarQuantum(quantum - tiempoTranscurrido);
                break;
            case Interrupcion:
                bloquearProcesoEnEjecucion();
                break;
            case Error:
                enEjecucion.reportarError();
                terminarProcesoEnEjecucion();
        }
        
        enEjecucion.setTiempoRestante(_tme - (tiempoTotal - _Tinicio));
        estado = Estado.Ejecucion;
    }

    private void ajustarTiempo(){
        miliSegundos++;
        tiempoTotal++;
        
        if(miliSegundos == 100){
            miliSegundos= 0;
            segundos++;
            if(segundos == 60){
                segundos = 0;
                minutos++;
                if(minutos > 999)
                    minutos = 0;
            }
        }
        
        manipular.actualizarReloj(minutos, segundos, miliSegundos);
    }
    
    private void ajustarProcesos(){
        Proceso proceso;
        while(!memoriaLlena() && !Procesos.Nuevo.isEmpty()){
            proceso = Procesos.Nuevo.pop();
            Procesos.Listo.add(proceso);
            proceso.setTiempoLlegada(tiempoTotal);
            
            manipular.actualizarContadorProceosNuevos(Procesos.Nuevo.size());
            manipular.agregarProcesoListos(proceso.getId(), proceso.getTiempoMaximoEstimado(), proceso.getTiempoRestante());
        }
        
        if(enEjecucion == null && !Procesos.Listo.isEmpty()){
            Procesos.Ejecucion.add((enEjecucion = Procesos.Listo.pop()));
            _tme = enEjecucion.getTiempoRestante();
            enEjecucion.setPrimeraVezAtendido((_Tinicio = tiempoTotal));
            
            manipular.ejecutarSiguienteProceso(enEjecucion.getId(), 
                enEjecucion.getTiempoMaximoEstimado(), 
                enEjecucion.getOperacion());
        }
    }
    
    private void ajustarBloqueados(){
        if(Procesos.Bloqueado.isEmpty())    return;
        
        LinkedList<Proceso>terminados = new LinkedList<>();
        int row = 0;
        for (Proceso proceso : Procesos.Bloqueado.getLista()) {
            long value = proceso.getTiempoBloqueado();
            if(value > tiempoTotal){
                // entry.setValue(value);
                manipular.actualizarTiempoRestanteDeBloqueados(row, value-tiempoTotal);
            }else{
                desbloquearProceso(proceso);
                terminados.add(proceso);
            }
            row++;
        }
        
        terminados.forEach((terminado) -> { Procesos.Bloqueado.remove(terminado); });
    }
    
    private void terminarProcesoEnEjecucion(){
        if(enEjecucion == null)  return;
        
        Procesos.Terminado.add(enEjecucion);
        enEjecucion.setTiempoFinalizacion(tiempoTotal);
        
        manipular.borrarProcesoEnEjecucion();
        manipular.agregarProcesoTerminado(enEjecucion.getId(), 
                    enEjecucion.getOperacion(), 
                    enEjecucion.getResultado());
        Procesos.Ejecucion.clear();
    }
    
    private void bloquearProcesoEnEjecucion(){
        manipular.borrarProcesoEnEjecucion();
        manipular.agregarProcesoBloqueado(enEjecucion.getId(), tiempoBloqueo);
        
        Procesos.Bloqueado.add(enEjecucion);
        enEjecucion.setTiempoBloqueado(tiempoTotal + tiempoBloqueo);
        Procesos.Ejecucion.clear();
    }
    
    private void desbloquearProceso(Proceso proceso){
        Procesos.Listo.add(proceso);
        
        manipular.eliminarPrimerProcesoBloqueado();
        manipular.agregarProcesoListos(proceso.getId(), proceso.getTiempoMaximoEstimado(), proceso.getTiempoRestante());
    }
    
    private void regresarProcesoEnEjecucion(){
        if(enEjecucion == null) return;

        Proceso proceso = enEjecucion;
        Procesos.Listo.add(proceso);
        Procesos.Ejecucion.clear();

        manipular.borrarProcesoEnEjecucion();
        manipular.agregarProcesoListos(proceso.getId(), proceso.getTiempoMaximoEstimado(), proceso.getTiempoRestante());
    }
    
    private boolean memoriaLlena(){
        int enMemoria = Procesos.Listo.size();
        enMemoria += Procesos.Bloqueado.size();
        if(!Procesos.Ejecucion.isEmpty())  enMemoria++;
        return enMemoria >= maximoDeProcesosEnMemoria;
    }
    
    private boolean sinProcesosPorProcesar(){
        return Procesos.Ejecucion.isEmpty() && Procesos.Listo.isEmpty() 
                && Procesos.Bloqueado.isEmpty() && Procesos.Nuevo.isEmpty();
    }

    private void imprimir(){
        String t = "" + minutos + ":" + segundos + ":" + miliSegundos;
    }
    
    public void iniciar(){
        if(estado == Estado.Esperando)  estado = Estado.Ejecucion;
    }
    
    public void interrumtpir(){
        if(estado != Estado.Esperando && estado != Estado.Interrupcion){
            estado = Estado.Interrupcion;
        }
    }
    
    public void causarError(){
        if(estado != Estado.Esperando && estado == Estado.Ejecucion){
            estado = Estado.Error;
        }
    }
    
    public void pausar(){
        if(estado != Estado.Esperando && estado != Estado.Pausa){
            estado = Estado.Pausa;
        }
    }
    
    public void continuar(){
        if(estado != Estado.Esperando && estado != Estado.Ejecucion){
            estado = Estado.Ejecucion;
        }
    }
    
    public void crearNuevoProcesoAleatorio(){
        Proceso proceso = new Proceso();
        if(!memoriaLlena()){
            Procesos.Listo.add(proceso);
            proceso.setTiempoLlegada(tiempoTotal);
            manipular.agregarProcesoListos(proceso.getId(), proceso.getTiempoMaximoEstimado(), proceso.getTiempoRestante());
        } else {
            Procesos.Nuevo.add(proceso);
            manipular.actualizarContadorProceosNuevos(Procesos.Nuevo.size());
        }
    }
    
    public void crearProcesosAleatorios(int numeroDeProcesos){
        for (int i = 0; i < numeroDeProcesos; i++)
            crearNuevoProcesoAleatorio();
    }
    
    public LinkedList<Proceso> getProcesos(){
        LinkedList<Proceso> procesos = new LinkedList<>();
        if(!Procesos.Ejecucion.isEmpty())    procesos.add(Procesos.Ejecucion.peek());
        Procesos.Terminado.getLista().forEach(proceso -> {procesos.add(proceso);});
        Procesos.Listo.getLista().forEach(proceso -> {procesos.add(proceso);});
        Procesos.Bloqueado.getLista().forEach(proceso -> {procesos.add(proceso);});
        Procesos.Nuevo.getLista().forEach(proceso -> {procesos.add(proceso);});
        return procesos;
    }
    
    public void setQuantum(long quantum){
        this.quantum = quantum;
    }
}

enum Estado{
    Esperando,
    Ejecucion,
    Pausa,
    Interrupcion,
    Error
}

enum Procesos{
    Nuevo,
    Listo,
    Ejecucion,
    Bloqueado,
    Terminado;

    private final LinkedList<Proceso> procesos;
    private Proceso proceso;
    
    Procesos(){
        procesos = new LinkedList<>();
    }
    
    public LinkedList<Proceso> getLista(){
        if(this == Ejecucion)   throw new Error("No deberias de llamar este metodo");
        return procesos;
    }
    
    public Proceso peek(){
        if(this == Ejecucion)   return proceso;
        return procesos.peek();
    }
    
    public Proceso pop(){
        if(this == Ejecucion)   throw new Error("No deberias de llamar este metodo");
        return procesos.pop();
    }
    
    public void clear(){
        if(this != Ejecucion)   throw new Error("No deberias de llamar este metodo");
        proceso = null;
    }
    
    public void add(Proceso proceso){
        if(proceso == null)  throw new Error("No puedes agregar null");
        proceso.setEstado(this);
        if(this != Ejecucion)   procesos.add(proceso);
        else                    this.proceso = proceso;
    }
    
    public boolean isEmpty(){
        if(this == Ejecucion)   return proceso == null;
        return procesos.isEmpty();
    }
    
    public int size(){
        if(this == Ejecucion)  throw new Error("No deberias de llamar este metodo");
        return procesos.size();
    }
    
    public void remove(Proceso proceso){
        if(this == Ejecucion)   throw new Error("No deberias de llamar este metodo");
        if(proceso == null)     throw new Error("No puedes agregar null");
        procesos.remove(proceso);
    }
}
