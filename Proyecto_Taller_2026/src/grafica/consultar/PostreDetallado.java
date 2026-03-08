package grafica.consultar;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import grafica.Ventana;
import grafica.controladores.PostreDetalladoController;
import value_objects.VO_CodigoPostre;
import value_objects.VO_Light;
import value_objects.VO_Postre;

import javax.swing.JButton;

public class PostreDetallado extends Ventana {

	private JTextField textField;
	private PostreDetalladoController _controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostreDetallado window = new PostreDetallado();
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
	public PostreDetallado() {
		super();
		this._controller = new PostreDetalladoController(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		_frame.setTitle("Información detallada de postre");
		_frame.setBounds(100, 100, 489, 357);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.getContentPane().setLayout(null);

		JLabel lblIngreseElCdigo = new JLabel("Ingrese el código del postre:");
		lblIngreseElCdigo.setFont(new Font("Arial", Font.BOLD, 15));
		lblIngreseElCdigo.setBounds(10, 10, 378, 32);
		_frame.getContentPane().add(lblIngreseElCdigo);

		JLabel lblNewLabel_2_2 = new JLabel("Código:");
		lblNewLabel_2_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2_2.setBounds(10, 66, 112, 16);
		_frame.getContentPane().add(lblNewLabel_2_2);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(132, 65, 178, 19);
		_frame.getContentPane().add(textField);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(225, 98, 85, 21);
		_frame.getContentPane().add(btnAceptar);

		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNombre.setBounds(10, 185, 86, 16);
		_frame.getContentPane().add(lblNombre);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Arial", Font.PLAIN, 13));
		lblPrecio.setBounds(10, 207, 86, 16);
		_frame.getContentPane().add(lblPrecio);

		JLabel lblEndulzante = new JLabel("Endulzante:");
		lblEndulzante.setFont(new Font("Arial", Font.PLAIN, 13));
		lblEndulzante.setBounds(10, 256, 86, 16);
		_frame.getContentPane().add(lblEndulzante);

		JLabel lblDescripcion = new JLabel("Descirpción:");
		lblDescripcion.setFont(new Font("Arial", Font.PLAIN, 13));
		lblDescripcion.setBounds(10, 281, 86, 16);
		_frame.getContentPane().add(lblDescripcion);

		JLabel lblTitulo = new JLabel("Tipo:");
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 13));
		lblTitulo.setBounds(10, 233, 45, 13);
		_frame.getContentPane().add(lblTitulo);

		JLabel lblTituloResultado = new JLabel("Resultado:");
		lblTituloResultado.setFont(new Font("Arial", Font.BOLD, 14));
		lblTituloResultado.setBounds(10, 129, 112, 13);
		_frame.getContentPane().add(lblTituloResultado);

		JLabel lblCodigo = new JLabel("Código: ");
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 13));
		lblCodigo.setBounds(10, 162, 58, 13);
		_frame.getContentPane().add(lblCodigo);

		JLabel lblResultadoCodigo = new JLabel("resuCodigo");
		lblResultadoCodigo.setFont(new Font("Arial", Font.PLAIN, 13));
		lblResultadoCodigo.setBounds(128, 162, 98, 13);
		_frame.getContentPane().add(lblResultadoCodigo);

		JLabel lblResultadoNombre = new JLabel("ResuNombre");
		lblResultadoNombre.setFont(new Font("Arial", Font.PLAIN, 13));
		lblResultadoNombre.setBounds(128, 187, 98, 13);
		_frame.getContentPane().add(lblResultadoNombre);

		JLabel lblResultadoPrecio = new JLabel("ResuPrecio");
		lblResultadoPrecio.setFont(new Font("Arial", Font.PLAIN, 13));
		lblResultadoPrecio.setBounds(128, 209, 98, 13);
		_frame.getContentPane().add(lblResultadoPrecio);

		JLabel lblResultadoTipo = new JLabel("ResuTipo");
		lblResultadoTipo.setFont(new Font("Arial", Font.PLAIN, 13));
		lblResultadoTipo.setBounds(128, 233, 85, 13);
		_frame.getContentPane().add(lblResultadoTipo);

		JLabel lblResultadoEndulzante = new JLabel("ResuEndulz");
		lblResultadoEndulzante.setFont(new Font("Arial", Font.PLAIN, 13));
		lblResultadoEndulzante.setBounds(128, 258, 98, 13);
		_frame.getContentPane().add(lblResultadoEndulzante);

		JLabel lblResultadoDescripcion = new JLabel("Resudescei");
		lblResultadoDescripcion.setFont(new Font("Arial", Font.PLAIN, 13));
		lblResultadoDescripcion.setBounds(128, 283, 98, 13);
		_frame.getContentPane().add(lblResultadoDescripcion);

		lblNombre.setVisible(false);
		lblPrecio.setVisible(false);
		lblEndulzante.setVisible(false);
		lblDescripcion.setVisible(false);
		lblCodigo.setVisible(false);
		lblResultadoNombre.setVisible(false);
		lblResultadoPrecio.setVisible(false);
		lblResultadoTipo.setVisible(false);
		lblResultadoEndulzante.setVisible(false);
		lblResultadoDescripcion.setVisible(false);
		lblTituloResultado.setVisible(false);
		lblTitulo.setVisible(false);
		lblResultadoCodigo.setVisible(false);

		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigo = textField.getText();

				VO_CodigoPostre voPostre = new VO_CodigoPostre(codigo);

				if (codigo.isEmpty()) {
					mostrarError("Todos los campos son obligatorios.");
					return;
				}

				VO_Postre datosPostre = _controller.PostreDetallado(voPostre);

				if (datosPostre != null) {
					lblResultadoCodigo.setVisible(true);
					lblResultadoNombre.setVisible(true);
					lblResultadoPrecio.setVisible(true);
					lblResultadoTipo.setVisible(true);

					lblResultadoCodigo.setText(datosPostre.getCodigo());
					lblResultadoNombre.setText(datosPostre.getNombre());
					lblResultadoPrecio.setText(String.valueOf(datosPostre.getPrecio()));
					lblResultadoTipo.setText(datosPostre.getTipo());

					if (datosPostre.getTipo() == "Light") {
						lblResultadoEndulzante.setVisible(true);
						lblResultadoDescripcion.setVisible(true);

						lblResultadoEndulzante.setText(((VO_Light) datosPostre).getEndulzante());
						lblResultadoDescripcion.setText(((VO_Light) datosPostre).getDescripcion());
					}
				}
			}
		});
	}
}
