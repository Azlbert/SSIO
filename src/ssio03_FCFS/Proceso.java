/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssio03_FCFS;

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
    
    private long tiempoLlegada;
    private long tiempoFinalizacion;
    private long primeraVezAtendido;
    
    // Generara autamaticamente los valores del proceso
    public Proceso(){
        // Guardara solo los identificadores unicos
        int id;
        do{
            id = rnd.nextInt(99999);
        }while(ID_AGREGADOS.contains(id));
        this.id = id;
        this.existeError = false;
        tiempoLlegada = tiempoFinalizacion = primeraVezAtendido = 0;
        
        this.operacion = Operacion.values()[rnd.nextInt((Operacion.residuo.ordinal()))];
        this.valor1 = (double) Math.round((rnd.nextDouble()*100) * 100) / 100;
        double valor2 = (double) Math.round((rnd.nextDouble()*100) * 100) / 100;
        this.valor2 = (this.operacion == Operacion.division || this.operacion == Operacion.residuo) ? valor2 + 0.1f : valor2;
        this.tiempoMaximoEstimado = rnd.nextInt(1500) + 50;
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
        this.tiempoRestante = tiempoRestante;
    }

    public long getTiempoLlegada() {
        return tiempoLlegada;
    }

    public void setTiempoLlegada(long tiempoLlegada) {
        if(this.tiempoLlegada == 0)    this.tiempoLlegada = tiempoLlegada;
    }

    public long getTiempoFinalizacion() {
        return tiempoFinalizacion;
    }

    public void setTiempoFinalizacion(long tiempoFinalizacion) {
        this.tiempoFinalizacion = tiempoFinalizacion;
    }

    public long getTiempoRetorno() {
        return tiempoFinalizacion - tiempoLlegada;
    }

    public void setPrimeraVezAtendido(long primeraVezAtendido) {
        if(this.primeraVezAtendido == 0)    this.primeraVezAtendido = primeraVezAtendido;
    }
    
    public long getTiempoRespuesta() {
        return primeraVezAtendido - tiempoLlegada;
    }

    public long getTiempoEspera() {
        return getTiempoRetorno() - getTiempoServicio();
    }

    public long getTiempoServicio() {
        System.out.println(tiempoMaximoEstimado + " - Tiempo restante " + tiempoRestante);
        return tiempoMaximoEstimado - tiempoRestante;
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
