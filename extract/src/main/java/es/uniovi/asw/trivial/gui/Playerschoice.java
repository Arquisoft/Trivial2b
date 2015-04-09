package es.uniovi.asw.trivial.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import es.uniovi.asw.trivial.business.JuegoService;
import es.uniovi.asw.trivial.business.impl.JuegoServiceImpl;
import es.uniovi.asw.trivial.business.juego.ControladorJuego;
import es.uniovi.asw.trivial.model.Pregunta;
import es.uniovi.asw.trivial.model.Usuario;

public class Playerschoice extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblSeleccinDeJugadores;
	private JTextField textNombre;
	private JTextField textContra;
	public JTable tablero;
	private JTextField textField_2_1;
	private final int TABLERO_PEQUENO = 7;
	private final int TABLERO_NORMAL = 9;
	private final int TABLERO_GRANDE = 13;
	private final int MIN_PLAYERS = 2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					for (UIManager.LookAndFeelInfo laf : UIManager
							.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(laf.getName()))
							try {
								UIManager.setLookAndFeel(laf.getClassName());
							} catch (Exception ex) {
							}
					}
					Playerschoice frame = new Playerschoice();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Playerschoice() {
		setTitle("Trivial Pursuit\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);

		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

		JLabel lblNombreJugador = new JLabel("Nombre jugador");
		panel_1.add(lblNombreJugador);

		textNombre = new JTextField();
		panel_1.add(textNombre);
		textNombre.setColumns(8);

		JLabel lblContrasea = new JLabel("Password");
		panel_1.add(lblContrasea);

		textContra = new JTextField();

		panel_1.add(textContra);
		textContra.setColumns(10);
		panel.add(panel_1, BorderLayout.NORTH);

		JPanel panelTabla = new JPanel();
		panelTabla.setLayout(new BorderLayout(0, 0));

		panelTabla.add(getPreview());
		panel.add(panelTabla, BorderLayout.CENTER);

		JPanel panel_2 = new JPanel();
		panelTabla.add(panel_2, BorderLayout.NORTH);

		JLabel lblNumeroDeJugadores = new JLabel("NumJugadores:");
		panel_2.add(lblNumeroDeJugadores);

		textField_2_1 = new JTextField();
		textField_2_1.setEditable(false);
		textField_2_1.setEnabled(false);
		panel_2.add(textField_2_1);
		textField_2_1.setColumns(2);

		JLabel lblNmeroDeCategoras = new JLabel("Categor\u00EDas\r\n");
		panel_2.add(lblNmeroDeCategoras);

		final JPanel panelCategorias = new JPanel();
		panel_2.add(panelCategorias);

		final JCheckBox chckbxDeportes = new JCheckBox("Deportes");
		panelCategorias.add(chckbxDeportes);
		chckbxDeportes.setSelected(true);

		final JCheckBox chckbxCiencia = new JCheckBox("Ciencias");
		panelCategorias.add(chckbxCiencia);
		chckbxCiencia.setSelected(true);

		final JCheckBox chckbxHistoria = new JCheckBox("Historia");
		panelCategorias.add(chckbxHistoria);
		chckbxHistoria.setSelected(true);

		final JCheckBox chckbxCine = new JCheckBox("Entretenimiento");
		panelCategorias.add(chckbxCine);
		chckbxCine.setSelected(true);

		final JCheckBox chckbxMatemticas = new JCheckBox("Matem\u00E1ticas");
		panelCategorias.add(chckbxMatemticas);

		JLabel lblTamaoDelTablero = new JLabel("Tablero");
		panel_2.add(lblTamaoDelTablero);

		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {
				"Normal", "Grande", "Pequeno" }));
		panel_2.add(comboBox);
		JButton btnUnirse = new JButton("Unirse");
		btnUnirse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Playerschoice.ExampleTableModel model = (Playerschoice.ExampleTableModel) tablero
						.getModel();
				Usuario user = new Usuario();// este usuario seria sacado de la
												// BD con findbyLogin(string)
												// por ejemplo
				if (!textNombre.getText().equals("")) {
					user.setNombre(textNombre.getText());
					model.anadirUser(user);
					model.addRow(user.getNombre());
				}

			}
		});
		panel_1.add(btnUnirse);

		JButton btnComenzarLaPartida = new JButton("Comenzar la partida");
		btnComenzarLaPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Playerschoice.ExampleTableModel model = (Playerschoice.ExampleTableModel) tablero
						.getModel();
				List<Usuario> usuarios = model.getUsuarios();
				if (model.getRowCount() < MIN_PLAYERS)
					JOptionPane.showMessageDialog(null,
							"Mínimo para jugar 2 jugadores");
				Color[] colors = getColoresPartida();
				int tam = TABLERO_NORMAL;				
				if (comboBox.getSelectedItem().toString().equals("Grande")
						&& isTableroPosible(TABLERO_GRANDE, colors.length)) {
					tam = TABLERO_GRANDE;
				}
				if (comboBox.getSelectedItem().toString().equals("Pequeno")
						&& isTableroPosible(TABLERO_PEQUENO, colors.length)) {
					tam = TABLERO_PEQUENO;
				}
				Map<String, List<Pregunta>> preguntas = new HashMap<>();
				JuegoService j = new JuegoServiceImpl();
				for (Component c : panelCategorias.getComponents()) {
				if (((JCheckBox) c).isSelected()) {
						preguntas.put(((JCheckBox) c).getText().toLowerCase(), j.getPreguntasCollection(((JCheckBox) c).getText().toLowerCase()));
					}
				}
				Tablero tab = new Tablero(tam, colors, new ControladorJuego(preguntas, usuarios));
				tab.setExtendedState(JFrame.MAXIMIZED_BOTH);
				tab.setVisible(true);
				dispose();

			}

			private boolean isTableroPosible(int tamTablero, int numColores) {
				int num = 0;
				num = (tamTablero * tamTablero)
						- ((tamTablero - 3) * (tamTablero - 3) + 5);
				if (num % numColores == 0)
					return true;
				else {
					JOptionPane.showMessageDialog(null,
							"Numero de categorias en esa dimension no valido");
					return false;
				}
			}

			private Color[] getColoresPartida() {
				Color[] colores = new Color[getNumCategoriasSelected()];
				List<Color> coloresArrayList = new ArrayList<Color>();

				if (chckbxDeportes.isSelected())
					coloresArrayList.add(Color.RED);
				if (chckbxCiencia.isSelected())
					coloresArrayList.add(Color.YELLOW);
				if (chckbxCine.isSelected())
					coloresArrayList.add(Color.GREEN);
				if (chckbxHistoria.isSelected())
					coloresArrayList.add(Color.BLUE);
				if (chckbxMatemticas.isSelected())
					coloresArrayList.add(Color.CYAN);

				return coloresArrayList.toArray(colores);
			}

			private int getNumCategoriasSelected() {
				Component[] checkBoxes = panelCategorias.getComponents();
				int num = 0;
				for (Component comp : checkBoxes)
					if (((JCheckBox) comp).isSelected())
						num++;

				return num;
			}
		});
		panel.add(btnComenzarLaPartida, BorderLayout.SOUTH);

		lblSeleccinDeJugadores = new JLabel("Selecci\u00F3n de jugadores");
		contentPane.add(lblSeleccinDeJugadores, BorderLayout.NORTH);

		JButton btnNewButton = new JButton("Volver al men\u00FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Menuprincipal().setVisible(true);

				dispose();
			}
		});
		contentPane.add(btnNewButton, BorderLayout.SOUTH);
	}

	public Component getPreview() {
		// Table
		JTable table = new JTable(new ExampleTableModel());

		table.setRowHeight(50);
		JScrollPane scrollPane = new JScrollPane(table);

		// Custom column
		TableColumn buttonColumn = table.getColumnModel().getColumn(1);

		// Custom renderer
		buttonColumn.setCellRenderer(new ButtonRenderer());

		// Custom editor
		buttonColumn.setCellEditor(new ButtonEditor(new JCheckBox()));
		tablero = table;
		return scrollPane;
	}

	public class ExampleTableModel extends AbstractTableModel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String[] columnNames = { "Usuario", "Eliminar" };
		public List<Usuario> usuarios = new ArrayList<Usuario>();

		private Object[][] data;

		public final Object[] longValues = { "Usuario", "Eliminar" };

		public ExampleTableModel() {
			anadirUsuarios();

			for (Usuario user : usuarios) {
				addRow(user.getNombre());
			}

		}

		public void anadirUser(Usuario user) {
			usuarios.add(user);
			data = new Object[usuarios.size()][usuarios.size()];
			textField_2_1.setText(Integer.toString(usuarios.size()));
		}

		public List<Usuario> getUsuarios() {
			return usuarios;
		}

		public void anadirUsuarios() {
			// llamar a este metodo cada vez que un usuario se logea con exito
			// y se anade a la partida
			for (int i = 0; i < 6; i++) {// anadidos estos a modo de ejemplo
				Usuario user = new Usuario();
				user.setNombre("usuario" + i);
				usuarios.add(user);

			}
			data = new Object[usuarios.size()][usuarios.size()];

		}

		public void addRow(String value) {

			fireTableRowsInserted(usuarios.size() - 1, usuarios.size() - 1);
			int row = usuarios.size() - 1;
			int col = 0;
			setValueAt(value, row, col);
		}

		public void removeRow(int row) {
			Usuario user = usuarios.get(row);

			JOptionPane.showMessageDialog(null,
					"Jugador expulsado de la partida: " + user.getNombre());
			usuarios.remove(row);
			fireTableRowsDeleted(row, row);
			textField_2_1.setText(Integer.toString(usuarios.size()));

		}

		@Override
		public int getColumnCount() {
			return columnNames.length;
		}

		@Override
		public int getRowCount() {
			// return data.length;
			return usuarios.size();

		}

		@Override
		public String getColumnName(int col) {
			return columnNames[col];
		}

		@Override
		public Object getValueAt(int row, int col) {
			// return data[row][col];
			return usuarios.get(row).getNombre();

		}

		@Override
		public Class<?> getColumnClass(int c) {
			return longValues[c].getClass();
		}

		@Override
		public boolean isCellEditable(int row, int col) {
			return true;
		}

		@Override
		public void setValueAt(Object value, int row, int col) {
			data[row][col] = value;
			fireTableCellUpdated(row, col);
		}

	}
}

