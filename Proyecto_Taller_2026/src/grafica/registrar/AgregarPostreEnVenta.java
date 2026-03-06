package grafica.registrar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class AgregarPostreEnVenta {

	private JFrame frmAgregarPostreA;
	private JTextField textField;
	private JTextField textField_1;

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
		frmAgregarPostreA.setTitle("Agregar postre a venta");
		frmAgregarPostreA.setBounds(100, 100, 395, 247);
		frmAgregarPostreA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgregarPostreA.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese los datos");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 10, 134, 22);
		frmAgregarPostreA.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Código de postre:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(20, 42, 124, 16);
		frmAgregarPostreA.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(131, 42, 240, 19);
		frmAgregarPostreA.getContentPane().add(textField);
		
		JLabel lblNewLabel_2_1 = new JLabel("Cantidad de unidades:");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(20, 68, 134, 16);
		frmAgregarPostreA.getContentPane().add(lblNewLabel_2_1);
		
		JComboBox<Integer> comboBox = new JComboBox<>();
		for(int i = 1 ; i<=40; i++ ) {
			comboBox.addItem(i);
		}
		comboBox.setBounds(164, 66, 50, 21);
		frmAgregarPostreA.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_2_2 = new JLabel("Numero de venta:");
		lblNewLabel_2_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2_2.setBounds(20, 94, 112, 16);
		frmAgregarPostreA.getContentPane().add(lblNewLabel_2_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(133, 93, 96, 19);
		frmAgregarPostreA.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(286, 179, 85, 21);
		frmAgregarPostreA.getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 179, 85, 21);
		frmAgregarPostreA.getContentPane().add(btnCancelar);
	}

}
