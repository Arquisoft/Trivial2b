package controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.ChatRoom;
import model.Pregunta;
import model.Usuario;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.WebSocket;
import views.html.admin;
import views.html.chatRoom;
import views.html.estadisticas;
import views.html.index;
import views.html.join;
import views.html.principal;
import views.html.register;
import views.html.tablero;
import business.AdminService;
import business.JuegoService;
import business.UsuarioService;
import business.impl.AdminServiceImpl;
import business.impl.JuegoServiceImpl;
import business.impl.UsuarioServiceImpl;
import business.juego.ControladorJuego;

import com.fasterxml.jackson.databind.JsonNode;

public class Application extends Controller {
	
	private static ControladorJuego cj;
	private static final long ESPERA = 2000;

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
			else
				us.newUsuario(id, pass);
			
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
    	Form.form(Cargar.class).bindFromRequest();
		return showAdmin();
    }
    
    public static Result borrarBase(){
    	
    	AdminService aS = new AdminServiceImpl();
		aS.removeDataBase();
    	
		return showAdmin();
    }
    
    /**
     * Este  metodo requiere que las preguntas esten cargadas previamente en el mongoDB, sino no funcionará.
     *
     * @return
     */ 
     public static Result cargarTablero() {
     	
     	UsuarioService us = new UsuarioServiceImpl();
     	JuegoService js = new JuegoServiceImpl();
     	Map<String, List<Pregunta>> preguntas = new HashMap<>();
     	
     	Usuario u = us.findByLogin(session().get("id"));
     	String[] categorias = new String[]{"ciencias"};
     	
     	for (String cat: categorias) {
     		preguntas.put(cat, js.getPreguntasCollection(cat));
     	}

     	cj = new ControladorJuego(preguntas, u);
     	
     	return showTablero();
    }
    
    public static Result mostrarPreguntaHist() {
    	mostrarPregunta("historia");
    	return ok(tablero.render());
    }
    
    public static Result mostrarPreguntaCi() {
    	mostrarPregunta("ciencias");
    	return ok(tablero.render());
    }
    
    public static Result mostrarPreguntaDep() {
    	mostrarPregunta("deportes");
    	return ok(tablero.render());
    }
    
    public static Result mostrarPreguntaEnt() {
    	mostrarPregunta("entretenimiento");
    	return ok(tablero.render());
    }
    
    public static Result mostrarPreguntaGeo() {
    	mostrarPregunta("geografia");
    	return ok(tablero.render());
    }
     
    public static void mostrarPregunta(String categoria) {
    	Pregunta p = cj.obtenerPreguntaAleatoriaCategoria(categoria);
    	
    	
    	
    	session("pregunta", p.getPregunta());
    	for (int i = 0; i < p.getRespuestas().length; i++) {
    		session("respuesta" + i, p.getRespuestas()[i]);
    		session("contestacion" + i, p.getContestacion()[i]);
    	}
    	session("correcta", String.valueOf(p.getCorrecta()));
    	session("categoria", categoria);
    	
    	try {
			Thread.sleep(ESPERA);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
     	
    
    public static Result showTablero() {
    	return ok(tablero.render());
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

	public static Result showEstadisticas(String username) {
		return ok(estadisticas.render(session("id")));
	}

	public static Result showAdmin() {
		return ok(admin.render(Form.form(Cargar.class)));
	}

	public static Result showJoin(String username) {
		return ok(join.render(session("id")));
	}
	 
    public static Result chatRoom(String username) {
       /* if(username == null || username.trim().equals("")) {
            flash("error", "Please choose a valid username.");
            return redirect(routes.Application.showPrincipal());
        }*/
        return ok(chatRoom.render(session("id")));
    }

    public static Result chatRoomJs(String username) {
        return ok(views.js.chatRoom.render(session("id")));
    }
    
    
    public static WebSocket<JsonNode> chat(final String username) {
        return new WebSocket<JsonNode>() {
            
           
            public void onReady(WebSocket.In<JsonNode> in, WebSocket.Out<JsonNode> out){
                
                
                try { 
                    ChatRoom.join(username, in, out);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
    }



}
