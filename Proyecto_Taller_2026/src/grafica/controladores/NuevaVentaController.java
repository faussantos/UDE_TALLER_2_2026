package grafica.controladores;

import java.time.LocalDate;
import excepciones.FechaMayorUltimaVentaException;
import grafica.registrar.NuevaVenta;
import value_objects.VO_VentaBasico;

public class NuevaVentaController extends Controller {
	private NuevaVenta ventana;

	public NuevaVentaController(NuevaVenta ven) {
		super();
		this.ventana = ven;

	}

	public void nuevaVenta(LocalDate fecha, String direccion) {
		try {
			VO_VentaBasico datosVenta = new VO_VentaBasico(fecha, direccion);
			int numeroVenta = capaLogica.inicioVenta(datosVenta).getNumero();
			ventana.mensajeVentaCreada(numeroVenta);
		} catch (FechaMayorUltimaVentaException e) {
			ventana.mostrarError(e.darMensaje());
		} catch (Exception e) {
            ventana.mostrarError("Ha ocurrido un error inesperado: " + e.getMessage());
        }
	}
}
