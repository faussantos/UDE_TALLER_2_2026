package logica.ventas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;

public class Venta {

	private int numero;
	private LocalDate fecha;
	private String direccion;
	private boolean enProceso;
	private double monto;
	private ArrayList<DetalleVenta> detalles;

	public int getNumero() {
		return numero;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public String getDireccion() {
		return direccion;
	}

	public boolean getEnProceso() {
		return enProceso;
	}

	public double getMonto() {
		return monto;
	}

	public ArrayList<DetalleVenta> getDetalles() {
		return detalles;
	}
	
	public DetalleVenta getDetalle(String codigo) {
		DetalleVenta detalleDevolver = null;
		
		for(DetalleVenta det: detalles) {
			if(det.getPostre().getCodigo().equals(codigo)) {
				detalleDevolver = det;
			}
		}
		
		return detalleDevolver;
	}

	public boolean ExisteDetalle(String codigo) {
		boolean existe = false;

		for (DetalleVenta det : detalles) {
			if (det.getPostre().getCodigo().equals(codigo)) {
				existe = true;
				break;
			}
		}

		return existe;
	}
}
