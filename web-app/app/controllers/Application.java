package controllers;

import java.io.IOException;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.admin;
import views.html.estadisticas;
import views.html.index;
import views.html.principal;
import views.html.register;
import business.AdminService;
import business.UsuarioService;
import business.impl.AdminServiceImpl;
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
        return ok(index.render("asdsaddYour new application is ready."));
	}
	
	public static Result authenticate() {
		Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
		if (loginForm.hasErrors()) {
			return badRequest(index.render("asdsaddYour new application is ready."));
		} else {
			session().clear();
			session("id", loginForm.get().id);
			
			if (loginForm.get().id.equals("admin"))
				 return showAdmin();
			else
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
    
    public static Result showEstadisticas(){
    	return ok(estadisticas.render());
    }
    public static Result showAdmin(){
    	return ok(admin.render());
    }
    
    public static class Cargar {
		public String ruta;
		public String categoria;
		
		public String validate() throws IOException {
			AdminService aS = new AdminServiceImpl();
			aS.cargarEnBase(ruta, categoria);
			return null;
		}
	}
    
    public static Result cargarBase(){
    	Form<Cargar> cargarForm = Form.form(Cargar.class).bindFromRequest();
    	return ok(admin.render());
    }
    
    
    
    public static class Register {
		public String id;
		public String password;
		public String password2;

	}
}
