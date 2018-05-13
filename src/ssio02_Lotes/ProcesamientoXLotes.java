/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssio02_Lotes;

import java.util.LinkedList;

/**
 *
 * @author Alberto
 */
public class ProcesamientoXLotes {
    private static final int MAX_PROCESOSXLOTE = 6;
    
    private LinkedList<Lote> loteEnEjecucion = new LinkedList<>();
    private LinkedList<Lote> lotesTerminados = new LinkedList<>();
    
    // Punteros para los lotes
    private Lote primerLote;
    private Lote ultimoLote;
    private Lote ultimoLoteTerminado;
    
    private Proceso procesoEnEjecucion;
    
    public ProcesamientoXLotes(){
        ultimoLote = crearNuevoLote(LoteSeleccionado.EnEjecucion);
        primerLote = loteEnEjecucion.pollFirst();
        ultimoLoteTerminado = crearNuevoLote(LoteSeleccionado.Terminado);
    }
    
    public void agregarProceso(int id, String nm, double v1, Operacion op, double v2, long tme){
        if(primerLote == null){
            ultimoLote = crearNuevoLote(LoteSeleccionado.EnEjecucion);
            primerLote = loteEnEjecucion.pollFirst();
        }
        if(ultimoLote.numeroDeProcesos() == MAX_PROCESOSXLOTE){
            ultimoLote = crearNuevoLote(LoteSeleccionado.EnEjecucion);
        }
        ultimoLote.agregarProceso(new Proceso(id,nm,v1,op,v2,tme));
        ultimoLote.OrdenarPorId();
        System.out.println("Agregar Proceso");
    }
    
    // Informa si el ultimo proceso agregado es parte del primer lote
    public boolean esUltimoProcesoPrimerLote(){
        return primerLote == ultimoLote;
    }
    
    public int lotesPendientes(){
        return loteEnEjecucion.size();
    }
    
    public Proceso ejecutarSiguienteProceso(){
        if(primerLote == null || (primerLote.vacio() && 
                (primerLote = loteEnEjecucion.pollFirst()) == null)){
            return null; 
        }
        procesoEnEjecucion = primerLote.getProcesos().getFirst();
        return procesoEnEjecucion;
    }
    
    public Lote getPrimerLote(){
        return primerLote;
    }
    
    public void terminarProceso(){
        if(procesoEnEjecucion == null){
            return;
        }
        if(ultimoLoteTerminado.numeroDeProcesos() == MAX_PROCESOSXLOTE){
            crearNuevoLote(LoteSeleccionado.Terminado);
        }
        ultimoLoteTerminado.agregarProceso(primerLote.dameSiguienteProceso());
        procesoEnEjecucion = null;
    }
    
    private Lote crearNuevoLote(LoteSeleccionado loteSeleccionado){
        Lote loteNuevo = new Lote();
        switch(loteSeleccionado){
            case EnEjecucion:
                loteEnEjecucion.add(loteNuevo);
                System.out.println("\nCrear Nuevo Lote\n");
                break;
            case Terminado:
                lotesTerminados.add(loteNuevo);
                System.out.println("\nCrear Nuevo Lote Terminado\n");
                break;
        }
        return loteNuevo;
    }
    
    public void InterrumpirProceso(){
        primerLote.agregarProceso(primerLote.dameSiguienteProceso());
    }
    
    private enum LoteSeleccionado{
        EnEjecucion,
        Terminado
    }
}