package ServerNotitas.servidor;

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
		//verificar el token
		response.redirect("/home");
		return null;
	}
	
	public ModelAndView homeAlumno() {
		return new ModelAndView(null, "homeAlumno.hbs");
	}
	
}
