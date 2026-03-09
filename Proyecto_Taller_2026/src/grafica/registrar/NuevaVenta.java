package grafica.registrar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.*;

import grafica.Ventana;
import grafica.controladores.NuevaVentaController;

import java.awt.*; 

public class NuevaVenta extends Ventana {

	private JTextField textFieldDireccion;
	private NuevaVentaController _controller;
	
	/**
	 * Create the application.
	 */
	public NuevaVenta() {
		super("Registro de venta");
		_controller = new NuevaVentaController(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		_frame.setBounds(100, 100, 431, 241);
		
		JLabel lblTitulo = new JLabel("Ingrese los datos de la nueva venta:");
		lblTitulo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 15));
		lblTitulo.setBounds(10, 10, 270, 22);
		_frame.getContentPane().add(lblTitulo);
		
		//DIRECCION
		JLabel lblDireccion = new JLabel("Direccion :");
		lblDireccion.setFont(new Font("Arial", Font.PLAIN, 13));
		lblDireccion.setBounds(39, 53, 86, 16);
		_frame.getContentPane().add(lblDireccion);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setBounds(114, 52, 250, 19);
		_frame.getContentPane().add(textFieldDireccion);
		textFieldDireccion.setColumns(10);
		//DIRECCION
		
		//FECHA
		JLabel lblFecha = new JLabel("Fecha: ");
		lblFecha.setFont(new Font("Arial", Font.PLAIN, 13));
		lblFecha.setBounds(39, 94, 86, 16);
		_frame.getContentPane().add(lblFecha);
		
		Integer[] dias = new Integer[31];
		for (int i = 0; i < 31; i++) {
		    dias[i] = i + 1;
		}
		JComboBox<Integer> comboDia = new JComboBox<>();
		for(Integer dia : dias) {
			comboDia.addItem(dia);
		}
		comboDia.setBounds(114, 92, 43, 21);
		_frame.getContentPane().add(comboDia);
		
		
		String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
		
		JComboBox<AUX_Mes> comboMes = new JComboBox<>();
		int numeroMes = 1;
		for(String mes : meses) {
			AUX_Mes mesItem = new AUX_Mes(numeroMes, mes);
			comboMes.addItem(mesItem);
			numeroMes++;
		}
		comboMes.setBounds(167, 92, 89, 21);
		_frame.getContentPane().add(comboMes);
		
		
		Integer[] anios = new Integer[10];
		for (int i = 0; i < 10; i++) {
		    anios[i] = 2020 + i;
		}
		JComboBox<Integer> comboAnio = new JComboBox<>();
		for(Integer anio : anios) {
			comboAnio.addItem(anio);
		}
		comboAnio.setBounds(266, 92, 56, 21);
		_frame.getContentPane().add(comboAnio);
		//FECHA
		
		LocalDate hoy = LocalDate.now();
		comboDia.setSelectedItem(hoy.getDayOfMonth());
		comboMes.setSelectedIndex(hoy.getMonthValue() - 1);
		comboAnio.setSelectedItem(hoy.getYear());
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	_frame.dispose();
		    }
		});
		btnCancelar.setBounds(10, 163, 85, 21);
		_frame.getContentPane().add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(313, 163, 85, 21);
		_frame.getContentPane().add(btnAceptar);
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String direccion = textFieldDireccion.getText();
				
				int dia = (Integer) comboDia.getSelectedItem();
				AUX_Mes mesTexto = (AUX_Mes)comboMes.getSelectedItem();
				int anio = (Integer) comboAnio.getSelectedItem();
				
				LocalDate fecha = LocalDate.of(anio, mesTexto.getNumero(), dia);
				
				if (direccion.isEmpty()) {
				    mostrarError("La dirección es obligatoria.");
				    return;
				}
				_controller.NuevaVenta(fecha, direccion);
			}
		});
		
		_frame.setVisible(true);
	}
	
	public void mensajeVentaCreada(int numeroVenta) {

		String[] opciones = { "Sí", "No" };
		int respuesta = JOptionPane.showOptionDialog(_frame,
				"Venta número " + numeroVenta + " creada correctamente. ¿Desea agregar postres?", "Éxito",
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
		if (respuesta == 0) {
			new AgregarPostreEnVenta(numeroVenta);
		}
	}
}