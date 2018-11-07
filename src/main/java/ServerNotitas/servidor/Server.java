package ServerNotitas.servidor;

import spark.Spark;

public class Server 
{
    public static void main( String[] args )
    {
        Spark.port(8080);
        //Router.load();
        Router.configure();
        Spark.init();
    }
}
