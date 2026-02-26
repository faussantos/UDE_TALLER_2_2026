package grafica;

import java.time.LocalDate;

import logica.*;
import value_objects.*;

public class Grafica {

	public static void main(String args[]) {

		CapaLogica cp = new CapaLogica();

		try {

			// req 1 AltaPostre
			System.out.println("REQUERIMIENTO 1");
			VO_Postre datosPostre = new VO_Postre("123", "Bola de fraile", 50);
			cp.AltaPostre(datosPostre);

			VO_Light datosPostreLight = new VO_Light("321", "Bola de fraile pero light", 300, "stevia", "un asco");
			cp.AltaPostre(datosPostreLight);

			// req 2 ListadoPostres
			System.out.println("REQUERIMIENTO 2");
			VO_Postre[] postresListados = cp.ListadoPostres();
			for (VO_Postre vo_Postre : postresListados) {
				System.out.println(vo_Postre.getCodigo() + " | " + vo_Postre.getNombre() + " | " + vo_Postre.getPrecio()
						+ " | " + vo_Postre.getTipo());
			}

			// req 3 detallePostre
			System.out.println("REQUERIMIENTO 3");
			VO_CodigoPostre voCodigoPostre = new VO_CodigoPostre("321");
			VO_Postre detallePostre = cp.detallePostre(voCodigoPostre);

			if (detallePostre instanceof VO_Light) {
				System.out.println(detallePostre.getCodigo() + " | " + detallePostre.getNombre() + " | "
						+ detallePostre.getPrecio() + " | " + detallePostre.getTipo() + " | "
						+ ((VO_Light) detallePostre).getEndulzante() + " | "
						+ ((VO_Light) detallePostre).getDescripcion());
			} else {
				System.out.println(detallePostre.getCodigo() + " | " + detallePostre.getNombre() + " | "
						+ detallePostre.getPrecio() + " | " + detallePostre.getTipo());
			}

			// req 4 inicioVenta
			System.out.println("REQUERIMIENTO 4");
			LocalDate ld = LocalDate.of(2025, 2, 25);
			VO_VentaBasico datosVenta = new VO_VentaBasico(ld, "mi casa");

			cp.inicioVenta(datosVenta);

			// req 5 agregarPostreEnVenta
			System.out.println("REQUERIMIENTO 5");
			VO_DetalleVenta detalleAgregar = new VO_DetalleVenta(10, datosPostre.getCodigo(), 1);
			cp.agregarPostreEnVenta(detalleAgregar);

			// req 6 eliminarPostreEnVenta
			System.out.println("REQUERIMIENTO 6");
			VO_DetalleVenta detalleEliminar = new VO_DetalleVenta(5, datosPostre.getCodigo(), 1);
			cp.eliminarPostreEnVenta(detalleEliminar);

			// req 7 finalizarVenta
			System.out.println("REQUERIMIENTO 7");
			VO_FinalizarVenta finalVenta = new VO_FinalizarVenta(1, true);
			VO_ConfirmacionVentaFinalizada confirmacion = cp.finalizarVenta(finalVenta);
			System.out.println(confirmacion.getMonto());

			// req 8 listadoVentas
			System.out.println("REQUERIMIENTO 8");
			VO_IndicacionListado indicacion = new VO_IndicacionListado('T');
			VO_VentaCompleto[] listadoVentas = cp.listadoVentas(indicacion);

			for (VO_VentaCompleto ven : listadoVentas) {
				System.out.println(ven.getFecha() + " | " + ven.getDireccion() + " | " + ven.getNumero() + " | "
						+ ven.getEnProceso() + " | " + ven.getMonto());
			}

			// req 9 listadoPostresEnVenta
			System.out.println("REQUERIMIENTO 9");
			VO_NumeroVenta num = new VO_NumeroVenta(1);
			VO_PostreCantidad[] listado = cp.listadoPostresEnVenta(num);

			for (VO_PostreCantidad pos : listado) {
				System.out.println(pos.getCodigo() + " | " + pos.getNombre() + " | " + pos.getPrecio() + " | "
						+ pos.getTipo() + " | " + pos.getCantidad());
			}

			// req 10 totalMontoPostreYFecha
			System.out.println("REQUERIMIENTO 10");
			VO_PostreFecha datosPostreFecha = new VO_PostreFecha(datosPostre.getCodigo(), ld);
			VO_CantidadMonto cantidadMonto = cp.totalMontoPostreYFecha(datosPostreFecha);
			System.out.println("cantidad: " + cantidadMonto.getCantidad());
			System.out.println("monto: " + cantidadMonto.getMonto());
			
			// req 11 respaldarDatos
			System.out.println("REQUERIMIENTO 11");
			cp.respaldarDatos();
			
			// req 12 recuperarDatos
			System.out.println("REQUERIMIENTO 12");
			cp.recuperarDatos();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
