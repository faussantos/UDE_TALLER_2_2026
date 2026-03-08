package grafica.registrar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import grafica.Ventana;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class EliminarPostreEnVenta extends Ventana {

	private JFrame frmEliminarPostre;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarPostreEnVenta window = new EliminarPostreEnVenta();
					window.frmEliminarPostre.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EliminarPostreEnVenta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEliminarPostre = new JFrame();
		frmEliminarPostre.setTitle("Eliminar postre de la venta");
		frmEliminarPostre.setBounds(100, 100, 490, 279);
		frmEliminarPostre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEliminarPostre.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese los datos");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 10, 134, 22);
		frmEliminarPostre.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Código de postre:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(20, 61, 124, 16);
		frmEliminarPostre.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(164, 60, 240, 19);
		frmEliminarPostre.getContentPane().add(textField);
		
		JLabel lblNewLabel_2_1 = new JLabel("Cantidad de unidades:");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(20, 87, 134, 16);
		frmEliminarPostre.getContentPane().add(lblNewLabel_2_1);
		
		JComboBox<Integer> comboBox = new JComboBox<>();
		for(int i = 1 ; i<=40; i++ ) {
			comboBox.addItem(i);
		}
		comboBox.setBounds(164, 85, 50, 21);
		frmEliminarPostre.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_2_2 = new JLabel("Numero de venta:");
		lblNewLabel_2_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2_2.setBounds(20, 113, 112, 16);
		frmEliminarPostre.getContentPane().add(lblNewLabel_2_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(164, 112, 96, 19);
		frmEliminarPostre.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(381, 211, 85, 21);
		frmEliminarPostre.getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 211, 85, 21);
		frmEliminarPostre.getContentPane().add(btnCancelar);
	}

}
