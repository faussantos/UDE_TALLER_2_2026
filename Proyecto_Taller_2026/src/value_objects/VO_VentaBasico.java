package value_objects;
import java.time.LocalDate;

public class VO_VentaBasico extends ValueObject{
	private LocalDate fecha;
	private String direccion;
	
	public VO_VentaBasico(LocalDate fe, String dire){
		fecha = fe;
		direccion = dire;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public String getDireccion() {
		return direccion;
	}
	
}
