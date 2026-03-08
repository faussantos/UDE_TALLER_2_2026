package grafica.controladores;

import java.time.LocalDate;

import excepciones.FechaMayorHoyException;
import excepciones.NoExistePostreException;
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

	public VO_CantidadMonto RecaudacionPostreFecha(String codigo, LocalDate fecha) {
		
		VO_PostreFecha datosPostreFecha = new VO_PostreFecha(codigo, fecha);
		VO_CantidadMonto datosCantidadMonto = null;
		
		try {
			datosCantidadMonto = capaLogica.totalMontoPostreYFecha(datosPostreFecha);

		} catch (FechaMayorHoyException e) {
			ventana.mostrarError(e.darMensaje());
		} catch (NoExistePostreException e) {
			ventana.mostrarError(e.darMensaje());
		} catch (Exception e) {
			ventana.mostrarError("Ha ocurrido un error inesperado: " + e.getMessage());
		}

		return datosCantidadMonto;
	}
}
