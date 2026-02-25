package excepciones;

public class VentaNoEnProcesoException extends Exception {
	
	private String mensaje;
	private static final long serialVersionUID = 1L;

	public VentaNoEnProcesoException(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String darMensaje() {
		return mensaje;
	}
}
