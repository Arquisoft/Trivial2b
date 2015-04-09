package es.uniovi.asw.trivial.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

<<<<<<< HEAD
import es.uniovi.asw.trivial.business.UsuarioService;
import es.uniovi.asw.trivial.business.impl.UsuarioServiceImpl;
=======
import es.uniovi.asw.trivial.persistence.impl.Usuario_trivialJdbcDao;
>>>>>>> origin/master

public class Registro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAtras;
	private JPanel panel;
	private JButton btnNewButton;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblNewLabel;
	private JTextField textFieldLogin;
	private JPanel panel_4;
	private JLabel lblNewLabel_1;
	private JTextField textFieldContrasena;

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
					Registro frame = new Registro();
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
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.SOUTH);
		contentPane.add(getPanel_1(), BorderLayout.CENTER);
	}

	private JButton getBtnAtras() {
		if (btnAtras == null) {
			btnAtras = new JButton("Registrarse");
			btnAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
<<<<<<< HEAD
					UsuarioService uS = new UsuarioServiceImpl();
					String res = uS.newUsuario(textFieldLogin.getText(), textFieldLogin.getText());
					
					JOptionPane.showMessageDialog(null, res);
					new Menuprincipal().setVisible(true);
=======
					//Registrarse en la bd
					Usuario_trivialJdbcDao user=new Usuario_trivialJdbcDao();
					user.registro(getTextField().getText(),getTextField_1().getText());
					
					 new Menuprincipal().setVisible(true);
>>>>>>> origin/master
			            dispose();
				}
			});
		}
		return btnAtras;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getBtnNewButton(), BorderLayout.SOUTH);
			panel.add(getBtnAtras(), BorderLayout.NORTH);
		}
		return panel;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Atras");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					 new Menuprincipal().setVisible(true);
			            dispose();
				}
			});
		}
		return btnNewButton;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new BorderLayout(0, 0));
			panel_1.add(getPanel_2(), BorderLayout.CENTER);
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(new GridLayout(2, 1, 0, 0));
			panel_2.add(getPanel_3());
			panel_2.add(getPanel_4());
		}
		return panel_2;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.add(getLblNewLabel());
			panel_3.add(getTextFieldLogin());
		}
		return panel_3;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Nombre de usuario");
		}
		return lblNewLabel;
	}
	private JTextField getTextFieldLogin() {
		if (textFieldLogin == null) {
			textFieldLogin = new JTextField();
			textFieldLogin.setColumns(10);
		}
		return textFieldLogin;
	}
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.add(getLblNewLabel_1());
			panel_4.add(getTextFieldContrasena());
		}
		return panel_4;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		}
		return lblNewLabel_1;
	}
	private JTextField getTextFieldContrasena() {
		if (textFieldContrasena == null) {
			textFieldContrasena = new JTextField();
			textFieldContrasena.setColumns(10);
		}
		return textFieldContrasena;
	}
}
