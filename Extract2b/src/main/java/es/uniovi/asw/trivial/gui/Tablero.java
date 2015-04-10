package es.uniovi.asw.trivial.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import es.uniovi.asw.trivial.business.juego.ControladorJuego;
import es.uniovi.asw.trivial.model.PreguntaMulti;
import es.uniovi.asw.trivial.model.Usuario;

public class Tablero extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JPanel panelTablero;
	private int tamTablero = 9;
	private ControladorJuego cj;
	private JButton[][] botones = new JButton[tamTablero][tamTablero];
	private boolean defaultColors = true;
	private JPanel panelJugadores;
	private JPanel panel_3;
	private JPanel panel_4;
	private JLabel lblNewLabel;
	private int colorActual = 0;
	private List<Color> colores = new ArrayList<Color>();

	private int usuarioJugando = 0;

	// /**
	// * Launch the application.
	// */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// for (UIManager.LookAndFeelInfo laf : UIManager
	// .getInstalledLookAndFeels()) {
	// if ("Nimbus".equals(laf.getName()))
	// try {
	// UIManager.setLookAndFeel(laf.getClassName());
	// } catch (Exception ex) {
	// }
	// }
	// Tablero frame = new Tablero();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	// /**
	// * Create the frame.
	// */
	// public Tablero() {
	// asignarColores();
	// setIconImage(Toolkit.getDefaultToolkit().getImage(
	// Tablero.class
	// .getResource("/es/uniovi/asw/trivial/gui/img/tab.png")));
	// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// setBounds(100, 100, 450, 300);
	// contentPane = new JPanel();
	// contentPane.setBackground(Color.WHITE);
	// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	// setContentPane(contentPane);
	// contentPane.setLayout(new BorderLayout(0, 0));
	// contentPane.add(getPanel(), BorderLayout.WEST);
	// contentPane.add(getPanelTablero(), BorderLayout.CENTER);
	// }

	public Tablero(int tam, Color[] colors, ControladorJuego cj) {
		this.tamTablero = tam;
		this.botones = new JButton[tamTablero][tamTablero];
		this.defaultColors = false;
		asignarColores(colors);
		this.cj = cj;
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				Tablero.class
						.getResource("/es/uniovi/asw/trivial/gui/img/tab.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.WEST);
		contentPane.add(getPanelTablero(), BorderLayout.CENTER);
	}

	public int getUsuarioJugando() {
		return usuarioJugando;
	}

	public void setUsuarioJugando(int usuarioJugando) {
		this.usuarioJugando = usuarioJugando;
	}

	public ControladorJuego getCj() {
		return cj;
	}

	public void setCj(ControladorJuego cj) {
		this.cj = cj;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getPanel_1(), BorderLayout.NORTH);
			panel.add(getPanelJugadores());
		}
		return panel;
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(Color.WHITE);
			panel_1.setLayout(new BorderLayout(0, 0));
			panel_1.add(getPanel_3(), BorderLayout.CENTER);
			panel_1.add(getPanel_4(), BorderLayout.NORTH);
		}
		return panel_1;
	}

	private final static int MAXIMODADO = 6;
	private final static int MINIMODADO = 1;

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Random rand = new Random();
					int randomNum = rand.nextInt(MAXIMODADO) + MINIMODADO;

					lblNewLabel.setText(String.valueOf(randomNum));
				}
			});
			btnNewButton.setBackground(Color.WHITE);
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton
					.setIcon(new ImageIcon(
							Tablero.class
									.getResource("/es/uniovi/asw/trivial/gui/img/icono-dado.jpg")));
			btnNewButton.setToolTipText("Tirar Dado");
		}
		return btnNewButton;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Turno del jugador:");
		}
		return lblNewLabel_1;
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setEnabled(false);
			textField.setEditable(false);
			textField.setColumns(10);
		}
		return textField;
	}

	private JPanel getPanelTablero() {
		if (panelTablero == null) {
			panelTablero = new JPanel();
			panelTablero.setBackground(Color.WHITE);

			panelTablero
					.setLayout(new GridLayout(tamTablero, tamTablero, 0, 0));
		
			rellenarBotones();
			for (int i = 0; i < botones.length; i++) {
				for (int j = 0; j < botones[i].length; j++) {
					panelTablero.add(botones[i][j]);
				}
			}
		}
		return panelTablero;
	}



	private void rellenarBotones() {

		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[i].length; j++) {

				botones[i][j] = new JButton("n" + "[" + i + "][" + j + "]");

				if ((i == 0 && j == botones.length - 1) || (i == 0 && j == 0)
						|| (i == botones.length - 1 && j == botones.length - 1)
						|| (i == botones.length - 1 && j == 0)
						|| (i == botones.length / 2 && j == botones.length / 2)) {
					botones[i][j].setBackground(Color.WHITE);
					botones[i][j].setBorder(BorderFactory
							.createLineBorder(Color.ORANGE));
					botones[i][j].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {

							new PreguntaDialog(Color.WHITE, "Especial",
									new PreguntaMulti("", "", new String[0],
											new String[0], 0), Tablero.this)
									.setVisible(true);

						}
					});
				} else if ((i != 0 && i != botones.length / 2 && i != botones.length - 1)
						&& (j != 0 && j != botones.length / 2 && j != botones.length - 1)) {
					botones[i][j].setBackground(Color.WHITE);
					botones[i][j].setEnabled(false);
					botones[i][j].setBorder(null);
				} else
					while (botones[i][j].getBackground().equals(
							UIManager.getColor("Button.background"))) {
						botones[i][j].setBorder(BorderFactory
								.createLineBorder(Color.ORANGE));
						if (colorActual >= colores.size()) {
							colorActual = 0;
						}

						if (i == 0) {
							pintarCelda(botones[i][j], i, j, colorActual);
							colorActual++;
						} else {
							if (botones[i - 1][j].getBackground() != colores
									.get(colorActual)) {
								pintarCelda(botones[i][j], i, j, colorActual);
								colorActual++;
							} else {
								if (colorActual == colores.size() - 1) {
									colorActual = 0;
								} else {
									colorActual++;
								}
								pintarCelda(botones[i][j], i, j, colorActual);
								colorActual++;
							}
						}
					}

				botones[i][j].setText(null);
			}
		}

	}

	private void pintarCelda(JButton but, int i, int j, int colorActual) {

		but.setBackground(colores.get(colorActual));

		final Color colorDialog = colores.get(colorActual);
		but.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				PreguntaDialog dialog = new PreguntaDialog(
						colorDialog,
						getCollection(colorDialog),
						cj.getPreguntas()
								.get(getCollection(colorDialog))
								.get(new Random()
										.nextInt(cj
												.getPreguntas()
												.get(getCollection(colorDialog))
												.size())), Tablero.this);

				// descomentar esto cuando se acabe la funcionalidad
				//
				dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

				dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
				dialog.setVisible(true);

			}
		});
	}

	private void asignarColores(Color... coloresElegidos) {
		if (defaultColors) {
			colores.add(Color.RED);
			colores.add(Color.BLUE);
			colores.add(Color.YELLOW);
			colores.add(Color.GREEN);
		} else {
			for (Color color : coloresElegidos) {
				colores.add(color);
			}
		}

	}

	private String getCollection(Color color) {
		if (color.equals(Color.RED))
			return "deportes";
		else if (color.equals(Color.BLUE))
			return "historia";
		else if (color.equals(Color.YELLOW))
			return "ciencias";
		else if (color.equals(Color.GREEN))
			return "entretenimiento";
		else
			return "";
	}

	List<JTextField> nombresUsuarios = new ArrayList<JTextField>();

	public List<JTextField> getNombresUsuarios() {
		return nombresUsuarios;
	}

	public void setNombresUsuarios(List<JTextField> nombresUsuarios) {
		this.nombresUsuarios = nombresUsuarios;
	}

	private JPanel getPanelJugadores() {
		if (panelJugadores == null) {
			panelJugadores = new JPanel();
			panelJugadores.setBackground(Color.WHITE);
			panelJugadores.setLayout(new GridLayout(cj.getUsuarios().size(), 1,
					0, 0));

			int i = 0;
			for (Usuario user : cj.getUsuarios()) {

				JTextField nombreJugador = new JTextField(user.getLogin());
				JLabel lblProfile = new JLabel("");
				lblProfile
						.setIcon(new ImageIcon(
								Tablero.class
										.getResource("/es/uniovi/asw/trivial/gui/img/pro.png")));

				nombreJugador.setEditable(false);

				if (i == 0) {
					usuarioJugando = 0;
					nombreJugador.setBackground(Color.yellow);
					cj.getUsuarios().get(usuarioJugando).setTocaJugar(true);
				}

				nombresUsuarios.add(nombreJugador);
				panelJugadores.add(nombreJugador);
				panelJugadores.add(lblProfile);
				panelJugadores
						.add(new JLabel(
								new ImageIcon(
										Tablero.class
												.getResource("/es/uniovi/asw/trivial/gui/img/arbolIni.jpg"))));
				i++;
			}

		}
		return panelJugadores;
	}

	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setBackground(Color.WHITE);
			panel_3.setLayout(new GridLayout(0, 2, 0, 0));
			panel_3.add(getBtnNewButton());
			panel_3.add(getLblNewLabel());
		}
		return panel_3;
	}

	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setBackground(Color.WHITE);
			panel_4.add(getLblNewLabel_1());
			panel_4.add(getTextField());
		}
		return panel_4;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 40));
		}
		return lblNewLabel;
	}

}
