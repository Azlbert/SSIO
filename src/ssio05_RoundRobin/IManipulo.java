
package ssio05_RoundRobin;

/**
 *
 * @author Usuario
 */
public interface IManipulo {
    public void agregarProcesoListos(int id, long tme, long tr);
    public void agregarProcesoTerminado(int id, String operacion, String resultado);
    public void agregarProcesoBloqueado(int id, long tt);
    public void eliminarPrimerProcesoDeListos();
    public void eliminarPrimerProcesoBloqueado();
    public void actualizarContadorProceosNuevos(int numeroDeProceos);
    public void actualizarReloj(int minutos, int segundos, int milisegundos);
    public void ejecutarSiguienteProceso(int id, long TME, String operacion);
    public void actualizarTiemposDelProcesoEnEjecucion(long tt, long tr);
    public void actualizarTiempoRestanteDeBloqueados(int row, long tiempo);
    public void borrarProcesoEnEjecucion();
    public void actualizarQuantum(long quantumTranscurrido);
}
