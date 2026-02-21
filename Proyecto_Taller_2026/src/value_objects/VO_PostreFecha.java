package value_objects;

import java.time.LocalDate;

public class VO_PostreFecha {
	
	private String codigo;
	private LocalDate fecha;
	
	public VO_PostreFecha(String cod, LocalDate fe) {
		codigo = cod;
		fecha = fe;
	}

	public String getCodigo() {
		return codigo;
	}

	public LocalDate getFecha() {
		return fecha;
	}
	

}
