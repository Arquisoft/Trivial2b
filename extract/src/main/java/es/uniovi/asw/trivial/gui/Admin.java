package es.uniovi.asw.trivial.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import es.uniovi.asw.trivial.business.AdminService;
import es.uniovi.asw.trivial.business.impl.AdminServiceImpl;

public class Admin extends JFrame {

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
	private JTextField textFieldRuta;
	private JButton btnCargar;
	private JButton btnBorrarBaseDe;
	private JLabel lblNombreColleccin;
	private JPanel panel_2;
	private JButton btnAbrir;
	private JComboBox<String> comboBox;


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
					Admin frame = new Admin();
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
	public Admin() {
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
			btnSalir = new JButton("Atras");
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
			panel.add(getPanel_2_1());
		}
		return panel;
	}
	private JLabel getLblEstadsticasDelJuego() {
		if (lblEstadsticasDelJuego == null) {
			lblEstadsticasDelJuego = new JLabel("Administrador");
			lblEstadsticasDelJuego.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblEstadsticasDelJuego.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblEstadsticasDelJuego;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.add(getLblPartidasJugadas());
			panel_1.add(getTextFieldRuta());
			panel_1.add(getLblNombreColleccin());
			panel_1.add(getComboBox());
		}
		return panel_1;
	}
	private JLabel getLblPartidasJugadas() {
		if (lblPartidasJugadas == null) {
			lblPartidasJugadas = new JLabel("Ruta fichero .GIFT");
		}
		return lblPartidasJugadas;
	}
	private JTextField getTextFieldRuta() {
		if (textFieldRuta == null) {
			textFieldRuta = new JTextField();
			textFieldRuta.setColumns(35);
		}
		return textFieldRuta;
	}
	private JButton getBtnCargar() {
		if (btnCargar == null) {
			btnCargar = new JButton("Cargar");
			btnCargar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					AdminService aS = new AdminServiceImpl();
					String res = aS.cargarEnBase(textFieldRuta.getText(), comboBox.getSelectedItem().toString());
					JOptionPane.showMessageDialog(null, res);
				}
			});
			btnCargar.setBounds(168, 11, 102, 23);
		}
		return btnCargar;
	}
	private JButton getBtnBorrarBaseDe() {
		if (btnBorrarBaseDe == null) {
			btnBorrarBaseDe = new JButton("Borrar Base de datos");
			btnBorrarBaseDe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					AdminService aS = new AdminServiceImpl();
					String res = aS.removeDataBase();
					
					JOptionPane.showMessageDialog(null, res);
						
				}
			});
			btnBorrarBaseDe.setBounds(134, 48, 178, 23);
		}
		return btnBorrarBaseDe;
	}
	private JLabel getLblNombreColleccin() {
		if (lblNombreColleccin == null) {
			lblNombreColleccin = new JLabel("Nombre collecci\u00F3n");
		}
		return lblNombreColleccin;
	}
	private JPanel getPanel_2_1() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.add(getBtnCargar());
			panel_2.add(getBtnBorrarBaseDe());
			panel_2.add(getBtnAbrir());
		}
		return panel_2;
	}
	private void abrirArchivo(){
		
		 JFileChooser file = new JFileChooser(); 
		 file.showOpenDialog(this);
         file.setFileSelectionMode(JFileChooser.FILES_ONLY);
         final File archivo = file.getSelectedFile();
		
         textFieldRuta.setText(archivo.getPath());
		
	}
	private JButton getBtnAbrir() {
		if (btnAbrir == null) {
			btnAbrir = new JButton("Abrir");
			btnAbrir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					abrirArchivo();
				}
			});
			btnAbrir.setBounds(27, 48, 89, 23);
		}
		return btnAbrir;
	}

	private JComboBox<String> getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox<String>();
			comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"ciencias", "deportes", "entretenimiento", "geografia", "historia"}));
		}
		return comboBox;
	}
}
