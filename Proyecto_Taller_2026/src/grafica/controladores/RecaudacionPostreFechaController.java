package grafica.controladores;

import grafica.consultar.RecaudacionPostreFecha;
import grafica.listados.ListadoDetallesEnVenta;
import value_objects.VO_CantidadMonto;
import value_objects.VO_PostreFecha;

public class RecaudacionPostreFechaController extends Controller {

	private RecaudacionPostreFecha ventana;

	public RecaudacionPostreFechaController(RecaudacionPostreFecha ven) {
		super();
		ventana = ven;
	}
	
	public VO_CantidadMonto RecaudacionPostreFecha(VO_PostreFecha datosPostreFecha) {
		VO_CantidadMonto datosCantidadMonto = null;
		
		try {
			datosCantidadMonto = capaLogica.totalMontoPostreYFecha(datosPostreFecha);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return datosCantidadMonto;
	}
}
