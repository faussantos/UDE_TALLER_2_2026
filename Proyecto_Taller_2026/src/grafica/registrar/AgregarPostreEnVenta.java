package grafica.registrar;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import grafica.Ventana;
import grafica.controladores.AgregarPostreEnVentaController;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;

public class AgregarPostreEnVenta extends Ventana {

	private JTextField textFieldCodigoPostre;
	private JTextField textFieldNumeroVenta;
	AgregarPostreEnVentaController _controller;

	/**
	 * Create the application.
	 */
	public AgregarPostreEnVenta() {
		super("Agregar postre a venta");
		_controller = new AgregarPostreEnVentaController(this);
		initialize();
	}
	
	public AgregarPostreEnVenta(int numeroVenta) {
		super("Agregar postre a venta");
	    initialize();
		_controller = new AgregarPostreEnVentaController(this);
	    textFieldNumeroVenta.setText(String.valueOf(numeroVenta));
	    textFieldNumeroVenta.setEditable(false);
	    _frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		_frame.setBounds(100, 100, 440, 279);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese los datos");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 10, 134, 22);
		_frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Código de postre:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(20, 95, 124, 16);
		_frame.getContentPane().add(lblNewLabel_2);
		
		textFieldCodigoPostre = new JTextField();
		textFieldCodigoPostre.setColumns(10);
		textFieldCodigoPostre.setBounds(141, 94, 189, 19);
		_frame.getContentPane().add(textFieldCodigoPostre);
		
		JLabel lblNewLabel_2_1 = new JLabel("Cantidad de unidades:");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(20, 68, 134, 16);
		_frame.getContentPane().add(lblNewLabel_2_1);
		
		JComboBox<Integer> comboBox = new JComboBox<>();
		for(int i = 1 ; i<=40; i++ ) {
			comboBox.addItem(i);
		}
		comboBox.setBounds(164, 66, 50, 21);
		_frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_2_2 = new JLabel("Numero de venta:");
		lblNewLabel_2_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2_2.setBounds(20, 40, 112, 16);
		_frame.getContentPane().add(lblNewLabel_2_2);
		
		textFieldNumeroVenta = new JTextField();
		textFieldNumeroVenta.setBounds(133, 39, 22, 19);
		_frame.getContentPane().add(textFieldNumeroVenta);
		textFieldNumeroVenta.setColumns(10);
		
		JButton btnFinalizarVenta = new JButton("Finalizar venta");
		btnFinalizarVenta.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String numeroVentaStr = textFieldNumeroVenta.getText().trim();
		        
		        if (numeroVentaStr.isEmpty()) {
		            mostrarError("El número de venta es obligatorio.");
		            return;
		        }
		        
		        int numeroVenta;
		        try {
		            numeroVenta = Integer.parseInt(numeroVentaStr);
		        } catch (NumberFormatException ex) {
		            mostrarError("El número de venta debe ser un número entero.");
		            return;
		        }
		        
		        new FinalizarVenta(numeroVenta);
		    }
		});
		btnFinalizarVenta.setBounds(292, 179, 124, 21);
		_frame.getContentPane().add(btnFinalizarVenta);
		
		JButton btnAgregarPostre = new JButton("Agregar Postre");
		btnAgregarPostre.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        
		        String codigoPostre = textFieldCodigoPostre.getText();
		        String numeroVentaStr = textFieldNumeroVenta.getText();
		        int cantidad = (Integer) comboBox.getSelectedItem();

		        if (numeroVentaStr.isEmpty()) {
		        	mostrarError("El número de venta es obligatorio.");
		        	return;
		        }
		        if (codigoPostre.isEmpty()) {
		            mostrarError("El código de postre es obligatorio.");
		            return;
		        }

		        int numeroVenta;
		        try {
		            numeroVenta = Integer.parseInt(numeroVentaStr);
		        } catch (NumberFormatException ex) {
		            mostrarError("El número de venta debe ser un número entero.");
		            return;
		        }

		        _controller.agregarPostre(codigoPostre, cantidad, numeroVenta);
		    }
		});
		btnAgregarPostre.setBounds(150, 179, 132, 21);
		_frame.getContentPane().add(btnAgregarPostre);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        _frame.dispose();
		    }
		});
		btnCancelar.setBounds(10, 179, 85, 21);
		_frame.getContentPane().add(btnCancelar);
		
		_frame.setVisible(true);
	}
}
