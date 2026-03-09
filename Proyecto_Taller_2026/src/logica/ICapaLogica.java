package logica;

import java.rmi.Remote;
import java.rmi.RemoteException;
import value_objects.*;
import excepciones.*;

public interface ICapaLogica extends Remote {

	public void altaPostre(VO_Postre datosPostre)
			throws RemoteException, ExistePostreException, InterruptedException;

	public VO_Postre[] listadoPostres()
			throws RemoteException, InterruptedException;

	public VO_Postre detallePostre(VO_CodigoPostre codigoPostre)
			throws RemoteException, NoExistePostreException, InterruptedException;

	public int inicioVenta(VO_VentaBasico datosVenta)
			throws RemoteException, FechaMayorUltimaVentaException, InterruptedException;

	public void agregarPostreEnVenta(VO_DetalleVenta datosDetalle)
			throws RemoteException, CantidadNegativaException, CantidadMayor40Exception,
			NoExistePostreException, NoExisteNumeroVentaException, VentaNoEnProcesoException, InterruptedException;

	public void eliminarPostreEnVenta(VO_DetalleVenta datosDetalle)
			throws RemoteException, CantidadNegativaException, NoExisteNumeroVentaException,
			NoExistePostreException, VentaNoEnProcesoException, InterruptedException;

	public VO_ConfirmacionVentaFinalizada finalizarVenta(VO_FinalizarVenta datosFinalizarVenta)
			throws RemoteException, NoExisteNumeroVentaException, InterruptedException;

	public VO_VentaCompleto[] listadoVentas(VO_IndicacionListado datosIndicacion)
			throws RemoteException, IndicacionInvalidaException, InterruptedException;

	public VO_PostreCantidad[] listadoPostresEnVenta(VO_NumeroVenta datosNumeroVenta)
			throws RemoteException, NoExisteNumeroVentaException, InterruptedException;

	public VO_CantidadMonto totalMontoPostreYFecha(VO_PostreFecha datos)
			throws RemoteException, FechaMayorHoyException, NoExistePostreException, InterruptedException;

	public void respaldarDatos()
			throws RemoteException, PersistenciaException, InterruptedException;

	public void recuperarDatos()
			throws RemoteException, ClassNotFoundException, PersistenciaException, InterruptedException;
}