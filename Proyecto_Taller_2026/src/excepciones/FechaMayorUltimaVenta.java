package excepciones;

public class FechaMayorUltimaVenta extends Exception {

	private String mensaje;
	private static final long serialVersionUID = 1L;

	public FechaMayorUltimaVenta(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String darMensaje() {
		return mensaje;
	}
}
