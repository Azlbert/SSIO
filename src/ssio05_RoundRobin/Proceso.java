/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssio05_RoundRobin;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Proceso {
    public static ArrayList<Integer> ID_AGREGADOS = new ArrayList<>();
    private static java.util.Random rnd = new java.util.Random();
    
    private final int id;
    private final double valor1;
    private final Operacion operacion;
    private final double valor2;
    private final long tiempoMaximoEstimado;
    private long tiempoRestante;
    private boolean existeError;
    
    private Procesos estado;
    
    private long tiempoLlegada = -1;
    private long tiempoFinalizacion = -1;
    private long primeraVezAtendido = -1;
    
    private long tiempoBloqueado = 0;
    
    // Generara autamaticamente los valores del proceso
    public Proceso(){
        // Guardara solo los identificadores unicos
        int id;
        do{
            id = rnd.nextInt(99999);
        }while(ID_AGREGADOS.contains(id));
        this.id = id;
        this.existeError = false;
        this.estado = Procesos.Nuevo;
        
        this.operacion = Operacion.values()[rnd.nextInt((Operacion.residuo.ordinal()))];
        this.valor1 = (double) Math.round((rnd.nextDouble()*100) * 100) / 100;
        double valor2 = (double) Math.round((rnd.nextDouble()*100) * 100) / 100;
        this.valor2 = (this.operacion == Operacion.division || this.operacion == Operacion.residuo) ? valor2 + 0.1f : valor2;
        this.tiempoMaximoEstimado = rnd.nextInt(650) + 50;
        this.tiempoRestante = this.tiempoMaximoEstimado;
        System.out.println("ID " + id + ":\t" + valor1 + " " + operacion.string() + " " + valor2 + "\t\tTME: " + tiempoMaximoEstimado);
    }
    
    public Proceso(Integer id, double v1, Operacion operacion, double v2, int tme){
        if(true)    throw new Error("Sin implementar");
        this.id = id;
        this.valor1 = v1;
        this.operacion = operacion;
        this.valor2 = v2;
        this.tiempoMaximoEstimado = tme;
        this.ID_AGREGADOS.add(id);
    }

    @Override
    public String toString() {
        if(estado != Procesos.Terminado)    return estado.toString();
        return estado.toString() + (existeError ? " con error" : "");
    }

    public int getId() {
        return id;
    }

    public String getOperacion() {
        return "" + valor1 + " " + operacion.string() + " " + valor2;
    }
    
    public String getResultado(){
        if(existeError) return "Error";
        switch(operacion){
            case suma:
                return "" + (valor1 + valor2);
            case resta:
                return "" + (valor1 - valor2);
            case multiplicacion:
                if(valor2 == 0){ throw new RuntimeException("Indefinido");}
                return "" + (valor1 * valor2);
            case division:
                if(valor2 == 0){ throw new RuntimeException("Indefinido");}
                return "" + Math.ceil(valor1 / valor2);
            case residuo:
                if(valor2 == 0){ throw new RuntimeException("Indefinido");}
                return "" + Math.ceil(valor1 % valor2);
        }
        return "Do you know da wae";
    }
    
    public void reportarError(){
        existeError = true;
    }

    public long getTiempoMaximoEstimado() {
        return tiempoMaximoEstimado;
    }
    
    public long getTiempoRestante() {
        return tiempoRestante;
    }
    
    public void setTiempoRestante(long tiempoRestante) {
        this.tiempoRestante = tiempoRestante < 0 ? 0 : tiempoRestante;
    }

    public long getTiempoLlegada() {
        return tiempoLlegada;
    }

    public void setTiempoLlegada(long tiempoLlegada) {
        if(this.tiempoLlegada == -1)    this.tiempoLlegada = tiempoLlegada;
    }
    
    public long getPrimeraVez(){
        return primeraVezAtendido;
    }

    public long getTiempoFinalizacion() {
        return estado == Procesos.Terminado ? tiempoFinalizacion : -1;
    }

    public void setTiempoFinalizacion(long tiempoFinalizacion) {
        this.tiempoFinalizacion = tiempoFinalizacion;
    }

    public long getTiempoRetorno() {
        return estado == Procesos.Terminado ? tiempoFinalizacion - tiempoLlegada : -1;
    }

    public void setPrimeraVezAtendido(long primeraVezAtendido) {
        if(primeraVezAtendido == -1)   return;
        this.primeraVezAtendido = primeraVezAtendido;
    }
    
    public long getTiempoRespuesta() {
        return estado != Procesos.Nuevo && primeraVezAtendido >= 0 ? primeraVezAtendido - tiempoLlegada : -1;
    }

    public long getTiempoEspera() {
        if(estado == Procesos.Nuevo)    return -1;
        return estado == Procesos.Terminado ? (getTiempoRetorno() - getTiempoServicio()) + getTiempoRespuesta()
                : (RoundRobin.tiempoTotal - tiempoLlegada) - getTiempoServicio();
    }

    public long getTiempoServicio() {
        return estado != Procesos.Nuevo ? tiempoMaximoEstimado - tiempoRestante : -1;
    }

    public long getTiempoBloqueado() {
        return tiempoBloqueado;
    }
    
    public long getTiempoBloqueadoActual(){
        return estado == Procesos.Bloqueado ? tiempoBloqueado - RoundRobin.tiempoTotal : -1;
    }

    public void setTiempoBloqueado(long tiempoBloqueado) {
        this.tiempoBloqueado = tiempoBloqueado;
    }

    public void setEstado(Procesos estado) {
        this.estado = estado;
    }
}

enum Operacion{
    suma("+"),
    resta("-"),
    multiplicacion("*"),
    division("/"),
    residuo("%");
    
    private String valor;
    
    private Operacion(String valor){
        this.valor = valor;
    }

    public String string() {
        return valor;
    }
}
