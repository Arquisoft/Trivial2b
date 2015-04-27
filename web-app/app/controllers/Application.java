package controllers;

import play.*;
import play.data.Form;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("asdsaddYour new application is ready."));
    }
    
    public static Result showRegister() {
		return ok(register.render(Form.form(Register.class)));
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
