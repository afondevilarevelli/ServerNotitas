package ServerNotitas.servidor;

import setup.BooleanHelper;
import setup.HandlebarsTemplateEngineBuilder;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.List;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import ServerNotitas.servidor.Controller;
import model.Alumno;
import model.Asignacion;
import model.Conceptual;
import model.EnumConceptual;
import model.Nota;
import model.Numerica;
import servicios.AlumnoService;
import servicios.Security;

public class Router {
	
	public static void load() {
		List<Nota> notas = new ArrayList<Nota>();
		Numerica n1 = new Numerica(Double.valueOf(7));
		Conceptual n2 = new Conceptual(EnumConceptual.BIEN);
		notas.add(n1);
		notas.add(n2);
		
		Asignacion asig1 = new Asignacion( notas,"TP algoritmos","hacer algo re piola");
		Alumno al = new Alumno("Antonio", "Fondevila", "contra", 1595490, "afondevilarevelli");
		al.addAsignacion(asig1);
		
		Algorithm algorithm = Algorithm.HMAC256("god");
		String token = JWT.create()
		    .withClaim("user", 1)
		    .sign(algorithm);//eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjoxfQ.GDCk-9yZwlADFew9jI551Izq9Dj3SYsCfEL5qcUZYlM
		
		al.setToken("Bearer "+token);
		
		AlumnoService.persistirAlumno(al);
		
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
		Spark.get("/loginFailed", (req, res) -> new Controller(req, res).getLoginFailed(), engine);
		
		Spark.get("/home", (req, res) -> new Controller(req, res).homeAlumno(), engine);
		
		Spark.get("/student", (req, res) -> new Controller(req, res).getStudent(), engine);
		Spark.put("/student", (req, res) -> new Controller(req, res).putStudent(), engine);
		
		Spark.get("/student/assignments", (req, res) -> new Controller(req, res).getAssignments(), engine);
		
		/*
		Security securityService = new Security("god");
		Spark.before((req, res) -> {
			try {
				int userId = securityService.user(req.headers("Authorization").replace("Bearer ", ""));
				//Hacer algo con el id...
			} catch (Exception e) {
				Spark.halt(401, "<h1><a href='https://www.youtube.com/watch?v=0Jx8Eay5fWQ'>Hack me </a></h1><br/><br/><br/><a href='https://www.youtube.com/watch?v=PtLmEARfStE'> El aleph </a>");
			}
		}); */
	} 

}
