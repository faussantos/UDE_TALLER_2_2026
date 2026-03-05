package grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class AgregarPostreEnVenta {

	private JFrame frmAgregarPostreA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarPostreEnVenta window = new AgregarPostreEnVenta();
					window.frmAgregarPostreA.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AgregarPostreEnVenta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgregarPostreA = new JFrame();
		frmAgregarPostreA.setTitle("Agregar postre a la venta");
		frmAgregarPostreA.setBounds(100, 100, 450, 300);
		frmAgregarPostreA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
