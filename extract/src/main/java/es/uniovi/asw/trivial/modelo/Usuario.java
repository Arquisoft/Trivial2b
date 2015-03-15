package modelo;

public class Usuario {
private String login;
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public Usuario(){}
public Usuario(String login, String contraseña, String nombre, String apellidos) {
	super();
	this.login = login;
	this.contraseña = contraseña;
	this.nombre = nombre;
	this.apellidos = apellidos;
}
public String getContraseña() {
	return contraseña;
}
public void setContraseña(String contraseña) {
	this.contraseña = contraseña;
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
private String contraseña;
private String nombre;
private String apellidos;
///atributos para estadisticas
}
