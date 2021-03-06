package es.uniovi.asw.trivial.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private String login;
	private String contrasena;
	private String nombre;
	private String apellidos;
	private boolean tocaJugar = false;
	private Posicion posicion=new Posicion();

	private List<String> categoriasGanadas= new ArrayList<String>();

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Usuario() {
	}
	
	public Usuario(String login, String contrasena) {
		this.login = login;
		this.contrasena = contrasena;
	}

	public Usuario(String login, String contrasena, String nombre,
			String apellidos) {
		this.login = login;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public boolean isTocaJugar() {
		return tocaJugar;
	}

	public void setTocaJugar(boolean tocaJugar) {
		this.tocaJugar = tocaJugar;
	}

	public boolean isGanador(int size) {
		if (categoriasGanadas.size()==size)
			return true;
		return false;
	}

	public List<String> getCategoriasGanadas() {
		return categoriasGanadas;
	}

	public void setCategoriasGanadas(List<String> categoriasGanadas) {
		this.categoriasGanadas = categoriasGanadas;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}


	
	

}
