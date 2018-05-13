/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssio02_Lotes;

import java.util.Collections;
import java.util.Comparator;
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
    
    public void OrdenarPorId(){
        Collections.sort((LinkedList<Proceso>)procesos, new Comparator<Proceso>(){
            @Override
            public int compare(Proceso p1, Proceso p2){
                 if(p1.getId() < p2.getId()){
                    return -1; 
                 }
                 if(p1.getId() > p2.getId ()){
                    return 1; 
                 }
                 return 0;
            }
         }); 
    }
}
