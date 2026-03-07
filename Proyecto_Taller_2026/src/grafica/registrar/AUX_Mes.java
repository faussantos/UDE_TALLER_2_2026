package grafica.registrar;

public class AUX_Mes {

	int numero;
	String nombre;

	public AUX_Mes(int numero, String nombre) {
		this.numero = numero;
		this.nombre = nombre;
	}

	public int getNumero() {
		return numero;
	}

	@Override
	public String toString() {
		return nombre; // lo que se muestra en el JComboBox
	}

}
