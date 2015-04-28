package controllers;

import play.*;
import play.data.Form;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
	
	public static class Login {
		public String id;
		public String password;

		public String validate() {
			if (!id.equals("a") && !password.equals("garcia")) {
				return "Usuario o contraseña inválida";
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

			if(loginForm.get().id.equals("marcos"))
				return ok(principal.render());
			else
		        return ok(index.render("asdsaddYour new application is ready."));
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
    public static class Register {
		public String id;
		public String password;
		public String password2;

	}
}
