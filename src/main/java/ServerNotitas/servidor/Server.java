package ServerNotitas.servidor;

import spark.Spark;

/**
 * Hello world!
 *
 */
public class Server 
{
    public static void main( String[] args )
    {
        Spark.port(9000);
        Router.configure();
        Spark.init();
    }
}
