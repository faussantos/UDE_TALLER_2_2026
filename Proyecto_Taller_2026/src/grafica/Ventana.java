package grafica;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import grafica.registrar.AgregarPostreEnVenta;


public class Ventana {
	protected JFrame _frame;
	
	public Ventana () {
		_frame = new JFrame();
	}
	
	public void mostrarError(String mensaje) {
		JOptionPane.showMessageDialog(_frame, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public void mostrarExito(String mensaje) {
	    JOptionPane.showMessageDialog(_frame, mensaje,
	        "Éxito", JOptionPane.INFORMATION_MESSAGE);
	}
	
public void mensajeVentaCreada (int numeroVenta) {
		
		String[] opciones = {"Sí", "No"};
	    int respuesta = JOptionPane.showOptionDialog(
	        _frame,
	        "Venta número " + numeroVenta + " creada correctamente. ¿Desea agregar postres?",
	        "Éxito",
	        JOptionPane.YES_NO_OPTION,
	        JOptionPane.INFORMATION_MESSAGE,
	        null,
	        opciones,
	        opciones[0]
	    );
	    if (respuesta == 0) {
	        new AgregarPostreEnVenta(numeroVenta);
	    }
	}
}
