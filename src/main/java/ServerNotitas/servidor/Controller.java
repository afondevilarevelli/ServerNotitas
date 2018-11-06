package ServerNotitas.servidor;

import java.util.HashMap;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class Controller {
	private Request request;
    private Response response;
    
	public Controller(Request req, Response res) {
		super();
		this.request = req;
		this.response = res;
	}
	
	public ModelAndView getLogin() {
		return new ModelAndView(null, "login.hbs");
	}
	
	public String postLogin() {
		String username = request.queryParams("nombreUsuario");
        String pass = request.queryParams("contrasenia");
      //verificar el token 
        
        //Si puede entrar
        response.cookie("nombre", "Antonio");
        response.cookie("apellido", "Fondevila");
        response.cookie("legajo", "1592123");
        response.cookie("githubUser", username);
        response.cookie("password", pass);        
		response.redirect("/home");
		return null;
	}
	
	public ModelAndView homeAlumno() {
		HashMap<String, Object> viewModel = new HashMap<>();
		viewModel.put("nombre", request.cookie("nombre"));
		viewModel.put("apellido", request.cookie("apellido"));
		viewModel.put("legajo", request.cookie("legajo"));
		viewModel.put("githubUser", request.cookie("githubUser"));
		viewModel.put("password", request.cookie("password"));
		return new ModelAndView(viewModel, "homeAlumno.hbs");
	}
	
	public ModelAndView getStudent() {
		return new ModelAndView(null, "homeAlumno.hbs");
	}
	
	public ModelAndView putStudent() {
		return new ModelAndView(null, "homeAlumno.hbs");
	}
	
	public ModelAndView getAssignments() {
		return new ModelAndView(null, "homeAlumno.hbs");
	}
}
