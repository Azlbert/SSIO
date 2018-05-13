/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssio02_Lotes;

import java.util.ArrayList;

/**
 *
 * @author Alberto
 */
public class Proceso {
    private final int id;
    private final String nombreProgramador;
    private final double valor1;
    private final Operacion operacion;
    private final double valor2;
    private final long tiempoMaximoEstimado;
    private long tiempoRestante;
    private boolean existeError;
    
    public static ArrayList<Integer> idGuardados = new ArrayList<>();
    
    public Proceso(Integer id, String nm, double v1, Operacion operacion, double v2, long tme){
        this.id = id;
        this.nombreProgramador = nm;
        this.valor1 = v1;
        this.operacion = operacion;
        this.valor2 = v2;
        this.tiempoMaximoEstimado = tme;
        this.idGuardados.add(id);
        this.tiempoRestante = this.tiempoMaximoEstimado;
        this.existeError = false;
    }

    public int getId() {
        return id;
    }

    public String getNombreProgramador() {
        return nombreProgramador;
    }

    public String getOperacion() {
        return "" + valor1 + " " + operacion.string() + " " + valor2;
    }
    
    public long getTiempoRestante() {
        return tiempoRestante;
    }
    
    public void setTiempoRestante(long tiempoRestante) {
        this.tiempoRestante = tiempoRestante;
    }
    
    public String getResultado(){
        if(existeError){
            return "Error";
        }
        
        switch(operacion){
            case suma:
                return "" + (valor1 + valor2);
            case resta:
                return "" + (valor1 - valor2);
            case multiplicacion:
                return "" + (valor1 * valor2);
            case division:
                return "" + (valor1 / valor2);
            case residuo:
                return "" + (valor1 % valor2);
        }
        return "Error";
    }
    
    public void reportarError(){
        existeError = true;
    }

    public long getTiempoMaximoEstimado() {
        return tiempoMaximoEstimado;
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