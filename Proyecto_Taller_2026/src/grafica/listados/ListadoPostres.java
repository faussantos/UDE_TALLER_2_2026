package grafica.listados;

import javax.swing.table.DefaultTableModel;

import grafica.Ventana;
import grafica.controladores.ListadoPostresController;
import value_objects.VO_Postre;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListadoPostres extends Ventana {

	private JTable table;
	private ListadoPostresController _controller;
	private DefaultTableModel modelo;

	public ListadoPostres() {
		super("Listado de Postres");
		_controller = new ListadoPostresController(this);
		initialize();
	}

	private void initialize() {
		_frame.setBounds(100, 100, 450, 300);

		JLabel lblTitulo = new JLabel("Listado de postres");
		lblTitulo.setBounds(0, 0, 436, 19);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
		_frame.getContentPane().add(lblTitulo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 19, 416, 200);
		_frame.getContentPane().add(scrollPane);

		String[] columnas = { "Código", "Nombre", "Precio", "Tipo" };
		modelo = new DefaultTableModel(columnas, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(modelo);
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setViewportView(table);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(331, 229, 95, 21);
		_frame.getContentPane().add(btnCerrar);

		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_frame.dispose();
			}
		});

		_controller.listadoPostres();

		_frame.setVisible(true);
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
}
