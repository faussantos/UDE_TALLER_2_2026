package excepciones;

public class NoExisteNumeroVenta extends Exception {
	private String mensaje;
	
	public NoExisteNumeroVenta(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String darMensaje() {
		return mensaje;
	}
}
