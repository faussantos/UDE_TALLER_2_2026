package grafica.Consultar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class RecaudacionPostreFecha {

	private JFrame frmMontoRecaudadoPor;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecaudacionPostreFecha window = new RecaudacionPostreFecha();
					window.frmMontoRecaudadoPor.setVisible(true);
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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMontoRecaudadoPor = new JFrame();
		frmMontoRecaudadoPor.setTitle("Monto recaudado por postre en fecha");
		frmMontoRecaudadoPor.setBounds(100, 100, 450, 300);
		frmMontoRecaudadoPor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMontoRecaudadoPor.getContentPane().setLayout(null);
		
		JLabel lblIngreseLosDatos = new JLabel("Ingrese los datos:");
		lblIngreseLosDatos.setFont(new Font("Arial", Font.BOLD, 15));
		lblIngreseLosDatos.setBounds(10, 10, 378, 32);
		frmMontoRecaudadoPor.getContentPane().add(lblIngreseLosDatos);
		
		JLabel lblNewLabel_2_2 = new JLabel("Código:");
		lblNewLabel_2_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2_2.setBounds(10, 53, 112, 16);
		frmMontoRecaudadoPor.getContentPane().add(lblNewLabel_2_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(85, 52, 178, 19);
		frmMontoRecaudadoPor.getContentPane().add(textField);
		
		JLabel lblNewLabel_2_1 = new JLabel("Fecha: ");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(10, 95, 86, 16);
		frmMontoRecaudadoPor.getContentPane().add(lblNewLabel_2_1);
		
		
		Integer[] dias = new Integer[31];
		for (int i = 0; i < 31; i++) {
		    dias[i] = i + 1;
		}
		JComboBox<Integer> comboDia = new JComboBox<>();
		for(Integer dia : dias) {
			comboDia.addItem(dia);
		}
		comboDia.setBounds(85, 93, 43, 21);
		frmMontoRecaudadoPor.getContentPane().add(comboDia);
		
		
		String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
		JComboBox<String> comboMes = new JComboBox<>();
		for(String mes : meses) {
			comboMes.addItem(mes);
		}
		comboMes.setBounds(138, 93, 89, 21);
		frmMontoRecaudadoPor.getContentPane().add(comboMes);
		
		
		Integer[] anios = new Integer[10];
		for (int i = 0; i < 10; i++) {
		    anios[i] = 2020 + i;
		}
		JComboBox<Integer> comboAnio = new JComboBox<>();
		for(Integer anio : anios) {
			comboAnio.addItem(anio);
		}
		comboAnio.setBounds(237, 93, 56, 21);
		frmMontoRecaudadoPor.getContentPane().add(comboAnio);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(208, 124, 85, 21);
		frmMontoRecaudadoPor.getContentPane().add(btnAceptar);
		
		JLabel lblTituloResultado = new JLabel("Resultado:");
		lblTituloResultado.setFont(new Font("Arial", Font.BOLD, 14));
		lblTituloResultado.setBounds(10, 159, 112, 13);
		frmMontoRecaudadoPor.getContentPane().add(lblTituloResultado);
		
		JLabel lblUnidades = new JLabel("Unidades vendidas:");
		lblUnidades.setFont(new Font("Arial", Font.PLAIN, 13));
		lblUnidades.setBounds(10, 182, 148, 13);
		frmMontoRecaudadoPor.getContentPane().add(lblUnidades);
		
		JLabel lblMonto = new JLabel("Monto total:");
		lblMonto.setFont(new Font("Arial", Font.PLAIN, 13));
		lblMonto.setBounds(10, 205, 86, 13);
		frmMontoRecaudadoPor.getContentPane().add(lblMonto);
		
		JLabel lblResultadoUnidades = new JLabel("ResuUnidades");
		lblResultadoUnidades.setFont(new Font("Arial", Font.PLAIN, 13));
		lblResultadoUnidades.setBounds(138, 182, 98, 13);
		frmMontoRecaudadoPor.getContentPane().add(lblResultadoUnidades);
		
		JLabel lblResultadoMonto = new JLabel("ResuMonto");
		lblResultadoMonto.setFont(new Font("Arial", Font.PLAIN, 13));
		lblResultadoMonto.setBounds(138, 205, 98, 13);
		frmMontoRecaudadoPor.getContentPane().add(lblResultadoMonto);
		
		lblUnidades.setVisible(false);
		lblMonto.setVisible(false);
		lblTituloResultado.setVisible(false);
		lblResultadoUnidades.setVisible(false);
		lblResultadoMonto.setVisible(false);
		
	}

}
