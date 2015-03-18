package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Tablero extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblDado;
	private JButton btnNewButton;
	private JPanel panel_2;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JPanel panelTablero;
	private int tamTablero=9;
	private int numJugadores=2;
	private HashMap<Integer, HashMap<Color, Integer>> cuentaColores = new HashMap<Integer, HashMap<Color, Integer>>();
	private JButton[][] botones = new JButton[tamTablero][tamTablero];
	private boolean defaultColors = true;
	private JPanel panel_3;
	private JLabel lblPuntuacin;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Tablero frame = new Tablero();
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
	public Tablero() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tablero.class.getResource("/img/tab.png")));
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
	public Tablero(int tam, int numJugadores) {
		this.tamTablero=tam;
		this.botones = new JButton[tamTablero][tamTablero];
		this.numJugadores=numJugadores;
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tablero.class.getResource("/img/tab.png")));
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

	public Tablero(int tam, int numJugadores, Color[] colors) {
		this.tamTablero=tam;
		this.botones = new JButton[tamTablero][tamTablero];
		this.defaultColors=false;
		asignarColores(colors);
		this.numJugadores=numJugadores;
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tablero.class.getResource("/img/tab.png")));
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

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setLayout(new GridLayout(0, 1, 0, 0));
			panel.add(getPanel_1());
			panel.add(getPanel_2());
			panel.add(getPanel_3());
		}
		return panel;
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(Color.WHITE);
			panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel_1.add(getLblDado());
			panel_1.add(getBtnNewButton());
		}
		return panel_1;
	}

	private JLabel getLblDado() {
		if (lblDado == null) {
			lblDado = new JLabel("");
			lblDado.setIcon(new ImageIcon(Tablero.class.getResource("/img/icono-dado.jpg")));
		}
		return lblDado;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Tirar Dado!\r\n");
		}
		return btnNewButton;
	}

	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBackground(Color.WHITE);
			panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel_2.add(getLblNewLabel_1());
			panel_2.add(getTextField());
		}
		return panel_2;
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

			panelTablero.setLayout(new GridLayout(tamTablero, tamTablero, 0, 0));
			//asignarColores();
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
						|| (i == botones.length / 2 && j == botones.length / 2)){
					botones[i][j].setBackground(Color.WHITE);
					botones[i][j].setBorder(BorderFactory.createLineBorder(Color.ORANGE));
					botones[i][j].addActionListener(new ActionListener() { 
			            public void actionPerformed(ActionEvent e)
			            {
			               
			               new PreguntaDialog(Color.WHITE).setVisible(true);
			               
			            }
			        });      
					}
				else if ((i != 0 && i != botones.length / 2 && i != botones.length - 1)
						&& (j != 0 && j != botones.length / 2 && j != botones.length - 1)) {
					botones[i][j].setBackground(Color.black);
					botones[i][j].setEnabled(false);
					botones[i][j].setBorder(null);
				} else
					while (botones[i][j].getBackground().equals(
							UIManager.getColor("Button.background"))) {
						botones[i][j].setBorder(BorderFactory.createLineBorder(Color.ORANGE));
						Random rm = new Random();
						int key = rm.nextInt(cuentaColores.size());
						pintarAleatorio(botones[i][j], cuentaColores, key);
					}
			
				botones[i][j].setText(null);
			}
		}

	}

	private void asignarColores(Color... colors) {
		if (defaultColors) {
			HashMap<Color, Integer> color = new HashMap<Color, Integer>();
			color.put(Color.RED, 0);
			cuentaColores.put(0, color);
			HashMap<Color, Integer> color1 = new HashMap<Color, Integer>();
			color1.put(Color.blue, 0);
			cuentaColores.put(1, color1);
			HashMap<Color, Integer> color2 = new HashMap<Color, Integer>();
			color2.put(Color.YELLOW, 0);
			cuentaColores.put(2, color2);
			HashMap<Color, Integer> color3 = new HashMap<Color, Integer>();
			color3.put(Color.green, 0);
			cuentaColores.put(3, color3);
		} else {
			int i=0;
			for(Color color : colors){
				HashMap<Color, Integer> colorMap = new HashMap<Color, Integer>();
				colorMap.put(color, 0);
				cuentaColores.put(i, colorMap);
				i++;
				}
			//Aqui iria el codigo para que recuperase los colores con el que el jugador quiere jugar y los meta al array de colores
			
		}
	}
	private  int getNumeroColoreables(){
		int num=0;
		num= (tamTablero*tamTablero) -((tamTablero-3)*(tamTablero-3)+5);
		return num;
	}

	private void pintarAleatorio(JButton but,
			HashMap<Integer, HashMap<Color, Integer>> colores, int key) {
		Set<Color> arg = cuentaColores.get(key).keySet();
		for (Color color : arg) {

			if (cuentaColores.get(key).get(color) < (getNumeroColoreables() / cuentaColores.size())) {
				but.setBackground(color);
				cuentaColores.get(key).put(color,
						cuentaColores.get(key).get(color) + 1);
				final Color colorDialog = color;
				but.addActionListener(new ActionListener() {
					 
		            public void actionPerformed(ActionEvent e)
		            {
		               
		               PreguntaDialog dialog=new PreguntaDialog(colorDialog);
		               //descomentar esto cuando se acabe la funcionalidad
		              // dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		         
		               dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		               dialog.setVisible(true);
		               
		            }
		        });      

			}
		}
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setBackground(Color.WHITE);
			panel_3.add(getLblPuntuacin());
			panel_3.add(getTextField_1());
		}
		return panel_3;
	}
	private JLabel getLblPuntuacin() {
		if (lblPuntuacin == null) {
			lblPuntuacin = new JLabel("Puntuaci\u00F3n:");
		}
		return lblPuntuacin;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setEnabled(false);
			textField_1.setEditable(false);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
}
