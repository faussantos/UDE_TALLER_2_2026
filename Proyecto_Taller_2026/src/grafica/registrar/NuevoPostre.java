package grafica.registrar;

import java.awt.Font;
import javax.swing.SwingConstants;

import grafica.Ventana;
import grafica.controladores.NuevoPostreController;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.*;

public class NuevoPostre extends Ventana {

	private JTextField textFieldCodigoPostre;
	private JTextField textFieldNombrePostre;
	private JTextField textFieldPrecio;
	private JTextField txtFieldEndulzante;
	private JTextField txtFieldDescripcion;
	private NuevoPostreController _controller;

	/**
	 * Create the application.
	 */
	public NuevoPostre() {
		super("Registro de postre");
		_controller = new NuevoPostreController(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		_frame.setBounds(100, 100, 479, 384);
		
		// TITULO
		JLabel lblNewLabel_1 = new JLabel("Ingrese los datos del nuevo postre");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 32, 270, 22);
		_frame.getContentPane().add(lblNewLabel_1);

		// CODIGO POSTRE
		JLabel lblCodigoPostre = new JLabel("Código:");
		lblCodigoPostre.setFont(new Font("Arial", Font.PLAIN, 13));
		lblCodigoPostre.setBounds(39, 69, 86, 16);
		_frame.getContentPane().add(lblCodigoPostre);

		textFieldCodigoPostre = new JTextField();
		textFieldCodigoPostre.setBounds(114, 68, 250, 19);
		_frame.getContentPane().add(textFieldCodigoPostre);
		textFieldCodigoPostre.setColumns(10);
		// CODIGO POSTRE

		// NOMBRE POSTRE
		JLabel lblNombrePostre = new JLabel("Nombre: ");
		lblNombrePostre.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNombrePostre.setBounds(39, 97, 86, 16);
		_frame.getContentPane().add(lblNombrePostre);

		textFieldNombrePostre = new JTextField();
		textFieldNombrePostre.setColumns(10);
		textFieldNombrePostre.setBounds(114, 96, 250, 19);
		_frame.getContentPane().add(textFieldNombrePostre);
		// NOMBRE POSTRE

		// PRECIO
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Arial", Font.PLAIN, 13));
		lblPrecio.setBounds(39, 124, 86, 16);
		_frame.getContentPane().add(lblPrecio);

		textFieldPrecio = new JTextField();
		textFieldPrecio.setColumns(10);
		textFieldPrecio.setBounds(114, 123, 250, 19);
		_frame.getContentPane().add(textFieldPrecio);
		// PRECIO

		// CHECKBOX LIGHT
		JCheckBox chckbxLight = new JCheckBox("Light");
		chckbxLight.setFont(new Font("Arial", Font.PLAIN, 13));
		chckbxLight.setBounds(114, 165, 93, 21);
		_frame.getContentPane().add(chckbxLight);
		// CHECKBOX LIGHT

		// DATOS LIGHT
		JLabel lblEndulzante = new JLabel("Endulzante:");
		lblEndulzante.setFont(new Font("Arial", Font.PLAIN, 13));
		lblEndulzante.setBounds(20, 213, 86, 16);
		_frame.getContentPane().add(lblEndulzante);

		JLabel lblDescripcion = new JLabel("Descirpción:");
		lblDescripcion.setFont(new Font("Arial", Font.PLAIN, 13));
		lblDescripcion.setBounds(20, 250, 86, 16);
		_frame.getContentPane().add(lblDescripcion);

		txtFieldEndulzante = new JTextField();
		txtFieldEndulzante.setColumns(10);
		txtFieldEndulzante.setBounds(114, 210, 250, 19);
		_frame.getContentPane().add(txtFieldEndulzante);

		txtFieldDescripcion = new JTextField();
		txtFieldDescripcion.setColumns(10);
		txtFieldDescripcion.setBounds(114, 247, 250, 19);
		_frame.getContentPane().add(txtFieldDescripcion);
		// DATOS LIGHT

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_frame.dispose();
			}
		});
		btnCancelar.setBounds(10, 316, 85, 21);
		_frame.getContentPane().add(btnCancelar);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigo = textFieldCodigoPostre.getText();
				String nombre = textFieldNombrePostre.getText();
				String precio = textFieldPrecio.getText();
				if (codigo.isEmpty() || nombre.isEmpty() || precio.isEmpty()) {
					mostrarError("Todos los campos son obligatorios.");
					return;
				}

				double precioDouble;
				try {
					precioDouble = Double.parseDouble(precio);
				} catch (NumberFormatException ex) {
					mostrarError("El precio debe ser un número.");
					return;
				}

				boolean light = chckbxLight.isSelected();
				String endulzante = txtFieldEndulzante.getText();
				String descripcion = txtFieldDescripcion.getText();

				if (light) {
					if (endulzante.isEmpty() || descripcion.isEmpty()) {
						mostrarError("Debe ingresar el endulzante y la descripción para un postre light.");
						return;
					}
				}

				_controller.NuevoPostre(codigo, nombre, precioDouble, light, endulzante, descripcion);
			}
		});
		btnAceptar.setBounds(367, 316, 85, 21);
		_frame.getContentPane().add(btnAceptar);

		lblEndulzante.setVisible(false);
		txtFieldEndulzante.setVisible(false);
		lblDescripcion.setVisible(false);
		txtFieldDescripcion.setVisible(false);

		chckbxLight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean marcado = chckbxLight.isSelected();
				lblEndulzante.setVisible(marcado);
				txtFieldEndulzante.setVisible(marcado);
				lblDescripcion.setVisible(marcado);
				txtFieldDescripcion.setVisible(marcado);
			}
		});

		_frame.setVisible(true);
	}
}
