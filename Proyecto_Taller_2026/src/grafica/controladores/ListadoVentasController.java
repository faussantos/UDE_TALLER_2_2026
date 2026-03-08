package grafica.controladores;

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
			ventana.mostrarError(e.darMensaje());
		} catch (NullPointerException e) {
			ventana.mostrarError("No existen registros del tipo de venta seleccionado");
		} catch (Exception e) {
			ventana.mostrarError("Ha ocurrido un error inesperado: " + e.getMessage());
		}
	}
}