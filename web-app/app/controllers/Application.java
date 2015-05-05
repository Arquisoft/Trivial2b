package controllers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.admin;
import views.html.estadisticas;
import views.html.index;
import views.html.principal;
import views.html.register;
import business.UsuarioService;
import business.impl.UsuarioServiceImpl;

public class Application extends Controller {

	public static class Login {
		public String id;
		public String password;

		public String validate() throws IOException {
			UsuarioService us = new UsuarioServiceImpl();
			if (us.login(id, password) == null) {
				return "Usuario o contrasena invalida";
			}
			return null;
		}
	}

	public static Result logout() {
		session().clear();
		return ok(index.render("Sesion cerrada"));
	}

	public static Result authenticate() {
		Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
		if (loginForm.hasErrors()) {
			return badRequest(index.render("Error en la autentificacion"));
		} else {
			session().clear();
			session("id", loginForm.get().id);

			if (loginForm.get().id.equals("admin"))
				return showAdmin();
			else
				return showPrincipal();
		}
	}

	public static class Register {
		public String id;
		public String pass;
		public String pass2;

		public String validate() throws IOException {
			UsuarioService us = new UsuarioServiceImpl();
			if (id.equals("") || pass.equals("") || pass2.equals(""))
				return "Ningun campo puede estar vacio";
			else if (us.findByLogin(id) != null)
				return "Usuario ya existente";
			else if (!pass.equals(pass2))
				return "Las contraseñas no coinciden";
			else {
				escribeFichero();
				us.newUsuario(id, pass);
			}
			return null;
		}

	}

	public static Result registrate() {
		Form<Register> registerForm = Form.form(Register.class)
				.bindFromRequest();
		if (registerForm.hasErrors()) {
			return badRequest(register.render(Form.form(Register.class)));
		} else {
			session().clear();
			session("id", registerForm.get().id);

			return showPrincipal();
		}
	}

	public static Result index() {
		return ok(index.render("asdsaddYour new application is ready."));
	}

	public static Result showRegister() {
		return ok(register.render(Form.form(Register.class)));
	}

	public static Result showPrincipal() {
		return ok(principal.render());
	}

	public static Result showEstadisticas() {
		return ok(estadisticas.render());
	}

	public static Result showAdmin() {
		return ok(admin.render());
	}

	private static void escribeFichero() { // Borrar metodo
		File file = new File("archivo.txt");
		FileWriter fw;
		BufferedWriter bw;
		try {
			fw = new FileWriter(file.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			bw.write("hola que ase");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
