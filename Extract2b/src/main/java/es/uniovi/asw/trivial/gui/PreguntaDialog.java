package es.uniovi.asw.trivial.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import es.uniovi.asw.trivial.model.Pregunta;

public class PreguntaDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textPregunta;
	Timer timer;

	private final int TIEMPO_RESPUESTA = 15;
	private final int DELAY = 1000;

	public PreguntaDialog(final Color color, final String categoria,
			final Pregunta p, final Tablero tablero) {
		setResizable(false);

		setModal(true);
		setAlwaysOnTop(true);

		setBounds(100, 100, 450, 300);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(color);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			panel.setLayout(new GridLayout(2, 1, 0, 0));
			{
				JLabel lblPregunta = new JLabel("Pregunta:");
				lblPregunta.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblPregunta);
			}
			{
				textPregunta = new JTextField();
				textPregunta.setHorizontalAlignment(SwingConstants.CENTER);
				textPregunta.setEditable(false);
				panel.add(textPregunta);
				textPregunta.setText(p.getPregunta());
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(color);
			contentPanel.add(panel);
			panel.setLayout(new GridLayout(0, 2, 0, 0));
			{
				for (int i = 0; i < p.getRespuestas().length; i++) {
					JButton bt = new JButton(p.getRespuestas()[i]);
					final int num = i;
					bt.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							timer.stop();

							// cambiar turno jugador
							if (num != p.getCorrecta()) {
								tablero.getCj().getUsuarios()
										.get(tablero.getUsuarioJugando())
										.setTocaJugar(false);
								tablero.getNombresUsuarios()
										.get(tablero.getUsuarioJugando())
										.setBackground(Color.white);

								if (tablero.getUsuarioJugando() + 1 == tablero
										.getCj().getUsuarios().size())
									tablero.setUsuarioJugando(0);
								else
									tablero.setUsuarioJugando(tablero
											.getUsuarioJugando() + 1);

								tablero.getCj().getUsuarios()
										.get(tablero.getUsuarioJugando())
										.setTocaJugar(true);
								tablero.getNombresUsuarios()
										.get(tablero.getUsuarioJugando())
										.setBackground(Color.yellow);
							} else {

								JLabel manzana = new JLabel();
								String[] cat = categoria.split(" ");
								//Celdas especiales
								if (cat.length>1 && categoria.contains("Especial") && !tablero.getCj().getUsuarios()
										.get(tablero.getUsuarioJugando()).getCategoriasGanadas().contains(cat[1])
										){
									tablero.getCj().getUsuarios()
									.get(tablero.getUsuarioJugando()).getCategoriasGanadas().add(cat[1]);
									manzana.setIcon(new ImageIcon(
											PreguntaDialog.class
													.getResource("/es/uniovi/asw/trivial/gui/img/manzana"
															+ cat[1] + ".gif")));
								
								tablero.getPanelesUsuarios()
										.get(tablero.getUsuarioJugando())

										.add(manzana);

								tablero.revalidate();

								tablero.repaint();
								}
							}
							JOptionPane.showMessageDialog(null,
									p.getContestacion()[num]);
							if (p.getCorrecta() == num) {
								// Acertadas ++
							} else {
								// falladas ++
							}
							if(tablero.getCj().getUsuarios()
										.get(tablero.getUsuarioJugando()).isGanador(tablero.getColores().size()))
								JOptionPane.showMessageDialog(null,
										tablero.getCj().getUsuarios()
										.get(tablero.getUsuarioJugando()).getLogin() + " ha ganado!!");
							dispose();
						}
					});
					bt.setActionCommand("Pregunta1");
					panel.add(bt);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new BorderLayout(0, 0));
			{
				final JProgressBar progressBar = new JProgressBar();
				{
					ActionListener listener = new ActionListener() {
						int counter = TIEMPO_RESPUESTA;

						public void actionPerformed(ActionEvent ae) {
							counter--;
							progressBar.setValue(counter);
							if (counter < 1) {
								JOptionPane.showMessageDialog(null,
										"Tiempo agotado!");
								timer.stop();
								dispose();
							}
						}
					};
					timer = new Timer(DELAY, listener);
					timer.start();
				}
				buttonPane.add(progressBar);
				progressBar.setMaximum(TIEMPO_RESPUESTA);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.NORTH);
			{
				JLabel lblHasElegidoUna = new JLabel(
						"Has elegido una pregunta de:");
				panel.add(lblHasElegidoUna);
			}
			{
				textField = new JTextField();
				textField.setEditable(false);
				textField.setEnabled(false);
				panel.add(textField);
				textField.setColumns(10);
				textField.setText(categoria);
			}

		}
	}
}
