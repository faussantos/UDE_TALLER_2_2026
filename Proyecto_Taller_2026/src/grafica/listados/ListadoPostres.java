package grafica.listados;

import java.awt.EventQueue;

import javax.swing.table.DefaultTableModel;

import grafica.controladores.ListadoPostresController;
import grafica.controladores.NuevoPostreController;
import value_objects.VO_Postre;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListadoPostres {

	private JFrame frmListadoDePostres;
	private JTable table;
	private ListadoPostresController _controller;
	private DefaultTableModel modelo;

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
		_controller = new ListadoPostresController(this);
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

		String[] columnas = { "Código", "Nombre", "Precio", "Tipo" };
		modelo = new DefaultTableModel(columnas, 0);
		table = new JTable(modelo);
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setViewportView(table);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(331, 229, 95, 21);
		frmListadoDePostres.getContentPane().add(btnCerrar);

		_controller.ListadoPostres();
	}

	public void mostrarPostres(VO_Postre[] listadoPostres) {
		for (int i = 0; i < listadoPostres.length; i++) {
			String codigo = listadoPostres[i].getCodigo();
			String nombre = listadoPostres[i].getNombre();
			double precio = listadoPostres[i].getPrecio();
			String tipo = listadoPostres[i].getTipo();

			modelo.addRow(new Object[] { codigo, nombre, precio, tipo });
		}
	}

	public void mostrarError(String mensaje) {
		JOptionPane.showMessageDialog(frmListadoDePostres, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}

}
