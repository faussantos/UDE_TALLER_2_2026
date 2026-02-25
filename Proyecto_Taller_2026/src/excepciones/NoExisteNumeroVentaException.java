package excepciones;

public class NoExisteNumeroVentaException extends Exception {

	private String mensaje;

	public NoExisteNumeroVentaException(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String darMensaje() {
		return mensaje;
	}
}
