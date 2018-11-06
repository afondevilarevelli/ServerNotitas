package ServerNotitas.servidor;

import setup.BooleanHelper;
import setup.HandlebarsTemplateEngineBuilder;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import ServerNotitas.servidor.Controller;

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
	}
}
