package logica.ventas;
import java.time.LocalDate;
import logica.ventas.DetalleVenta;
import java.util.*;

public class Venta {
	
	private int numero;
	private LocalDate fecha;
	private String direccion;
	private boolean enProceso;
	private double monto;
	
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
	
	
}
