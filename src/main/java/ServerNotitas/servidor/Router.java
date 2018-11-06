package ServerNotitas.servidor;

import setup.BooleanHelper;
import setup.HandlebarsTemplateEngineBuilder;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import ServerNotitas.servidor.Controller;
import servicios.Security;

public class Router {
	
	public static void load() {
		//persistir los datos
	}
	
	public static void configure() {
		HandlebarsTemplateEngine engine = HandlebarsTemplateEngineBuilder
	            .create()
	            .withDefaultHelpers()
	            .withHelper("isTrue", BooleanHelper.isTrue)
	            .build(); 
		
		Spark.staticFileLocation("/public");
		
		Spark.get("/", (req, res) -> new Controller(req, res).getLogin(), engine);
		Spark.post("/", (req, res) -> new Controller(req, res).postLogin());
		
		Spark.get("/home", (req, res) -> new Controller(req, res).homeAlumno(), engine);
		
		Spark.get("/student", (req, res) -> new Controller(req, res).getStudent(), engine);
		Spark.put("/student", (req, res) -> new Controller(req, res).putStudent(), engine);
		
		Spark.get("/student/assignments", (req, res) -> new Controller(req, res).getAssignments(), engine);
		
		/*
		Security securityService = new Security("god");
		Spark.before((req, res) -> {
			try {
				Long userId = securityService.user(req.headers("Authorization").replace("Bearer ", ""));
				//Hacer algo con el id...
			} catch (Exception e) {
				Spark.halt(401, "<h1><a href='https://www.youtube.com/watch?v=0Jx8Eay5fWQ'>Hack me </a></h1><br/><br/><br/><a href='https://www.youtube.com/watch?v=PtLmEARfStE'> El aleph </a>");
			}
		}); */
	} 

}
