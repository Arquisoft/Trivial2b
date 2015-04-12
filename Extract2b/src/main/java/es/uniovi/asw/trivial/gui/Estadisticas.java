<<<<<<< HEAD
<<<<<<< HEAD
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Estadisticas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnSalir;
	private JPanel panel;
	private JLabel lblEstadsticasDelJuego;
	private JPanel panel_1;
	private JLabel lblPartidasJugadas;
	private JTextField textField;
	private JPanel panel_2;
	private JLabel lblRankingPorVictorias;
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
		setBounds(100, 100, 450, 300);
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
			panel.add(getPanel_1());
			panel.add(getPanel_2());
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
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.add(getLblPartidasJugadas());
			panel_1.add(getTextField());
		}
		return panel_1;
	}
	private JLabel getLblPartidasJugadas() {
		if (lblPartidasJugadas == null) {
			lblPartidasJugadas = new JLabel("Partidas jugadas");
		}
		return lblPartidasJugadas;
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
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.add(getLblRankingPorVictorias());
			panel_2.add(getTextArea());
		}
		return panel_2;
	}
	private JLabel getLblRankingPorVictorias() {
		if (lblRankingPorVictorias == null) {
			lblRankingPorVictorias = new JLabel("Ranking por victorias");
		}
		return lblRankingPorVictorias;
	}
	private TextArea getTextArea() {
		if (textArea == null) {
			textArea = new TextArea();
		}
		return textArea;
	}
}
=======
=======
>>>>>>> parent of 718e7d1... a
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
<<<<<<< HEAD
=======
import javax.swing.JTextField;
>>>>>>> parent of 718e7d1... a
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

<<<<<<< HEAD
import es.uniovi.asw.trivial.persistence.impl.UsuarioGatewayImpl;

=======
>>>>>>> parent of 718e7d1... a
public class Estadisticas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnSalir;
	private JPanel panel;
	private JLabel lblEstadsticasDelJuego;
<<<<<<< HEAD
=======
	private JPanel panel_1;
	private JLabel lblPartidasJugadas;
	private JTextField textField;
	private JPanel panel_2;
	private JLabel lblRankingPorVictorias;
>>>>>>> parent of 718e7d1... a
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
<<<<<<< HEAD
		setBounds(100, 100, 564, 387);
=======
		setBounds(100, 100, 450, 300);
>>>>>>> parent of 718e7d1... a
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
<<<<<<< HEAD
			panel.add(getTextArea());
=======
			panel.add(getPanel_1());
			panel.add(getPanel_2());
>>>>>>> parent of 718e7d1... a
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
<<<<<<< HEAD
	private TextArea getTextArea() {
		if (textArea == null) {
			textArea = new TextArea();
			//TODO
			UsuarioGatewayImpl juega=new UsuarioGatewayImpl();
			String datos=juega.recuperaDatos();
			textArea.setText(datos);
=======
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.add(getLblPartidasJugadas());
			panel_1.add(getTextField());
		}
		return panel_1;
	}
	private JLabel getLblPartidasJugadas() {
		if (lblPartidasJugadas == null) {
			lblPartidasJugadas = new JLabel("Partidas jugadas");
		}
		return lblPartidasJugadas;
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
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.add(getLblRankingPorVictorias());
			panel_2.add(getTextArea());
		}
		return panel_2;
	}
	private JLabel getLblRankingPorVictorias() {
		if (lblRankingPorVictorias == null) {
			lblRankingPorVictorias = new JLabel("Ranking por victorias");
		}
		return lblRankingPorVictorias;
	}
	private TextArea getTextArea() {
		if (textArea == null) {
			textArea = new TextArea();
>>>>>>> parent of 718e7d1... a
		}
		return textArea;
	}
}
<<<<<<< HEAD
>>>>>>> origin/master
=======
>>>>>>> parent of 718e7d1... a
