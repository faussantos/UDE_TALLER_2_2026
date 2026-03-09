package grafica;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ventana {
	protected JFrame _frame;

	public Ventana(String titulo) {
		_frame = new JFrame();
		_frame.setTitle(titulo);
		_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		_frame.getContentPane().setLayout(null);
		_frame.setLocationRelativeTo(null);
	}

	public void mostrarError(String mensaje) {
		JOptionPane.showMessageDialog(_frame, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public void mostrarExito(String mensaje) {
		JOptionPane.showMessageDialog(_frame, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
	}
}
