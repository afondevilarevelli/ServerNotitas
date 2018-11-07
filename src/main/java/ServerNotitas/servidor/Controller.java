package ServerNotitas.servidor;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.google.gson.Gson;
import model.Alumno;
import servicios.AlumnoService;
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
	/*
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
    		response.redirect("/student");
        }else {
        	response.status(401);
        	response.redirect("/loginFailed");
        }
  
		return null;
		
	} */
	
	public String getStudent() {
		String token = request.headers("Authorization");
		Alumno al = AlumnoService.obtenerAlumnoPorToken(token);

		if(al != null && token == al.getToken()) {
			Gson gson = new Gson();
			String jsonInString = gson.toJson(al);
			response.status(200);
			return jsonInString;
		}
		else {
			response.status(401);
			return null;
		}
	}
	
	/*public ModelAndView getEditable() {
		return new ModelAndView(null, "editStudent.hbs");
	}*/
	
	public String putStudent() throws ParseException {
		String token = request.headers("Authorization");
        Alumno al = AlumnoService.obtenerAlumnoPorToken(token);
        
        if(al != null && token == al.getToken()) {
        	try {
        		JSONParser jsonParser = new JSONParser();
        		JSONObject jsonObject = (JSONObject) jsonParser.parse(request.body());
        		
        		String nombre = (String) jsonObject.get("first_name");
        		String apellido = (String) jsonObject.get("last_name");
        		String githubUser = (String) jsonObject.get("github_user");
        		String legajo = (String) jsonObject.get("code");
        		
        		if(nombre != null) {
        			al.setNombre(nombre);
        		}
        		if(apellido != null) {
        			al.setApellido(apellido);
        		}
        		if(githubUser != null) {
        			al.setGithub_user(githubUser);
        		}
        		if(legajo != null) {
        			int legajoInt = Double.valueOf(legajo).intValue();
        			al.setLegajo(legajoInt);
        		}
            	
        		AlumnoService.persistirAlumno(al);
            	response.status(201);
        	}catch(ParseException  e) {
        		response.status(400);
        	}
  
        }
        else {
        	response.status(401);      	
        }
        return null;
	}
	
	public String getAssignments() {
		String token = request.headers("Authorization");
        Alumno al = AlumnoService.obtenerAlumnoPorToken(token);
        
        if(al != null && token == al.getToken()) {
        	Gson gson = new Gson(); 
    		String jsonAsignaciones = gson.toJson(al.getAssignments());
    		response.status(200);
    		return jsonAsignaciones;
        }
        else {
        	response.status(401);
        	return null;
        }    
	}
}
