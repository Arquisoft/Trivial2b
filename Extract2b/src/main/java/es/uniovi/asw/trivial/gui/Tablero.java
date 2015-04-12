<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/master
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
import javax.swing.border.EmptyBorder;

import es.uniovi.asw.trivial.business.juego.ControladorJuego;
import es.uniovi.asw.trivial.model.Posicion;
import es.uniovi.asw.trivial.model.Usuario;

public class Tablero extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnDado;


	private JPanel panelTablero;
	private int tamTablero = 9;
	private ControladorJuego cj;
	private JButton[][] botones = new JButton[tamTablero][tamTablero];
	private int[][] tablero =new int[tamTablero][tamTablero];
	private boolean defaultColors = true;
	private JPanel panelJugadores;
	private JPanel panel_3;
	private JPanel panel_4;
	private JLabel lblNewLabel;
	private int colorActual = 0;
	public final int posi=0;
	public final int posj=0;
	private List<Color> colores = new ArrayList<Color>();

	public List<Color> getColores() {
		return colores;
	}

	public void setColores(List<Color> colores) {
		this.colores = colores;
	}

	private int usuarioJugando = 0;

	public Tablero(int tam, Color[] colors, ControladorJuego cj) {
		
		for(UIManager.LookAndFeelInfo laf:UIManager.getInstalledLookAndFeels())
			if("Metal".equals(laf.getName()))
				try{
					UIManager.setLookAndFeel(laf.getClassName());
				}catch(Exception e){
					e.printStackTrace();
				}
		
		UIManager.put("Button.disabled", UIManager.get("Button.enabled"));
		this.tamTablero = tam;
		this.botones = new JButton[tamTablero][tamTablero];
		this.tablero =new int[tamTablero][tamTablero];
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

	private void activarCeldasSegunTirada() {
		int iUsuario=cj.getUsuarios().get(usuarioJugando).getPosicion().getI();
		int jUsuario=cj.getUsuarios().get(usuarioJugando).getPosicion().getJ();
		int tirada=Integer.valueOf(lblNewLabel.getText());
		System.out.println("Posicion usuario: ");
		System.out.println(iUsuario+"-"+jUsuario);
		
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[i].length; j++) {
				
				if(Math.abs(i-iUsuario)==tirada && tablero[i][jUsuario]!=-1){
					botones[i][jUsuario].setEnabled(true);
					botones[i][jUsuario].setText("Ir");
				}
				
				if(Math.abs(j-jUsuario)==tirada && tablero[iUsuario][j]!=-1){
					botones[iUsuario][j].setEnabled(true);
					botones[iUsuario][j].setText("Ir");
				}
				
				if(Math.abs(i-iUsuario)+Math.abs(j-jUsuario)==tirada && tablero[i][j]!=-1){
					botones[i][j].setEnabled(true);
					botones[i][j].setText("Ir");
				}
			}
		}
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

	public JButton getBtnDado() {
		if (btnDado == null) {
			btnDado = new JButton("");
			btnDado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					//estadoBotones(true);
					getBtnDado().setEnabled(false);
					Random rand = new Random();
					int randomNum = rand.nextInt(MAXIMODADO) + MINIMODADO;

					lblNewLabel.setText(String.valueOf(randomNum));
					activarCeldasSegunTirada();
				}
			});
			btnDado.setBackground(Color.WHITE);
			btnDado.setForeground(Color.WHITE);
			btnDado
					.setIcon(new ImageIcon(
							Tablero.class
									.getResource("/es/uniovi/asw/trivial/gui/img/icono-dado.jpg")));
			btnDado.setToolTipText("Tirar Dado");
		}
		return btnDado;
	}



	public JPanel getPanelTablero() {
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
			estadoBotones(false);
		}
		return panelTablero;
	}
	
	public void estadoBotones(boolean estado){
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[i].length; j++) {
				botones[i][j].setEnabled(estado);
				
				if (estado && (i != 0 && i != botones.length / 2 && i != botones.length - 1)
						&& (j != 0 && j != botones.length / 2 && j != botones.length - 1)) {
					botones[i][j].setBackground(Color.WHITE);
					botones[i][j].setEnabled(false);
					botones[i][j].setBorder(null);
				}
			}
		}
	}
	
	public class BotonesPosicion implements ActionListener {
	    JButton unBoton;
	 
	    public Posicion p;
		 
	    public void set(int i,int j,JButton boton) {
	          p=new Posicion(i,j);
	          this.unBoton=boton;
	    }  
	    
	    public void agregaAction () {
	          unBoton.addActionListener(this);
	    }
	    
	 
	    public void actionPerformed (ActionEvent e) {
	    	unBoton.setText("");
	    	new SelectTypeDialog(Color.WHITE, Tablero.this,p).setVisible(true);
	    }
	}
	
	public class BotonesPosicion2 implements ActionListener {
	    JButton unBoton;
	 
	    public Posicion p;
	    
	    public Color colorDialog;
		 
	    public void set(int i,int j,JButton boton,Color color) {
	          p=new Posicion(i,j);
	          this.unBoton=boton;
	          this.colorDialog=color;
	    }  
	    
	    public void agregaAction () {
	          unBoton.addActionListener(this);
	    }
	    
	 
	    public void actionPerformed (ActionEvent e) {
	    	unBoton.setText("");
	    	PreguntaDialog dialog = new PreguntaDialog(p,
					colorDialog,
					getCollection(colorDialog),
					cj.getPreguntas()
							.get(getCollection(colorDialog))
							.get(new Random()
									.nextInt(cj
											.getPreguntas()
											.get(getCollection(colorDialog))
											.size())), Tablero.this);
			dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
			dialog.setVisible(true);
	    }
	}
	

	private void rellenarBotones() {

		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[i].length; j++) {
				tablero[i][j]=0;
				
				
				botones[i][j] = new JButton("n" + "[" + i + "][" + j + "]");
				//System.out.println(botones[i][j].getText());
				if ((i == 0 && j == botones.length - 1) || (i == 0 && j == 0)
						|| (i == botones.length - 1 && j == botones.length - 1)
						|| (i == botones.length - 1 && j == 0)
						|| (i == botones.length / 2 && j == botones.length / 2)) {
					botones[i][j].setBackground(Color.WHITE);
					botones[i][j].setBorder(BorderFactory
							.createLineBorder(Color.ORANGE));

					BotonesPosicion p=new BotonesPosicion();
					p.set(i, j,botones[i][j]);
					p.agregaAction();
					/*
					botones[i][j].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//Color tipopreg = colores.get(new Random()
								//	.nextInt(colores.size()));
							/*new PreguntaDialog(Color.WHITE, "Especial "
									+ getCollection(tipopreg), cj
									.getPreguntas()
									.get(getCollection(tipopreg))
									.get(new Random().nextInt(cj.getPreguntas()
											.get(getCollection(tipopreg))
											.size())), Tablero.this)
									.setVisible(true);
							new SelectTypeDialog(Color.WHITE, Tablero.this).setVisible(true);

						}
					});
					*/
				} else if ((i != 0 && i != botones.length / 2 && i != botones.length - 1)
						&& (j != 0 && j != botones.length / 2 && j != botones.length - 1)) {
					botones[i][j].setBackground(Color.WHITE);
					botones[i][j].setEnabled(false);
					botones[i][j].setBorder(null);
					tablero[i][j]=-1;
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

	public int[][] getTablero() {
		return tablero;
	}

	public void setTablero(int[][] tablero) {
		this.tablero = tablero;
	}

	private void pintarCelda(JButton but, int i, int j, int colorActual) {

		but.setBackground(colores.get(colorActual));
		final Color colorDialog = colores.get(colorActual);
		
		BotonesPosicion2 b=new BotonesPosicion2();
		b.set(i, j,but,colorDialog);
		b.agregaAction();
		
		/*
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
		

				dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
				dialog.setVisible(true);

			}
		});
		*/
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

	public String getCollection(Color color) {
		if (color.equals(Color.RED))
			return "deportes";
		else if (color.equals(Color.BLUE))
			return "historia";
		else if (color.equals(Color.YELLOW))
			return "ciencias";
		else if (color.equals(Color.GREEN))
			return "entretenimiento";
		else if (color.equals(Color.CYAN))
			return "geografia";
		else if (color.equals(Color.WHITE))
			return "Especial";
		else
			return "";
	}
	
	public List<String> getAllCategories(List<Color> colores){
		List<String> categorias= new ArrayList<String>();
		for(Color color: colores)
			categorias.add(getCollection(color));
		return categorias;
		
	}

	List<JTextField> nombresUsuarios = new ArrayList<JTextField>();
	List<JPanel> panelesUsuarios = new ArrayList<JPanel>();


	public List<JPanel> getPanelesUsuarios() {
		return panelesUsuarios;
	}

	public void setPanelesUsuarios(List<JPanel> panelesUsuarios) {
		this.panelesUsuarios = panelesUsuarios;
	}

	public List<JTextField> getNombresUsuarios() {
		return nombresUsuarios;
	}

	public void setNombresUsuarios(List<JTextField> nombresUsuarios) {
		this.nombresUsuarios = nombresUsuarios;
	}

	public JPanel getPanelJugadores() {
		if (panelJugadores == null) {
			panelJugadores = new JPanel();
			panelJugadores.setBackground(Color.WHITE);
			panelJugadores.setLayout(new GridLayout(cj.getUsuarios().size(), 1,
					0, 0));

			int i = 0;
			for (Usuario user : cj.getUsuarios()) {

				JTextField nombreJugador = new JTextField(user.getLogin());
				JPanel panelJugador = new JPanel();
				panelJugador.setBackground(Color.WHITE);
				panelJugador.setLayout(new GridLayout((colores.size()/2), (colores.size()/2),
						0, 0));
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
				panelesUsuarios.add(panelJugador);
				nombresUsuarios.add(nombreJugador);
				panelJugadores.add(nombreJugador);
				panelJugadores.add(lblProfile);
				panelJugadores.add(panelJugador);

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
			panel_3.add(getBtnDado());
			panel_3.add(getLblNewLabel());
		}
		return panel_3;
	}

	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setBackground(Color.WHITE);
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
<<<<<<< HEAD
=======
=======
>>>>>>> parent of 718e7d1... a
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
import javax.swing.border.EmptyBorder;

import es.uniovi.asw.trivial.business.juego.ControladorJuego;
import es.uniovi.asw.trivial.model.Posicion;
import es.uniovi.asw.trivial.model.Usuario;

public class Tablero extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnDado;


	private JPanel panelTablero;
	private int tamTablero = 9;
	private ControladorJuego cj;
	private JButton[][] botones = new JButton[tamTablero][tamTablero];
	private int[][] tablero =new int[tamTablero][tamTablero];
	private boolean defaultColors = true;
	private JPanel panelJugadores;
	private JPanel panel_3;
	private JPanel panel_4;
	private JLabel lblNewLabel;
	private int colorActual = 0;
	public final int posi=0;
	public final int posj=0;
	private List<Color> colores = new ArrayList<Color>();

	public List<Color> getColores() {
		return colores;
	}

	public void setColores(List<Color> colores) {
		this.colores = colores;
	}

	private int usuarioJugando = 0;

	public Tablero(int tam, Color[] colors, ControladorJuego cj) {
<<<<<<< HEAD
		
		for(UIManager.LookAndFeelInfo laf:UIManager.getInstalledLookAndFeels())
			if("Metal".equals(laf.getName()))
				try{
					UIManager.setLookAndFeel(laf.getClassName());
				}catch(Exception e){
					e.printStackTrace();
				}
		
=======
>>>>>>> parent of 718e7d1... a
		UIManager.put("Button.disabled", UIManager.get("Button.enabled"));
		this.tamTablero = tam;
		this.botones = new JButton[tamTablero][tamTablero];
		this.tablero =new int[tamTablero][tamTablero];
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

	private void activarCeldasSegunTirada() {
		int iUsuario=cj.getUsuarios().get(usuarioJugando).getPosicion().getI();
		int jUsuario=cj.getUsuarios().get(usuarioJugando).getPosicion().getJ();
		int tirada=Integer.valueOf(lblNewLabel.getText());
<<<<<<< HEAD
		System.out.println("Posicion usuario: ");
		System.out.println(iUsuario+"-"+jUsuario);
=======
>>>>>>> parent of 718e7d1... a
		
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[i].length; j++) {
				
<<<<<<< HEAD
				if(Math.abs(i-iUsuario)==tirada && tablero[i][jUsuario]!=-1){
					botones[i][jUsuario].setEnabled(true);
					botones[i][jUsuario].setText("Ir");
				}
				
				if(Math.abs(j-jUsuario)==tirada && tablero[iUsuario][j]!=-1){
					botones[iUsuario][j].setEnabled(true);
					botones[iUsuario][j].setText("Ir");
				}
				
				if(Math.abs(i-iUsuario)+Math.abs(j-jUsuario)==tirada && tablero[i][j]!=-1)
					botones[i][j].setEnabled(true);
					botones[i][j].setText("Ir");
=======
				if(tablero[i][j]!=-1){
				if(Math.abs(i-iUsuario)==tirada){
					botones[i][jUsuario].setEnabled(true);
				}
				
				if(Math.abs(j-jUsuario)==tirada){
					botones[iUsuario][j].setEnabled(true);
				}
				
				if(Math.abs(i-iUsuario)+Math.abs(j-jUsuario)==tirada)
					botones[i][j].setEnabled(true);
				}
>>>>>>> parent of 718e7d1... a
			}
		}
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

	public JButton getBtnDado() {
		if (btnDado == null) {
			btnDado = new JButton("");
			btnDado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					//estadoBotones(true);
					getBtnDado().setEnabled(false);
					Random rand = new Random();
					int randomNum = rand.nextInt(MAXIMODADO) + MINIMODADO;

					lblNewLabel.setText(String.valueOf(randomNum));
					activarCeldasSegunTirada();
				}
			});
			btnDado.setBackground(Color.WHITE);
			btnDado.setForeground(Color.WHITE);
			btnDado
					.setIcon(new ImageIcon(
							Tablero.class
									.getResource("/es/uniovi/asw/trivial/gui/img/icono-dado.jpg")));
			btnDado.setToolTipText("Tirar Dado");
		}
		return btnDado;
	}



	public JPanel getPanelTablero() {
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
			estadoBotones(false);
		}
		return panelTablero;
	}
	
	public void estadoBotones(boolean estado){
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[i].length; j++) {
				botones[i][j].setEnabled(estado);
				
				if (estado && (i != 0 && i != botones.length / 2 && i != botones.length - 1)
						&& (j != 0 && j != botones.length / 2 && j != botones.length - 1)) {
					botones[i][j].setBackground(Color.WHITE);
					botones[i][j].setEnabled(false);
					botones[i][j].setBorder(null);
				}
			}
		}
	}
	
	public class BotonesPosicion implements ActionListener {
	    JButton unBoton;
	 
	    public Posicion p;
		 
	    public void set(int i,int j,JButton boton) {
<<<<<<< HEAD
=======
	    	System.out.println("set");
>>>>>>> parent of 718e7d1... a
	          p=new Posicion(i,j);
	          this.unBoton=boton;
	    }  
	    
	    public void agregaAction () {
	          unBoton.addActionListener(this);
	    }
<<<<<<< HEAD
	    
	 
	    public void actionPerformed (ActionEvent e) {
=======
	 
	    public void actionPerformed (ActionEvent e) {
	    	System.out.println("ACT");
>>>>>>> parent of 718e7d1... a
	    	new SelectTypeDialog(Color.WHITE, Tablero.this,p).setVisible(true);
	    }
	}
	
<<<<<<< HEAD
	public class BotonesPosicion2 implements ActionListener {
	    JButton unBoton;
	 
	    public Posicion p;
	    
	    public Color colorDialog;
		 
	    public void set(int i,int j,JButton boton,Color color) {
	          p=new Posicion(i,j);
	          this.unBoton=boton;
	          this.colorDialog=color;
	    }  
	    
	    public void agregaAction () {
	          unBoton.addActionListener(this);
	    }
	    
	 
	    public void actionPerformed (ActionEvent e) {
	    	PreguntaDialog dialog = new PreguntaDialog(p,
					colorDialog,
					getCollection(colorDialog),
					cj.getPreguntas()
							.get(getCollection(colorDialog))
							.get(new Random()
									.nextInt(cj
											.getPreguntas()
											.get(getCollection(colorDialog))
											.size())), Tablero.this);
			dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
			dialog.setVisible(true);
	    }
	}
	
=======
>>>>>>> parent of 718e7d1... a

	private void rellenarBotones() {

		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[i].length; j++) {
				tablero[i][j]=0;
				
				
				botones[i][j] = new JButton("n" + "[" + i + "][" + j + "]");
<<<<<<< HEAD
				//System.out.println(botones[i][j].getText());
=======

>>>>>>> parent of 718e7d1... a
				if ((i == 0 && j == botones.length - 1) || (i == 0 && j == 0)
						|| (i == botones.length - 1 && j == botones.length - 1)
						|| (i == botones.length - 1 && j == 0)
						|| (i == botones.length / 2 && j == botones.length / 2)) {
					botones[i][j].setBackground(Color.WHITE);
					botones[i][j].setBorder(BorderFactory
							.createLineBorder(Color.ORANGE));

					BotonesPosicion p=new BotonesPosicion();
					p.set(i, j,botones[i][j]);
					p.agregaAction();
					/*
					botones[i][j].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//Color tipopreg = colores.get(new Random()
								//	.nextInt(colores.size()));
							/*new PreguntaDialog(Color.WHITE, "Especial "
									+ getCollection(tipopreg), cj
									.getPreguntas()
									.get(getCollection(tipopreg))
									.get(new Random().nextInt(cj.getPreguntas()
											.get(getCollection(tipopreg))
											.size())), Tablero.this)
									.setVisible(true);
							new SelectTypeDialog(Color.WHITE, Tablero.this).setVisible(true);

						}
					});
					*/
				} else if ((i != 0 && i != botones.length / 2 && i != botones.length - 1)
						&& (j != 0 && j != botones.length / 2 && j != botones.length - 1)) {
					botones[i][j].setBackground(Color.WHITE);
					botones[i][j].setEnabled(false);
					botones[i][j].setBorder(null);
					tablero[i][j]=-1;
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

	public int[][] getTablero() {
		return tablero;
	}

	public void setTablero(int[][] tablero) {
		this.tablero = tablero;
	}

	private void pintarCelda(JButton but, int i, int j, int colorActual) {

		but.setBackground(colores.get(colorActual));
<<<<<<< HEAD
		final Color colorDialog = colores.get(colorActual);
		
		BotonesPosicion2 b=new BotonesPosicion2();
		b.set(i, j,but,colorDialog);
		b.agregaAction();
		
		/*
		but.addActionListener(new ActionListener() {
			
=======

		final Color colorDialog = colores.get(colorActual);
		but.addActionListener(new ActionListener() {

>>>>>>> parent of 718e7d1... a
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
		

				dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
				dialog.setVisible(true);

			}
		});
<<<<<<< HEAD
		*/
=======
>>>>>>> parent of 718e7d1... a
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

	public String getCollection(Color color) {
		if (color.equals(Color.RED))
			return "deportes";
		else if (color.equals(Color.BLUE))
			return "historia";
		else if (color.equals(Color.YELLOW))
			return "ciencias";
		else if (color.equals(Color.GREEN))
			return "entretenimiento";
		else if (color.equals(Color.CYAN))
			return "geografia";
		else if (color.equals(Color.WHITE))
			return "Especial";
		else
			return "";
	}
	
	public List<String> getAllCategories(List<Color> colores){
		List<String> categorias= new ArrayList<String>();
		for(Color color: colores)
			categorias.add(getCollection(color));
		return categorias;
		
	}

	List<JTextField> nombresUsuarios = new ArrayList<JTextField>();
	List<JPanel> panelesUsuarios = new ArrayList<JPanel>();


	public List<JPanel> getPanelesUsuarios() {
		return panelesUsuarios;
	}

	public void setPanelesUsuarios(List<JPanel> panelesUsuarios) {
		this.panelesUsuarios = panelesUsuarios;
	}

	public List<JTextField> getNombresUsuarios() {
		return nombresUsuarios;
	}

	public void setNombresUsuarios(List<JTextField> nombresUsuarios) {
		this.nombresUsuarios = nombresUsuarios;
	}

	public JPanel getPanelJugadores() {
		if (panelJugadores == null) {
			panelJugadores = new JPanel();
			panelJugadores.setBackground(Color.WHITE);
			panelJugadores.setLayout(new GridLayout(cj.getUsuarios().size(), 1,
					0, 0));

			int i = 0;
			for (Usuario user : cj.getUsuarios()) {

				JTextField nombreJugador = new JTextField(user.getLogin());
				JPanel panelJugador = new JPanel();
				panelJugador.setBackground(Color.WHITE);
				panelJugador.setLayout(new GridLayout((colores.size()/2), (colores.size()/2),
						0, 0));
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
				panelesUsuarios.add(panelJugador);
				nombresUsuarios.add(nombreJugador);
				panelJugadores.add(nombreJugador);
				panelJugadores.add(lblProfile);
				panelJugadores.add(panelJugador);

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
			panel_3.add(getBtnDado());
			panel_3.add(getLblNewLabel());
		}
		return panel_3;
	}

	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setBackground(Color.WHITE);
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
<<<<<<< HEAD
>>>>>>> origin/master
=======
>>>>>>> parent of 718e7d1... a
=======
>>>>>>> origin/master
