package excepciones;

public class FechaMayorUltimaVentaException extends Exception {

	private String mensaje;
	private static final long serialVersionUID = 1L;

	public FechaMayorUltimaVentaException(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String darMensaje() {
		return mensaje;
	}
}
