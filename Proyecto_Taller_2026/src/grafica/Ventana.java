package grafica;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Ventana {
	protected JFrame _frame;
	
	public Ventana () {
		_frame = new JFrame();
	}
	
	public void mostrarError(String mensaje) {
		JOptionPane.showMessageDialog(_frame, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
}
