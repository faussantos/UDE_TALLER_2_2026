package grafica.registrar;

import java.awt.EventQueue;
import java.time.LocalDate;

import javax.swing.*;
import java.awt.*; 



public class NuevaVenta {

	private JFrame frmRegistroDeVenta;
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevaVenta window = new NuevaVenta();
					window.frmRegistroDeVenta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NuevaVenta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistroDeVenta = new JFrame();
		frmRegistroDeVenta.setTitle("Registro de venta");
		frmRegistroDeVenta.setBounds(100, 100, 431, 241);
		frmRegistroDeVenta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistroDeVenta.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese los datos de la nueva venta:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 10, 270, 22);
		frmRegistroDeVenta.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Direccion :");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(39, 53, 86, 16);
		frmRegistroDeVenta.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(114, 52, 250, 19);
		frmRegistroDeVenta.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Fecha: ");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(39, 94, 86, 16);
		frmRegistroDeVenta.getContentPane().add(lblNewLabel_2_1);
		
		
		Integer[] dias = new Integer[31];
		for (int i = 0; i < 31; i++) {
		    dias[i] = i + 1;
		}
		JComboBox<Integer> comboDia = new JComboBox<>();
		for(Integer dia : dias) {
			comboDia.addItem(dia);
		}
		comboDia.setBounds(114, 92, 43, 21);
		frmRegistroDeVenta.getContentPane().add(comboDia);
		
		
		String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
		JComboBox<String> comboMes = new JComboBox<>();
		for(String mes : meses) {
			comboMes.addItem(mes);
		}
		comboMes.setBounds(167, 92, 89, 21);
		frmRegistroDeVenta.getContentPane().add(comboMes);
		
		
		Integer[] anios = new Integer[10];
		for (int i = 0; i < 10; i++) {
		    anios[i] = 2020 + i;
		}
		JComboBox<Integer> comboAnio = new JComboBox<>();
		for(Integer anio : anios) {
			comboAnio.addItem(anio);
		}
		comboAnio.setBounds(266, 92, 56, 21);
		frmRegistroDeVenta.getContentPane().add(comboAnio);

		
		LocalDate hoy = LocalDate.now();
		comboDia.setSelectedItem(hoy.getDayOfMonth());
		comboMes.setSelectedIndex(hoy.getMonthValue() - 1);
		comboAnio.setSelectedItem(hoy.getYear());
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 163, 85, 21);
		frmRegistroDeVenta.getContentPane().add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(313, 163, 85, 21);
		frmRegistroDeVenta.getContentPane().add(btnAceptar);
	}
}
