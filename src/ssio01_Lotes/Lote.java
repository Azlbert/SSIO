/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssio01_Lotes;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Alberto
 */
public class Lote {
    private Queue<Proceso> procesos = new LinkedList<>();
    
    public void agregarProceso(Proceso proceso){
        procesos.add(proceso);
    }
    
    public int numeroDeProcesos(){
        return procesos.size();
    }
    
    public Proceso dameSiguienteProceso(){
        return procesos.poll();
    }
    
    public boolean vacio(){
        return procesos.isEmpty();
    }
    
    public LinkedList<Proceso> getProcesos(){
        return (LinkedList)procesos;
    }
}
