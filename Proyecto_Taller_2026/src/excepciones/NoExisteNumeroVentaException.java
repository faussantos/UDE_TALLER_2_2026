package excepciones;

public class NoExisteNumeroVenta extends Exception {

	private String mensaje;
	private static final long serialVersionUID = 1L;

	public NoExisteNumeroVenta(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String darMensaje() {
		return mensaje;
	}
}
