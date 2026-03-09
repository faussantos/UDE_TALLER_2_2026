package grafica.controladores;

import excepciones.NoExisteNumeroVentaException;
import grafica.listados.ListadoDetallesEnVenta;
import grafica.listados.ListadoVentas;
import value_objects.VO_NumeroVenta;
import value_objects.VO_PostreCantidad;

public class ListadoDetallesEnVentaController extends Controller {

	private ListadoDetallesEnVenta ventana;

	public ListadoDetallesEnVentaController(ListadoDetallesEnVenta ven) {
		super();
		ventana = ven;
	}

	public void listadoDetallesEnVenta(int numeroVenta) {
		VO_NumeroVenta datosVenta = new VO_NumeroVenta(numeroVenta);
		
		try {
			VO_PostreCantidad[] listadoDetalles = capaLogica.listadoPostresEnVenta(datosVenta);
			ventana.mostrarDetalles(listadoDetalles);
		} catch (NoExisteNumeroVentaException e) {
			ventana.mostrarError(e.darMensaje());
		} catch (Exception e) {
			ventana.mostrarError("Ha ocurrido un error inesperado: " + e.getMessage());
		} 
	}
}
