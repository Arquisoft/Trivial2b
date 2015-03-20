package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			for(UIManager.LookAndFeelInfo laf:UIManager.getInstalledLookAndFeels()){
	            if("Nimbus".equals(laf.getName()))
	                try {
	                UIManager.setLookAndFeel(laf.getClassName());
	            } catch (Exception ex) {
	            }}
			PreguntaDialog dialog = new PreguntaDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PreguntaDialog() {
		setResizable(false);
		setModal(true);
		setAlwaysOnTop(true);
		setBounds(100, 100, 450, 300);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JLabel lblPregunta = new JLabel("Pregunta:");
				panel.add(lblPregunta);
			}
			{
				textPregunta = new JTextField();
				panel.add(textPregunta);
				textPregunta.setColumns(10);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(new GridLayout(0, 2, 0, 0));
			{
				JButton btnPregunta1 = new JButton("Respuesta1");
				btnPregunta1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				btnPregunta1.setActionCommand("Pregunta1");
				panel.add(btnPregunta1);
			}
			{
				JButton btnPregunta2 = new JButton("Respuesta2");
				btnPregunta2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				panel.add(btnPregunta2);
			}
			{
				JButton btnPregunta3 = new JButton("Respuesta3");
				btnPregunta3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				panel.add(btnPregunta3);
			}
			{
				JButton btnPregunta4 = new JButton("Respuesta4");
				btnPregunta4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				panel.add(btnPregunta4);
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
						int counter = 15;

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
					timer = new Timer(1000, listener);
					timer.start();
				}
				buttonPane.add(progressBar);
				progressBar.setMaximum(30);
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
			}

		}
	}

	public PreguntaDialog(Color color) {
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
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JLabel lblPregunta = new JLabel("Pregunta:");
				panel.add(lblPregunta);
			}
			{
				textPregunta = new JTextField();
				textPregunta.setEditable(false);
				panel.add(textPregunta);
				textPregunta.setColumns(10);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(color);
			contentPanel.add(panel);
			panel.setLayout(new GridLayout(0, 2, 0, 0));
			{
				JButton btnPregunta1 = new JButton("Respuesta1");
				btnPregunta1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						timer.stop();
						dispose();
					}
				});
				btnPregunta1.setActionCommand("Pregunta1");
				panel.add(btnPregunta1);
			}
			{
				JButton btnPregunta2 = new JButton("Respuesta2");
				btnPregunta2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						timer.stop();
						dispose();
					}
				});
				panel.add(btnPregunta2);
			}
			{
				JButton btnPregunta3 = new JButton("Respuesta3");
				btnPregunta3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						timer.stop();
						dispose();
					}
				});
				panel.add(btnPregunta3);
			}
			{
				JButton btnPregunta4 = new JButton("Respuesta4");
				btnPregunta4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						timer.stop();
						dispose();
					}
				});
				panel.add(btnPregunta4);
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
			}

		}
	}
}
