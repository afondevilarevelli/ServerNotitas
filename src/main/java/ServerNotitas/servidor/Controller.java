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
	
	public ModelAndView postLogin() {
		//algun redirect
		return new ModelAndView(null, "login.hbs");
	}
	
	public ModelAndView homeAlumno() {
		return new ModelAndView(null, "login.hbs");
	}
	
}
