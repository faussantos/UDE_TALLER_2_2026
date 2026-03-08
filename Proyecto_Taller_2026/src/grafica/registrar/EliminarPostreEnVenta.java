package grafica.registrar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import grafica.Ventana;
import grafica.controladores.EliminarPostreEnVentaController;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class EliminarPostreEnVenta extends Ventana {

	private JTextField textField;
	private JTextField textField_1;
	private EliminarPostreEnVentaController _controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarPostreEnVenta window = new EliminarPostreEnVenta();
					window._frame.setVisible(true);
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
		super("Eliminar postre de la venta");
		_controller = new EliminarPostreEnVentaController(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		_frame.setBounds(100, 100, 490, 279);

		JLabel lblNewLabel_1 = new JLabel("Ingrese los datos");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 10, 134, 22);
		_frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Código de postre:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(20, 61, 124, 16);
		_frame.getContentPane().add(lblNewLabel_2);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(164, 60, 240, 19);
		_frame.getContentPane().add(textField);

		JLabel lblNewLabel_2_1 = new JLabel("Cantidad de unidades:");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(20, 87, 134, 16);
		_frame.getContentPane().add(lblNewLabel_2_1);

		JComboBox<Integer> comboBox = new JComboBox<>();
		for (int i = 1; i <= 40; i++) {
			comboBox.addItem(i);
		}
		comboBox.setBounds(164, 85, 50, 21);
		_frame.getContentPane().add(comboBox);

		JLabel lblNewLabel_2_2 = new JLabel("Numero de venta:");
		lblNewLabel_2_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2_2.setBounds(20, 113, 112, 16);
		_frame.getContentPane().add(lblNewLabel_2_2);

		textField_1 = new JTextField();
		textField_1.setBounds(164, 112, 96, 19);
		_frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(381, 211, 85, 21);
		_frame.getContentPane().add(btnAceptar);
		
		btnAceptar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String codigoPostre = textField.getText().trim();
		        int cantidad = (Integer) comboBox.getSelectedItem();
		        String numeroVenta = textField_1.getText();
		        
		        if (codigoPostre.isEmpty()) {
		            mostrarError("El codigo de postre es obligatorio.");
		            return;
		        }
		        
		        if (numeroVenta.isEmpty()) {
		            mostrarError("El número de venta es obligatorio.");
		            return;
		        }
		        
		        int numeroVentaInt;
		        try {
		        	numeroVentaInt = Integer.parseInt(numeroVenta);
		        } catch (NumberFormatException ex) {
		            mostrarError("El número de venta debe ser un número entero.");
		            return;
		        }
		      
		        _controller.EliminarPostreEnVenta(cantidad, codigoPostre, numeroVentaInt);
		    }
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 211, 85, 21);
		_frame.getContentPane().add(btnCancelar);
		
		btnCancelar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	_frame.dispose();
		    }
		});
		
		_frame.setVisible(true);
	}
}
