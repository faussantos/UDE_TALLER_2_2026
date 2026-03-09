package grafica.controladores;

import java.rmi.RemoteException;

import excepciones.CantidadNegativaException;
import excepciones.NoExisteNumeroVentaException;
import excepciones.NoExistePostreException;
import excepciones.VentaNoEnProcesoException;
import grafica.registrar.EliminarPostreEnVenta;
import grafica.registrar.FinalizarVenta;
import value_objects.VO_DetalleVenta;

public class EliminarPostreEnVentaController extends Controller {

	private EliminarPostreEnVenta ventana;

	public EliminarPostreEnVentaController(EliminarPostreEnVenta ven) {
		super();
		this.ventana = ven;
	}

	public void eliminarPostreEnVenta(int cantidad, String codigo, int numeroVenta) {
		try {

			VO_DetalleVenta datosDetalleVenta = new VO_DetalleVenta(cantidad, codigo, numeroVenta);
			capaLogica.eliminarPostreEnVenta(datosDetalleVenta);
			ventana.mostrarExito("Postre eliminado correctamente.");

		} catch (CantidadNegativaException e) {
			ventana.mostrarError(e.darMensaje());
		} catch (NoExisteNumeroVentaException e) {
			ventana.mostrarError(e.darMensaje());
		} catch (NoExistePostreException e) {
			ventana.mostrarError(e.darMensaje());
		} catch (VentaNoEnProcesoException e) {
			ventana.mostrarError(e.darMensaje());
		} catch (Exception e) {
			ventana.mostrarError("Ha ocurrido un error inesperado: " + e.getMessage());
		}
	}
}
