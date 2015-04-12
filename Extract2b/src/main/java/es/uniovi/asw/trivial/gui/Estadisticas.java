package es.uniovi.asw.trivial.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import es.uniovi.asw.trivial.persistence.impl.UsuarioGatewayImpl;

public class Estadisticas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnSalir;
	private JPanel panel;
	private JLabel lblEstadsticasDelJuego;
	private TextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for(UIManager.LookAndFeelInfo laf:UIManager.getInstalledLookAndFeels()){
			            if("Nimbus".equals(laf.getName()))
			                try {
			                UIManager.setLookAndFeel(laf.getClassName());
			            } catch (Exception ex) {
			            }}
					Estadisticas frame = new Estadisticas();
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
	public Estadisticas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getBtnSalir(), BorderLayout.SOUTH);
		contentPane.add(getPanel(), BorderLayout.CENTER);
		contentPane.add(getLblEstadsticasDelJuego(), BorderLayout.NORTH);
	}

	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new Menuprincipal().setVisible(true);
					dispose();
				}
			});
		}
		return btnSalir;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(0, 1, 0, 0));
			panel.add(getTextArea());
		}
		return panel;
	}
	private JLabel getLblEstadsticasDelJuego() {
		if (lblEstadsticasDelJuego == null) {
			lblEstadsticasDelJuego = new JLabel("Estad\u00EDsticas del juego");
			lblEstadsticasDelJuego.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblEstadsticasDelJuego;
	}
	private TextArea getTextArea() {
		if (textArea == null) {
			textArea = new TextArea();
			//TODO
			UsuarioGatewayImpl juega=new UsuarioGatewayImpl();
			String datos=juega.recuperaDatos();
			textArea.setText(datos);
		}
		return textArea;
	}
}
