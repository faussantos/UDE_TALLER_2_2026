package grafica.Listados;

import java.awt.EventQueue;

import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListadoPostres {

	private JFrame frmListadoDePostres;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoPostres window = new ListadoPostres();
					window.frmListadoDePostres.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListadoPostres() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmListadoDePostres = new JFrame();
		frmListadoDePostres.setTitle("Listado de Postres");
		frmListadoDePostres.setBounds(100, 100, 450, 300);
		frmListadoDePostres.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmListadoDePostres.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listado de postres");
		lblNewLabel.setBounds(0, 0, 436, 19);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		frmListadoDePostres.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 19, 416, 200);
		frmListadoDePostres.getContentPane().add(scrollPane);
		
		String[] columnas = {"Código", "Nombre", "Precio", "Tipo"};
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
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(331, 229, 95, 21);
		frmListadoDePostres.getContentPane().add(btnCerrar);
	}

}
