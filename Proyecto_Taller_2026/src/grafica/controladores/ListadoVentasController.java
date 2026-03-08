package grafica.controladores;

import java.rmi.RemoteException;

import excepciones.IndicacionInvalidaException;
import grafica.listados.*;
import value_objects.*;

public class ListadoVentasController extends Controller {

	private ListadoVentas ventana;

	public ListadoVentasController(ListadoVentas ven) {
		super();
		ventana = ven;
	}

	public void listarVentas(char indicacion) {
		try {
			VO_IndicacionListado datosIndicacion = new VO_IndicacionListado(indicacion);
			VO_VentaCompleto[] ventas = capaLogica.listadoVentas(datosIndicacion);
			ventana.mostrarVentas(ventas);
		} catch (IndicacionInvalidaException e) {
			ventana.mostrarError(e.getMessage());
		} catch (RemoteException e) {
			ventana.mostrarError("Error de conexión con el servidor.");
		} catch (NullPointerException e) {
			ventana.mostrarError("No hay ventas cargadas");
		} catch (Exception e) {
			ventana.mostrarError("Error inesperado: " + e.getMessage());
		}
	}
}