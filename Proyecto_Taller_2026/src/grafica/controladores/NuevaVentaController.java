package grafica.controladores;

import java.time.LocalDate;

import grafica.registrar.NuevaVenta;
import logica.ICapaLogica;
import value_objects.VO_VentaBasico;

public class NuevaVentaController {
	private ICapaLogica capaLogica;
	private NuevaVenta ventana;

	public NuevaVentaController() {

	}

	public void NuevaVenta(LocalDate fecha, String direccion) {
		try {
			VO_VentaBasico datosVenta = new VO_VentaBasico(fecha, direccion);
			capaLogica.inicioVenta(datosVenta);

		} catch (Exception e) {

		}
	}
}
