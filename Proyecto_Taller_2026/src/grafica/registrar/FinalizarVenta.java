package grafica.registrar;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import grafica.Ventana;
import grafica.controladores.FinalizarVentaController;

public class FinalizarVenta extends Ventana{

	private JTextField textFieldNumeroVenta;
	private FinalizarVentaController _controller;

	public FinalizarVenta() {
		super("Finalizar venta");
	    _controller = new FinalizarVentaController(this);
		initialize();
	}
	
	public FinalizarVenta(int numeroVenta) {
		super("Finalizar venta");
	    _controller = new FinalizarVentaController(this);
	    initialize();
	    textFieldNumeroVenta.setText(String.valueOf(numeroVenta));
	    textFieldNumeroVenta.setEditable(false);
	    _frame.setVisible(true);
	}

	private void initialize() {
		_frame.setBounds(100, 100, 450, 300);
		
		JLabel lblMensajeIngreso = new JLabel("Ingrese el numero que identifica a la venta");
		lblMensajeIngreso.setFont(new Font("Arial", Font.BOLD, 15));
		lblMensajeIngreso.setBounds(10, 10, 378, 32);
		_frame.getContentPane().add(lblMensajeIngreso);
		
		JRadioButton rdbtnConfirmar = new JRadioButton("CONFIRMAR");
		rdbtnConfirmar.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnConfirmar.setFont(new Font("Arial", Font.BOLD, 11));
		rdbtnConfirmar.setBounds(209, 160, 129, 23);
		_frame.getContentPane().add(rdbtnConfirmar);
		
		JRadioButton rdbtnCancelar = new JRadioButton("CANCELAR");
		rdbtnCancelar.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnCancelar.setFont(new Font("Arial", Font.BOLD, 11));
		rdbtnCancelar.setBounds(78, 160, 129, 23);
		_frame.getContentPane().add(rdbtnCancelar);
		
		ButtonGroup grupoBotones = new ButtonGroup();
		grupoBotones.add(rdbtnConfirmar);
		grupoBotones.add(rdbtnCancelar);
		rdbtnConfirmar.setSelected(true);
		
		JLabel lblNumeroVenta = new JLabel("Numero de venta:");
		lblNumeroVenta.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNumeroVenta.setBounds(10, 86, 112, 16);
		_frame.getContentPane().add(lblNumeroVenta);
		
		textFieldNumeroVenta = new JTextField();
		textFieldNumeroVenta.setColumns(10);
		textFieldNumeroVenta.setBounds(132, 85, 34, 19);
		_frame.getContentPane().add(textFieldNumeroVenta);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAceptar.setBounds(341, 232, 85, 21);
		_frame.getContentPane().add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
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
		        
		        boolean confirma = rdbtnConfirmar.isSelected();
		        _controller.finalizarVenta(numeroVenta, confirma);
		    }
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 232, 85, 21);
		_frame.getContentPane().add(btnCancelar);
		
		btnCancelar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	_frame.dispose();
		    }
		});
		
		_frame.setVisible(true);

	}
}