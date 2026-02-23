package logica;

import logica.postres.*;
import logica.ventas.*;
import value_objects.*;

public class CapaLogica {

	private Ventas secVentas;
	private Postres dicPostres;

	public CapaLogica() {
		secVentas = new Ventas();
		dicPostres = new Postres();
	}

	public void AltaPostre(VO_Postre datosPostre) {
		Postre postre;

		if (datosPostre.getTipo().equals("Light")) {
			VO_Light datosLight = (VO_Light) datosPostre;
			postre = new Light(datosLight.getCodigo(), datosLight.getNombre(), datosLight.getPrecio(),
					datosLight.getEndulzante(), datosLight.getDescripcion());
		} else {
			postre = new Postre(datosPostre.getCodigo(), datosPostre.getNombre(), datosPostre.getPrecio());
		}

		dicPostres.Insert(postre);
	}

	public VO_Postre[] ListadoPostres() {
		return dicPostres.ListarPostres();
	}

	public VO_Postre detallePostre() {
	}

	public void inicioVenta(VO_VentaBasico datosVenta) {
	}

	public void agregarPostreEnVenta(VO_DetalleVenta datosDetalle) {
	}

	public void eliminarPostreEnVenta(VO_VentaBasico datosVenta) {
	}

	public void finalizarVenta(VO_FinalizarVenta datosFinalizarVenta) {
	}

	public VO_VentaCompleto[] listadoVentas() {
		return secVentas.ListarVentas();
	}

	public VO_PostreCantidad[] listadoPostresEnVenta(int num)  {
	}

	public VO_CantidadMonto totalMontoPostreYFecha(VO_PostreFecha datos) {
	}
	
	public void respaldarDatos() {
	}
	
	public void recuperarDatos() {}
	}

}
