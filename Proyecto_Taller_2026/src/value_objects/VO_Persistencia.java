package value_objects;

import logica.postres.*;
import logica.ventas.*;
public class VO_Persistencia extends ValueObject{
		
	private Postres postres;
	private Ventas ventas;
	
	public Postres getPostres() {
		return postres;
	}
	public Ventas getVentas() {
		return ventas;
	}

}
