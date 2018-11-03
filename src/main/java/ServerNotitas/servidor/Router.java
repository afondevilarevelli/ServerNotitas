package ServerNotitas.servidor;

import spark.Spark;

public class Router {

	public static void configure() {
		Spark.get("/", Controller::index);
	}
}
