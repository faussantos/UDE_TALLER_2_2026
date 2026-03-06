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
import javax.swing.JTextField;

public class ListadoDetallesEnVenta {

	private JFrame frmListadoDetallesEnVenta;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoDetallesEnVenta window = new ListadoDetallesEnVenta();
					window.frmListadoDetallesEnVenta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListadoDetallesEnVenta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmListadoDetallesEnVenta = new JFrame();
		frmListadoDetallesEnVenta.setTitle("Listado detalles en venta");
		frmListadoDetallesEnVenta.setBounds(100, 100, 682, 408);
		frmListadoDetallesEnVenta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmListadoDetallesEnVenta.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listado de Detalles");
		lblNewLabel.setBounds(10, 10, 648, 19);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		frmListadoDetallesEnVenta.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 85, 593, 200);
		frmListadoDetallesEnVenta.getContentPane().add(scrollPane);
		
		String[] columnas = {"Código", "Nombre", "Precio", "Tipo", "Cantidad"};
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
		table = new JTable(modelo);
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		
		//Esto agregará los datos
		for(int i = 0; i < 100 ; i++)
		{
			modelo.addRow(new Object[]{"123", "Flan", 50.0, "Común"});			
		}
		
		//Esto agregará los datos
		for(int i = 0; i < 100 ; i++)
		{
			modelo.addRow(new Object[]{"123", "Flan", 50.0, "Común"});			
		}
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(531, 340, 95, 21);
		frmListadoDetallesEnVenta.getContentPane().add(btnCerrar);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese número de venta: ");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(23, 56, 157, 17);
		frmListadoDetallesEnVenta.getContentPane().add(lblNewLabel_1);
		
		ButtonGroup grupo = new ButtonGroup();
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(324, 54, 95, 21);
		frmListadoDetallesEnVenta.getContentPane().add(btnBuscar);
		
		textField = new JTextField();
		textField.setBounds(176, 55, 110, 19);
		frmListadoDetallesEnVenta.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
