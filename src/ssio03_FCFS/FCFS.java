/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssio03_FCFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TimerTask;

/**
 *
 * @author Usuario
 */
public class FCFS extends TimerTask{
    private byte miliSegundos = 0;
    private byte segundos = 0;
    private byte minutos = 0;
    private long tiempoTotal = 0;
    private long _Tinicio = 0;
    private long _tme = 0;
    private final long _tb = 1000;
    
    private final LinkedList<Proceso> procesosNuevos;
    private final LinkedList<Proceso> procesosListos;
    private final Map<Proceso, Long> procesosBloqueados;
    private final LinkedList<Proceso> procesosTerminados;
    private Proceso procesoEnEjecucion;

    private final int maximoDeProcesosEnMemoria = 6;
    
    private final IManipulo manipular;
    private Estado estado;
    
    public FCFS(IManipulo manipular){
        this.manipular = manipular;
        this.estado = Estado.Esperando;
        procesosNuevos = new LinkedList<>();
        procesosListos = new LinkedList<>();
        procesosBloqueados = new HashMap<>();
        procesosTerminados = new LinkedList<>();
    }
    
    @Override
    public void run() {
        if(estado == Estado.Esperando || estado == Estado.Pausa){
            return;
        } else if(procesoEnEjecucion == null && procesosListos.isEmpty() && procesosBloqueados.isEmpty() && procesosNuevos.isEmpty()){
            estado = Estado.Esperando;
            return;
        }
        
        miliSegundos++;
        tiempoTotal++;
        ajustarTiempo();
        manipular.actualizarReloj(minutos, segundos, miliSegundos);
        
        ajustarProcesos();
        ajustarBloqueados();
        if(procesoEnEjecucion == null)  return;
        switch (estado) {
            case Ejecucion:
                long tiempoTranscurrido = tiempoTotal - _Tinicio;
                manipular.actualizarTiemposDelProcesoEnEjecucion(tiempoTranscurrido,(_tme-tiempoTranscurrido));
                if(tiempoTranscurrido > _tme)
                    terminarProcesoEnEjecucion(0);
                break;
            case Interrupcion:
                bloquearProcesoEnEjecucion(_tme - (tiempoTotal - _Tinicio));
                break;
            case Error:
                procesoEnEjecucion.reportarError();
                terminarProcesoEnEjecucion(_tme - (tiempoTotal - _Tinicio));
        }
        estado = Estado.Ejecucion;
    }

    private void ajustarTiempo(){
        if(miliSegundos == 100){
            miliSegundos= 0;
            segundos++;
            if(segundos == 60){
                segundos = 0;
                minutos++;
                if(minutos > 999){
                    minutos = 0;
                }
            }
        }
    }
    
    private void ajustarProcesos(){
        Proceso proceso;
        while(!memoriaLlena() && !procesosNuevos.isEmpty()){
            proceso = procesosNuevos.pop();
            proceso.setTiempoLlegada(tiempoTotal);
            procesosListos.add(proceso);
            
            manipular.actualizarContadorProceosNuevos(procesosNuevos.size());
            manipular.agregarProcesoListos(proceso.getId(), proceso.getTiempoMaximoEstimado(), proceso.getTiempoRestante());
        }
        
        if(procesoEnEjecucion == null && !procesosListos.isEmpty()){
            procesoEnEjecucion = procesosListos.pop();
            _tme = procesoEnEjecucion.getTiempoRestante();
            procesoEnEjecucion.setPrimeraVezAtendido((_Tinicio = tiempoTotal));
            
            manipular.ejecutarSiguienteProceso(procesoEnEjecucion.getId(), 
                procesoEnEjecucion.getTiempoMaximoEstimado(), 
                procesoEnEjecucion.getOperacion());
        }
    }
    
    private void ajustarBloqueados(){
        if(procesosBloqueados.isEmpty())    return;
        
        LinkedList<Proceso>terminados = new LinkedList<>();
        int row = 0;
        for (Map.Entry<Proceso, Long> entry : procesosBloqueados.entrySet()) {
            long value = entry.getValue();
            if(value > tiempoTotal){
                entry.setValue(value);
                manipular.actualizarTiempoRestanteDeBloqueados(row, value-tiempoTotal);
            }else{
                desbloquearProceso(entry.getKey());
                terminados.add(entry.getKey());
            }
            row++;
        }
        
        terminados.forEach((terminado) -> { procesosBloqueados.remove(terminado); });
    }
    
    private void terminarProcesoEnEjecucion(long tiempoRestante){
        if(procesoEnEjecucion == null)  return;
        procesoEnEjecucion.setTiempoRestante(tiempoRestante);
        procesosTerminados.add(procesoEnEjecucion);
        procesoEnEjecucion.setTiempoFinalizacion(tiempoTotal);
        
        manipular.borrarProcesoEnEjecucion();
        manipular.agregarProcesoTerminado(procesoEnEjecucion.getId(), 
                    procesoEnEjecucion.getOperacion(), 
                    procesoEnEjecucion.getResultado());
        procesoEnEjecucion = null;
    }
    
    private void bloquearProcesoEnEjecucion(long tiempoRestante){
        procesoEnEjecucion.setTiempoRestante(tiempoRestante);
        procesosBloqueados.put(procesoEnEjecucion, tiempoTotal + _tb);
        
        manipular.borrarProcesoEnEjecucion();
        manipular.agregarProcesoBloqueado(procesoEnEjecucion.getId(), _tb);
        procesoEnEjecucion = null;
    }
    
    private void desbloquearProceso(Proceso proceso){
        procesosListos.add(proceso);
        
        manipular.eliminarPrimerProcesoBloqueado();
        manipular.agregarProcesoListos(proceso.getId(), proceso.getTiempoMaximoEstimado(), proceso.getTiempoRestante());
    }
    
    private boolean memoriaLlena(){
        int enMemoria = procesosListos.size();
        enMemoria += procesosBloqueados.size();
        if(procesoEnEjecucion != null)  enMemoria++;
        return enMemoria >= maximoDeProcesosEnMemoria;
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
            procesosListos.add(proceso);
            manipular.agregarProcesoListos(proceso.getId(), proceso.getTiempoMaximoEstimado(), proceso.getTiempoRestante());
        } else {
            procesosNuevos.add(proceso);
            manipular.actualizarContadorProceosNuevos(procesosNuevos.size());
        }
    }
    
    public void crearProcesosAleatorios(int numeroDeProcesos){
        for (int i = 0; i < numeroDeProcesos; i++)
            crearNuevoProcesoAleatorio();
    }
    
    public LinkedList<Proceso> getProcesosTerminados(){
        return procesosTerminados;
    }
}

enum Estado{
    Esperando,
    Ejecucion,
    Pausa,
    Interrupcion,
    Error
}
