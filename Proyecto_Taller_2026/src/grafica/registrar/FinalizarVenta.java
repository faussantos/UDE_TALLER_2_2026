package grafica.registrar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class FinalizarVenta {

	private JFrame frmFinalizarVenta;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinalizarVenta window = new FinalizarVenta();
					window.frmFinalizarVenta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FinalizarVenta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFinalizarVenta = new JFrame();
		frmFinalizarVenta.setTitle("Finalizar venta");
		frmFinalizarVenta.setBounds(100, 100, 450, 300);
		frmFinalizarVenta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFinalizarVenta.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingrese el numero que identifica a la venta");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 10, 378, 32);
		frmFinalizarVenta.getContentPane().add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("CONFIRMAR");
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton.setFont(new Font("Arial", Font.BOLD, 11));
		rdbtnNewRadioButton.setBounds(209, 160, 129, 23);
		frmFinalizarVenta.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("CANCELAR");
		rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton_1.setFont(new Font("Arial", Font.BOLD, 11));
		rdbtnNewRadioButton_1.setBounds(78, 160, 129, 23);
		frmFinalizarVenta.getContentPane().add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Numero de venta:");
		lblNewLabel_2_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2_2.setBounds(10, 86, 112, 16);
		frmFinalizarVenta.getContentPane().add(lblNewLabel_2_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(132, 85, 96, 19);
		frmFinalizarVenta.getContentPane().add(textField_1);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAceptar.setBounds(341, 232, 85, 21);
		frmFinalizarVenta.getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 232, 85, 21);
		frmFinalizarVenta.getContentPane().add(btnCancelar);
	}
}