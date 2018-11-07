package ServerNotitas.servidor;

import java.util.HashMap;

import com.google.gson.Gson;

import model.Alumno;
import servicios.AlumnoService;
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
	
	public ModelAndView getLoginFailed() {
		return new ModelAndView(null, "loginFailed.hbs");
	}
	
	public String postLogin() {
		String token = request.headers("Authorization");
		String username = request.queryParams("nombreUsuario");
        String pass = request.queryParams("contrasenia");
        Alumno al = AlumnoService.obtenerAlumno(username, pass);
        
        if(token == al.getToken()) {
        	response.cookie("nombre", al.getNombre());
            response.cookie("apellido", al.getApellido());
            response.cookie("legajo", String.valueOf(al.getLegajo()));
            response.cookie("githubUser", al.getGithub_user());
            response.cookie("password", al.getPassword());   
            response.cookie("token", token);
    		response.redirect("/home");
        }else {
        	response.redirect("/loginFailed");
        }
  
		return null;
		
	}
	
	public ModelAndView homeAlumno() {
		HashMap<String, Object> viewModel = new HashMap<>();
		Alumno al = AlumnoService.obtenerAlumnoPorToken(request.cookie("token"));
		
		viewModel.put("nombre", request.cookie("nombre"));
		viewModel.put("apellido", request.cookie("apellido"));
		viewModel.put("legajo", request.cookie("legajo"));
		viewModel.put("githubUser", request.cookie("githubUser"));
		viewModel.put("password", request.cookie("password"));
		viewModel.put("asignaciones", al.getAssignments());
		return new ModelAndView(viewModel, "homeAlumno.hbs");
	}
	
	public ModelAndView getStudent() {
		return new ModelAndView(null, "editStudent.hbs");
	}
	
	public String putStudent() {
		String token = request.headers("Authorization");
		String username = request.queryParams("nombreUsuario");
        String pass = request.queryParams("contrasenia");
        Alumno al = AlumnoService.obtenerAlumno(username, pass);
        
        if(token == al.getToken()) {
        	//actualizar valores del alumno
        	response.cookie("nombre", al.getNombre());
            response.cookie("apellido", al.getApellido());
            response.cookie("legajo", String.valueOf(al.getLegajo()));
            response.cookie("githubUser", al.getGithub_user());
            response.cookie("password", al.getPassword());   
            response.cookie("token", token);
    		response.redirect("/home");	
        }
        else {
        	response.status(401);      	
        }
        return null;
	}
	
	public String getAssignments() {
		String token = request.headers("Authorization");
		String username = request.queryParams("nombreUsuario");
        String pass = request.queryParams("contrasenia");
        Alumno al = AlumnoService.obtenerAlumno(username, pass);
        
        if(token == al.getToken()) {
        	Gson gson = new Gson();
        	String jsonInString = gson.toJson(al);
        	return jsonInString;
        }	
        else {
        	response.status(401);
        	return null;
        }
	}
}
