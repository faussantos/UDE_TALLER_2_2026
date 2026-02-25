package excepciones;

public class VentaNoEnProcesoException extends Exception {
	
	private String mensaje;

	public VentaNoEnProcesoException(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String darMensaje() {
		return mensaje;
	}
}
