package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PreguntaDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textPregunta;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
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
			panel.setLayout(new GridLayout(1, 0, 0, 0));
			{
				JRadioButton rdbtnNewRadioButton = new JRadioButton("Respuesta1\r\n");
				buttonGroup.add(rdbtnNewRadioButton);
				panel.add(rdbtnNewRadioButton);
			}
			{
				JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Respuesta2\r\n");
				buttonGroup.add(rdbtnNewRadioButton_1);
				panel.add(rdbtnNewRadioButton_1);
			}
			{
				JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Respuesta3");
				buttonGroup.add(rdbtnNewRadioButton_2);
				panel.add(rdbtnNewRadioButton_2);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Confirmar\r\n");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.NORTH);
			{
				JLabel lblHasElegidoUna = new JLabel("Has elegido una pregunta de:");
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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(color);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		{
			JLabel lblHasElegidoUna = new JLabel("Has elegido una pregunta de:");
			panel.add(lblHasElegidoUna);
		}
		{
			textField = new JTextField();
			textField.setEditable(false);
			textField.setEnabled(false);
			 
			textField.setText(color.toString());
			
			panel.add(textField);
			textField.setColumns(10);
		}
	}
	{
		JPanel panel = new JPanel();
		contentPanel.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		{
			JRadioButton rdbtnNewRadioButton = new JRadioButton("Respuesta1\r\n");
			buttonGroup.add(rdbtnNewRadioButton);
			panel.add(rdbtnNewRadioButton);
		}
		{
			JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Respuesta2\r\n");
			buttonGroup.add(rdbtnNewRadioButton_1);
			panel.add(rdbtnNewRadioButton_1);
		}
		{
			JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Respuesta3");
			buttonGroup.add(rdbtnNewRadioButton_2);
			panel.add(rdbtnNewRadioButton_2);
		}
	}
	{
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		{
			JButton confirmButton = new JButton("Confirmar\r\n");
			confirmButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			confirmButton.setActionCommand("Cancel");
			buttonPane.add(confirmButton);
		}
	}
	{
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		{
			JLabel lblHasElegidoUna = new JLabel("Has elegido una pregunta de:");
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


