package grafica.controladores;

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

	public void ListadoDetallesEnVenta(VO_NumeroVenta datosVenta) {
		try {
			VO_PostreCantidad[] listadoDetalles = capaLogica.listadoPostresEnVenta(datosVenta);
			ventana.mostrarDetalles(listadoDetalles);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
