package grafica.registrar;

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

	private JTextField textFieldCodigoPostre;
	private JTextField textFieldNumeroVenta;
	private EliminarPostreEnVentaController _controller;

	public EliminarPostreEnVenta() {
		super("Eliminar postre de la venta");
		_controller = new EliminarPostreEnVentaController(this);
		initialize();
	}

	private void initialize() {
		_frame.setBounds(100, 100, 490, 279);

		JLabel lblIngreseLosDatos = new JLabel("Ingrese los datos");
		lblIngreseLosDatos.setHorizontalAlignment(SwingConstants.TRAILING);
		lblIngreseLosDatos.setFont(new Font("Arial", Font.BOLD, 15));
		lblIngreseLosDatos.setBounds(10, 10, 134, 22);
		_frame.getContentPane().add(lblIngreseLosDatos);

		JLabel lblCodigoPostre = new JLabel("Código de postre:");
		lblCodigoPostre.setFont(new Font("Arial", Font.PLAIN, 13));
		lblCodigoPostre.setBounds(20, 61, 124, 16);
		_frame.getContentPane().add(lblCodigoPostre);

		textFieldCodigoPostre = new JTextField();
		textFieldCodigoPostre.setColumns(10);
		textFieldCodigoPostre.setBounds(164, 60, 240, 19);
		_frame.getContentPane().add(textFieldCodigoPostre);

		JLabel lblCantidad = new JLabel("Cantidad de unidades:");
		lblCantidad.setFont(new Font("Arial", Font.PLAIN, 13));
		lblCantidad.setBounds(20, 87, 134, 16);
		_frame.getContentPane().add(lblCantidad);

		JComboBox<Integer> comboBox = new JComboBox<>();
		for (int i = 1; i <= 40; i++) {
			comboBox.addItem(i);
		}
		comboBox.setBounds(164, 85, 50, 21);
		_frame.getContentPane().add(comboBox);

		JLabel lblNumeroVenta = new JLabel("Numero de venta:");
		lblNumeroVenta.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNumeroVenta.setBounds(20, 113, 112, 16);
		_frame.getContentPane().add(lblNumeroVenta);

		textFieldNumeroVenta = new JTextField();
		textFieldNumeroVenta.setBounds(164, 112, 96, 19);
		_frame.getContentPane().add(textFieldNumeroVenta);
		textFieldNumeroVenta.setColumns(10);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(381, 211, 85, 21);
		_frame.getContentPane().add(btnAceptar);
		
		btnAceptar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String codigoPostre = textFieldCodigoPostre.getText().trim();
		        int cantidad = (Integer) comboBox.getSelectedItem();
		        String numeroVenta = textFieldNumeroVenta.getText();
		        
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
		      
		        _controller.eliminarPostreEnVenta(cantidad, codigoPostre, numeroVentaInt);
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
