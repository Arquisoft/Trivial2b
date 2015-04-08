package es.uniovi.asw.trivial.model;

public class Usuario {
	private String login;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Usuario() {
	}

	public Usuario(String login, String contrasena, String nombre,
			String apellidos) {
		super();
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

	private String contrasena;
	private String nombre;
	private String apellidos;
	// /atributos para estadisticas
}
