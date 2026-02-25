package logica.ventas;

import java.time.LocalDate;
import java.util.*;

import logica.postres.Postre;
import value_objects.*;

public class Venta {

	private int numero;
	private LocalDate fecha;
	private String direccion;
	private boolean enProceso;
	private double monto;
	private ArrayList<DetalleVenta> detalles;

	public Venta(LocalDate fech, String dir, boolean enProc, double mont) {
		numero = 0;
		fecha = fech;
		direccion = dir;
		enProceso = enProc;
		monto = mont;
		detalles = new ArrayList<>();
	}
	
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
				break;
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
	
	public int getTotalUnidades() {
		int total = 0;
		for(DetalleVenta det: detalles) {
			total = total + det.getCantidad();
		}
		return total;
	}
	
	public void setNumero(int num) {
		numero = num;
	}
	
	public void setEnProceso (boolean enProc) {
		enProceso = enProc;
	}
	
	public void ModificarDetalleLista(DetalleVenta det) {
		int index = detalles.indexOf(det);
		if(index != -1)
			detalles.set(index, det);
	}
	
	public void InsertarDetalle(DetalleVenta det) {
		detalles.add(det);
	}
	
	public void BorrarDetalle(String cod) {
		for(DetalleVenta det: detalles) {
			if(det.getPostre().getCodigo().equals(cod)) {
				detalles.remove(det);
				break;
			}
		}
	}
	
	public boolean DetallesEmpty () {
		return (detalles.isEmpty());
	}
	
	public VO_PostreCantidad[] ListarPostres() {
		VO_PostreCantidad[] arre = new VO_PostreCantidad[detalles.size()];
		int i = 0;
		for(DetalleVenta detalle : detalles) {
			Postre p = detalle.getPostre();
			arre[i] = new VO_PostreCantidad(p.getCodigo(), p.getNombre(), p.getPrecio(), detalle.getCantidad());
			i++;
		}
		return arre;
	}


}
