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
public Usuario(String login, String contrase�a, String nombre, String apellidos) {
	super();
	this.login = login;
	this.contrase�a = contrase�a;
	this.nombre = nombre;
	this.apellidos = apellidos;
}
public String getContrase�a() {
	return contrase�a;
}
public void setContrase�a(String contrase�a) {
	this.contrase�a = contrase�a;
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
private String contrase�a;
private String nombre;
private String apellidos;
///atributos para estadisticas
}
