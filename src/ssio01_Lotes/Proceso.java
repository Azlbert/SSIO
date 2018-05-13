/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssio01_Lotes;

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
    
    public static ArrayList<Integer> idGuardados = new ArrayList<>();
    
    public Proceso(Integer id, String nm, double v1, Operacion operacion, double v2, long tme){
        this.id = id;
        this.nombreProgramador = nm;
        this.valor1 = v1;
        this.operacion = operacion;
        this.valor2 = v2;
        this.tiempoMaximoEstimado = tme;
        this.idGuardados.add(id);
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
    
    public double getResultado(){
        switch(operacion){
            case suma:
                return valor1 + valor2;
            case resta:
                return valor1 - valor2;
            case multiplicacion:
                return valor1 * valor2;
            case division:
                return valor1 / valor2;
            case residuo:
                return valor1 % valor2;
        }
        return 0;
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