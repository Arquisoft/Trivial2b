package es.uniovi.asw.trivial.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Menuprincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel label;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnJugar;
	private JButton btnEstadisticas;
	private JButton btnSalir;
	private JPanel panel_2;
	private JLabel lblBienvenidoATrivial;
	private JButton btnRegistro;
	private JButton btnAdmin;

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
					Menuprincipal frame = new Menuprincipal();
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
	public Menuprincipal() {
		setResizable(false);
		setTitle("Menu principal\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.CENTER);
		contentPane.add(getPanel_2(), BorderLayout.SOUTH);
		contentPane.add(getLblBienvenidoATrivial(), BorderLayout.NORTH);
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setIcon(new ImageIcon(Menuprincipal.class.getResource("/es/uniovi/asw/trivial/gui/img/triviados.png")));
					}
		return label;
	}
	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.add(getLabel());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(Color.WHITE);
			panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel_1.add(getBtnJugar());
			panel_1.add(getBtnEstadisticas());
			panel_1.add(getBtnRegistro());
			panel_1.add(getBtnAdmin());
			panel_1.add(getBtnSalir());
		}
		return panel_1;
	}
	private JButton getBtnJugar() {
		if (btnJugar == null) {
			btnJugar = new JButton("Jugar");
			btnJugar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
		            new Playerschoice().setVisible(true);
		            dispose();
			
				}
			});
		}
		return btnJugar;
	}
	private JButton getBtnEstadisticas() {
		if (btnEstadisticas == null) {
			btnEstadisticas = new JButton("Estad\u00EDsticas");
			btnEstadisticas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

		            new Estadisticas().setVisible(true);
		            dispose();
				}
			});
		}
		return btnEstadisticas;
	}
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
		}
		return btnSalir;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(new BorderLayout(0, 0));
			panel_2.add(getPanel_1());
		}
		return panel_2;
	}
	private JLabel getLblBienvenidoATrivial() {
		if (lblBienvenidoATrivial == null) {
			lblBienvenidoATrivial = new JLabel("Bienvenido a Treevial");
			lblBienvenidoATrivial.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblBienvenidoATrivial;
	}
	private JButton getBtnRegistro() {
		if (btnRegistro == null) {
			btnRegistro = new JButton("Registro");
			btnRegistro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					 new Registro().setVisible(true);
			            dispose();
					
				}
			});
		}
		return btnRegistro;
	}
	private JButton getBtnAdmin() {
		if (btnAdmin == null) {
			btnAdmin = new JButton("Admin");
			btnAdmin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					new Admin().setVisible(true);
		            dispose();
				}
			});
		}
		return btnAdmin;
	}
}

