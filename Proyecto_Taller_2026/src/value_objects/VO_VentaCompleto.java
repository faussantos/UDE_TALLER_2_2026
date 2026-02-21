package value_objects;

import java.time.LocalDate;

public class VO_VentaCompleto extends VO_VentaBasico {
	private int numero;
	private boolean enProceso;
	private double monto;
	
	public VO_VentaCompleto(LocalDate fe, String dire, int num, boolean enProc, double mont) {
		super(fe,dire);
		numero = num;
		enProceso = enProc;
		monto = mont;
	}

	public int getNumero() {
		return numero;
	}

	public boolean getEnProceso() {
		return enProceso;
	}

	public double getMonto() {
		return monto;
	}
	
	

}
