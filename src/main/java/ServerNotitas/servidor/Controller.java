package ServerNotitas.servidor;

import spark.Request;
import spark.Response;

public class Controller {
	
	public static String index(Request req, Response res) {
		return "<html> <body> Hola" + "TINCHETE" + " </body></html>";
	}
}
