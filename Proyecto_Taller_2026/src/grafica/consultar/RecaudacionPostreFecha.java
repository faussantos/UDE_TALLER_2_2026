package grafica.consultar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JTextField;

import grafica.Ventana;
import grafica.controladores.RecaudacionPostreFechaController;
import grafica.registrar.AUX_Mes;
import value_objects.VO_CantidadMonto;
import value_objects.VO_CodigoPostre;
import value_objects.VO_Light;
import value_objects.VO_Postre;
import value_objects.VO_PostreFecha;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class RecaudacionPostreFecha extends Ventana{

	private JTextField textField;
	private RecaudacionPostreFechaController _controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecaudacionPostreFecha window = new RecaudacionPostreFecha();
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
	public RecaudacionPostreFecha() {
		super("Monto recaudado por postre en fecha");
		_controller = new RecaudacionPostreFechaController(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		_frame.setBounds(100, 100, 450, 300);

		JLabel lblIngreseLosDatos = new JLabel("Ingrese los datos:");
		lblIngreseLosDatos.setFont(new Font("Arial", Font.BOLD, 15));
		lblIngreseLosDatos.setBounds(10, 10, 378, 32);
		_frame.getContentPane().add(lblIngreseLosDatos);

		JLabel lblNewLabel_2_2 = new JLabel("Código:");
		lblNewLabel_2_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2_2.setBounds(10, 53, 112, 16);
		_frame.getContentPane().add(lblNewLabel_2_2);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(85, 52, 178, 19);
		_frame.getContentPane().add(textField);

		JLabel lblNewLabel_2_1 = new JLabel("Fecha: ");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(10, 95, 86, 16);
		_frame.getContentPane().add(lblNewLabel_2_1);

		Integer[] dias = new Integer[31];
		for (int i = 0; i < 31; i++) {
			dias[i] = i + 1;
		}
		JComboBox<Integer> comboDia = new JComboBox<>();
		for (Integer dia : dias) {
			comboDia.addItem(dia);
		}
		comboDia.setBounds(85, 93, 43, 21);
		_frame.getContentPane().add(comboDia);

		String[] meses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
				"Octubre", "Noviembre", "Diciembre" };

		JComboBox<AUX_Mes> comboMes = new JComboBox<>();
		int numeroMes = 1;
		for (String mes : meses) {
			AUX_Mes mesItem = new AUX_Mes(numeroMes, mes);
			comboMes.addItem(mesItem);
			numeroMes++;
		}
		comboMes.setBounds(138, 93, 89, 21);
		_frame.getContentPane().add(comboMes);

		Integer[] anios = new Integer[10];
		for (int i = 0; i < 10; i++) {
			anios[i] = 2020 + i;
		}
		JComboBox<Integer> comboAnio = new JComboBox<>();
		for (Integer anio : anios) {
			comboAnio.addItem(anio);
		}
		comboAnio.setBounds(237, 93, 56, 21);
		_frame.getContentPane().add(comboAnio);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(208, 124, 85, 21);
		_frame.getContentPane().add(btnAceptar);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(100, 124, 85, 21);
		_frame.getContentPane().add(btnCerrar);
		btnCerrar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	_frame.dispose();
		    }
		});

		JLabel lblTituloResultado = new JLabel("Resultado:");
		lblTituloResultado.setFont(new Font("Arial", Font.BOLD, 14));
		lblTituloResultado.setBounds(10, 159, 112, 13);
		_frame.getContentPane().add(lblTituloResultado);

		JLabel lblUnidades = new JLabel("Unidades vendidas:");
		lblUnidades.setFont(new Font("Arial", Font.PLAIN, 13));
		lblUnidades.setBounds(10, 182, 148, 13);
		_frame.getContentPane().add(lblUnidades);

		JLabel lblMonto = new JLabel("Monto total:");
		lblMonto.setFont(new Font("Arial", Font.PLAIN, 13));
		lblMonto.setBounds(10, 205, 86, 13);
		_frame.getContentPane().add(lblMonto);

		JLabel lblResultadoUnidades = new JLabel("ResuUnidades");
		lblResultadoUnidades.setFont(new Font("Arial", Font.PLAIN, 13));
		lblResultadoUnidades.setBounds(138, 182, 98, 13);
		_frame.getContentPane().add(lblResultadoUnidades);

		JLabel lblResultadoMonto = new JLabel("ResuMonto");
		lblResultadoMonto.setFont(new Font("Arial", Font.PLAIN, 13));
		lblResultadoMonto.setBounds(138, 205, 98, 13);
		_frame.getContentPane().add(lblResultadoMonto);

		lblUnidades.setVisible(false);
		lblMonto.setVisible(false);
		lblTituloResultado.setVisible(false);
		lblResultadoUnidades.setVisible(false);
		lblResultadoMonto.setVisible(false);

		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigo = textField.getText();

				int dia = (Integer) comboDia.getSelectedItem();
				AUX_Mes mesTexto = (AUX_Mes) comboMes.getSelectedItem();
				int anio = (Integer) comboAnio.getSelectedItem();

				LocalDate fecha = LocalDate.of(anio, mesTexto.getNumero(), dia);

				if (codigo.isEmpty()) {
					mostrarError("Todos los campos son obligatorios.");
					return;
				}

				VO_CantidadMonto datosCantidadMonto = _controller.RecaudacionPostreFecha(codigo, fecha);

				if (datosCantidadMonto != null) {
					lblUnidades.setVisible(true);
					lblMonto.setVisible(true);
					lblTituloResultado.setVisible(true);
					lblResultadoMonto.setVisible(true);
					lblResultadoUnidades.setVisible(true);

					lblResultadoMonto.setText(String.valueOf(datosCantidadMonto.getMonto()));
					lblResultadoUnidades.setText(String.valueOf(datosCantidadMonto.getCantidad()));
				}
			}
		});	
		
		_frame.setVisible(true);
	}
}
