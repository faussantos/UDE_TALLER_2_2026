package grafica.listados;

import java.awt.EventQueue;

import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;

public class ListadoVentas {

	private JFrame frmListadoDeVentas;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoVentas window = new ListadoVentas();
					window.frmListadoDeVentas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListadoVentas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmListadoDeVentas = new JFrame();
		frmListadoDeVentas.setTitle("Listado de Ventas");
		frmListadoDeVentas.setBounds(100, 100, 722, 408);
		frmListadoDeVentas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmListadoDeVentas.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listado de Ventas");
		lblNewLabel.setBounds(10, 10, 708, 19);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		frmListadoDeVentas.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 97, 688, 200);
		frmListadoDeVentas.getContentPane().add(scrollPane);
		
		String[] columnas = {"Número", "Fecha", "Dirección", "Monto", "Estado"};
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
		table = new JTable(modelo);
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(50);  
		table.getColumnModel().getColumn(1).setPreferredWidth(50);  
		table.getColumnModel().getColumn(2).setPreferredWidth(180); 
		table.getColumnModel().getColumn(3).setPreferredWidth(50);  
		table.getColumnModel().getColumn(4).setPreferredWidth(50); 
		
		//Esto agregará los datos
		for(int i = 0; i < 100 ; i++)
		{
			modelo.addRow(new Object[]{"123", "Flan", 50.0, "Común"});			
		}
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(603, 337, 95, 21);
		frmListadoDeVentas.getContentPane().add(btnCerrar);
		
		JLabel lblNewLabel_1 = new JLabel("Mostrar:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(23, 56, 54, 17);
		frmListadoDeVentas.getContentPane().add(lblNewLabel_1);
		
		JRadioButton rdbtnTodas = new JRadioButton("Todas");
		rdbtnTodas.setFont(new Font("Arial", Font.BOLD, 12));
		rdbtnTodas.setBounds(81, 54, 61, 21);
		frmListadoDeVentas.getContentPane().add(rdbtnTodas);
		
		JRadioButton rdbtnEnProceso = new JRadioButton("En Proceso");
		rdbtnEnProceso.setFont(new Font("Arial", Font.BOLD, 12));
		rdbtnEnProceso.setBounds(157, 54, 103, 21);
		frmListadoDeVentas.getContentPane().add(rdbtnEnProceso);
		
		JRadioButton rdbtnFinalizadas = new JRadioButton("Finalizadas");
		rdbtnFinalizadas.setFont(new Font("Arial", Font.BOLD, 12));
		rdbtnFinalizadas.setBounds(262, 54, 103, 21);
		frmListadoDeVentas.getContentPane().add(rdbtnFinalizadas);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbtnFinalizadas);
		grupo.add(rdbtnEnProceso);
		grupo.add(rdbtnTodas);
		rdbtnTodas.setSelected(true);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(371, 54, 95, 21);
		frmListadoDeVentas.getContentPane().add(btnBuscar);
	}
}
