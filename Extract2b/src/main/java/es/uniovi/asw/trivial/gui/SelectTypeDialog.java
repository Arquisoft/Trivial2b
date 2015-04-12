package es.uniovi.asw.trivial.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import es.uniovi.asw.trivial.model.Posicion;

public class SelectTypeDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textPreguntaEspecial;
	private Tablero tablero;
	private JPanel panelBotones;
	private Posicion posicion;

	/**
	 * Create the dialog.
	 */
	public SelectTypeDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			textPreguntaEspecial = new JTextField();
			contentPanel.add(textPreguntaEspecial, BorderLayout.NORTH);
			textPreguntaEspecial.setColumns(10);
		}
		{
			JPanel panelBotonesTypes = new JPanel();
			contentPanel.add(panelBotonesTypes, BorderLayout.CENTER);
			panelBotonesTypes.setLayout(new GridLayout(1, 0, 0, 0));
			
		}
	}

	public SelectTypeDialog(final Color color, final Tablero tablero) {
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		this.tablero = tablero;
		setModal(true);
		setAlwaysOnTop(true);

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			textPreguntaEspecial = new JTextField();
			textPreguntaEspecial.setText("Selecciona la manzana que quieres obtener");
			textPreguntaEspecial.setEditable(false);
			contentPanel.add(textPreguntaEspecial, BorderLayout.NORTH);
			textPreguntaEspecial.setColumns(10);
		}
		{
			panelBotones = new JPanel();
			contentPanel.add(panelBotones, BorderLayout.CENTER);
			panelBotones.setLayout(new GridLayout(1, 0, 0, 0));
			
		}
		rellenarPanelBotones();
	}

	public SelectTypeDialog(final Color color, final Tablero tablero,final Posicion p) {
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		this.tablero = tablero;
		setModal(true);
		setAlwaysOnTop(true);
		this.posicion=p;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			textPreguntaEspecial = new JTextField();
			textPreguntaEspecial.setText("Selecciona la manzana que quieres obtener");
			textPreguntaEspecial.setEditable(false);
			contentPanel.add(textPreguntaEspecial, BorderLayout.NORTH);
			textPreguntaEspecial.setColumns(10);
		}
		{
			panelBotones = new JPanel();
			contentPanel.add(panelBotones, BorderLayout.CENTER);
			panelBotones.setLayout(new GridLayout(1, 0, 0, 0));
			
		}
		rellenarPanelBotones();
	}

	private void rellenarPanelBotones() {
		List<String> categoriasGanadas = tablero.getCj().getUsuarios()
				.get(tablero.getUsuarioJugando()).getCategoriasGanadas();
		List<String> categoriasRestantes = tablero.getAllCategories(tablero
				.getColores());
		categoriasRestantes.removeAll(categoriasGanadas);
		for (final String categoria : categoriasRestantes) {
			JButton cat = new JButton();
			cat.setBackground(Color.WHITE);
			cat.setIcon(new ImageIcon(
											PreguntaDialog.class
													.getResource("/es/uniovi/asw/trivial/gui/img/manzana"
															+ categoria + ".gif")));
			cat.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					System.out.println(tablero.getCj().getPreguntas().get(categoria).size());
					PreguntaDialog dialog=new PreguntaDialog(posicion,
							Color.WHITE,
							"Especial "+categoria,
							tablero.getCj().getPreguntas()
									.get(categoria)
									.get(new Random()
											.nextInt(tablero.getCj()
													.getPreguntas()
													.get(categoria)
													.size())), tablero);
				
					dialog.setVisible(true);
					dispose();

				}
			});
			panelBotones.add(cat);

		}
	}
}
