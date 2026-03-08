package grafica.registrar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import grafica.controladores.FinalizarVentaController;

public class FinalizarVenta {

	private JFrame frmFinalizarVenta;
	private JTextField textFieldNumeroVenta;
	private FinalizarVentaController _controller;

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
	    _controller = new FinalizarVentaController(this);
		initialize();
	}
	
	public FinalizarVenta(int numeroVenta) {
	    _controller = new FinalizarVentaController(this);
	    initialize();
	    textFieldNumeroVenta.setText(String.valueOf(numeroVenta));
	    textFieldNumeroVenta.setEditable(false);
	    frmFinalizarVenta.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFinalizarVenta = new JFrame();
		frmFinalizarVenta.setTitle("Finalizar venta");
		frmFinalizarVenta.setBounds(100, 100, 450, 300);
		frmFinalizarVenta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmFinalizarVenta.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingrese el numero que identifica a la venta");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 10, 378, 32);
		frmFinalizarVenta.getContentPane().add(lblNewLabel);
		
		JRadioButton rdbtnConfirmar = new JRadioButton("CONFIRMAR");
		rdbtnConfirmar.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnConfirmar.setFont(new Font("Arial", Font.BOLD, 11));
		rdbtnConfirmar.setBounds(209, 160, 129, 23);
		frmFinalizarVenta.getContentPane().add(rdbtnConfirmar);
		
		JRadioButton rdbtnCancelar = new JRadioButton("CANCELAR");
		rdbtnCancelar.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnCancelar.setFont(new Font("Arial", Font.BOLD, 11));
		rdbtnCancelar.setBounds(78, 160, 129, 23);
		frmFinalizarVenta.getContentPane().add(rdbtnCancelar);
		
		ButtonGroup grupoBotones = new ButtonGroup();
		grupoBotones.add(rdbtnConfirmar);
		grupoBotones.add(rdbtnCancelar);
		rdbtnConfirmar.setSelected(true);
		
		JLabel lblNewLabel_2_2 = new JLabel("Numero de venta:");
		lblNewLabel_2_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2_2.setBounds(10, 86, 112, 16);
		frmFinalizarVenta.getContentPane().add(lblNewLabel_2_2);
		
		textFieldNumeroVenta = new JTextField();
		textFieldNumeroVenta.setColumns(10);
		textFieldNumeroVenta.setBounds(132, 85, 34, 19);
		frmFinalizarVenta.getContentPane().add(textFieldNumeroVenta);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAceptar.setBounds(341, 232, 85, 21);
		frmFinalizarVenta.getContentPane().add(btnAceptar);
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
		frmFinalizarVenta.getContentPane().add(btnCancelar);
	}
	
	public void mostrarError(String mensaje) {
	    JOptionPane.showMessageDialog(frmFinalizarVenta, mensaje,
	        "Error", JOptionPane.ERROR_MESSAGE);
	}

	public void mostrarExito(String mensaje) {
	    JOptionPane.showMessageDialog(frmFinalizarVenta, mensaje,
	        "Éxito", JOptionPane.INFORMATION_MESSAGE);
	}
}