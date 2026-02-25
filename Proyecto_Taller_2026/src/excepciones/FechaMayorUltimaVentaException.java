package excepciones;

public class FechaMayorUltimaVentaException extends Exception {

	private String mensaje;

	public FechaMayorUltimaVentaException(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String darMensaje() {
		return mensaje;
	}
}