@SuppressWarnings("serial")
class ButtonEditor extends DefaultCellEditor {
	protected JButton button;
	private String label;
	private boolean isPushed;
	private int myRow;
	private JTable table;

	public ButtonEditor(JCheckBox checkBox) {
		super(checkBox);

		button = new JButton();
		button.setOpaque(true);

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
			}
		});
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		this.myRow = row;
		this.table = table;

		if (isSelected) {
			button.setForeground(table.getSelectionForeground());
			button.setBackground(table.getSelectionBackground());

		} else {
			button.setForeground(table.getForeground());
			button.setBackground(table.getBackground());
		}
		label = "Expulsado";

		button.setText(label);
		isPushed = true;
		return button;
	}

	@Override
	public Object getCellEditorValue() {
		if (isPushed) {

			Playerschoice.ExampleTableModel model = (Playerschoice.ExampleTableModel) table
					.getModel();
			String label = (String) model.getValueAt(myRow, 0);
			if (label != null) {
				// delete the model's row here if desired.
				model.removeRow(myRow);

			}
		}
		isPushed = false;
		return new String(label);
	}

	@Override
	public boolean stopCellEditing() {
		isPushed = false;
		return super.stopCellEditing();
	}

	@Override
	protected void fireEditingStopped() {
		super.fireEditingStopped();
	}
}

@SuppressWarnings("serial")
class ButtonRenderer extends JButton implements TableCellRenderer {
	public ButtonRenderer() {

		setOpaque(true);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		if (isSelected) {
			setForeground(table.getSelectionForeground());
			setBackground(table.getSelectionBackground());
		} else {
			setForeground(table.getForeground());
			setBackground(UIManager.getColor("Button.background"));
		}
		setText("Expulsar jugador");
		return this;
	}
}