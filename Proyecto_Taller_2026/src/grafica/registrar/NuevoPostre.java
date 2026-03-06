package grafica.Registrar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.*;

public class NuevoPostre {

	private JFrame frmRegistroDePostre;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtFieldEndulzante;
	private JTextField txtFieldDescripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoPostre window = new NuevoPostre();
					window.frmRegistroDePostre.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NuevoPostre() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistroDePostre = new JFrame();
		frmRegistroDePostre.setTitle("Registro de postre");
		frmRegistroDePostre.setBounds(100, 100, 479, 384);
		frmRegistroDePostre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistroDePostre.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese los datos del nuevo postre");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 32, 270, 22);
		frmRegistroDePostre.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Código:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(39, 69, 86, 16);
		frmRegistroDePostre.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(114, 68, 250, 19);
		frmRegistroDePostre.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nombre: ");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(39, 97, 86, 16);
		frmRegistroDePostre.getContentPane().add(lblNewLabel_2_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(114, 96, 250, 19);
		frmRegistroDePostre.getContentPane().add(textField_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Precio:");
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2_1_1.setBounds(39, 124, 86, 16);
		frmRegistroDePostre.getContentPane().add(lblNewLabel_2_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(114, 123, 250, 19);
		frmRegistroDePostre.getContentPane().add(textField_2);
		
		JCheckBox chckbxLight = new JCheckBox("Light");
		chckbxLight.setFont(new Font("Arial", Font.PLAIN, 13));
		chckbxLight.setBounds(114, 165, 93, 21);
		frmRegistroDePostre.getContentPane().add(chckbxLight);
		
		JLabel lblEndulzante = new JLabel("Endulzante:");
		lblEndulzante.setFont(new Font("Arial", Font.PLAIN, 13));
		lblEndulzante.setBounds(20, 213, 86, 16);
		frmRegistroDePostre.getContentPane().add(lblEndulzante);
		
		JLabel lblDescripcion = new JLabel("Descirpción:");
		lblDescripcion.setFont(new Font("Arial", Font.PLAIN, 13));
		lblDescripcion.setBounds(20, 250, 86, 16);
		frmRegistroDePostre.getContentPane().add(lblDescripcion);
		
		 txtFieldEndulzante = new JTextField();
		txtFieldEndulzante.setColumns(10);
		txtFieldEndulzante.setBounds(114, 210, 250, 19);
		frmRegistroDePostre.getContentPane().add(txtFieldEndulzante);
		
		txtFieldDescripcion = new JTextField();
		txtFieldDescripcion.setColumns(10);
		txtFieldDescripcion.setBounds(114, 247, 250, 19);
		frmRegistroDePostre.getContentPane().add(txtFieldDescripcion);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 316, 85, 21);
		frmRegistroDePostre.getContentPane().add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(367, 316, 85, 21);
		frmRegistroDePostre.getContentPane().add(btnAceptar);
		
		lblEndulzante.setVisible(false);
		txtFieldEndulzante.setVisible(false);
		lblDescripcion.setVisible(false);
		txtFieldDescripcion.setVisible(false);
		
		chckbxLight.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					boolean marcado = chckbxLight.isSelected();
				    lblEndulzante.setVisible(marcado);
				    txtFieldEndulzante.setVisible(marcado);
				    lblDescripcion.setVisible(marcado);
				    txtFieldDescripcion.setVisible(marcado);
				}
			});
		
		frmRegistroDePostre.setVisible(true);
	}
}
