package via.pro3.mainserver;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import via.pro3.mainserver.service.ServerImpl;

public class MainServer {
    public static void main(String[] args) throws Exception
    {
        DatabaseSingleton databaseSingleton = DatabaseSingleton.getInstance();

        EventRepository eventRepository = new EventRepository(databaseSingleton);

        Server server = ServerBuilder.forPort(9090).addService(new ServerImpl()).build().start();
        System.out.println("Server started, listening on " + server.getPort());
        server.awaitTermination();
    }
}
