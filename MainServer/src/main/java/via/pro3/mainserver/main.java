package via.pro3.mainserver;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import via.pro3.mainserver.service.GreeterImpl;

public class main {
    public static void main(String[] args) throws Exception
    {
        DatabaseSingleton databaseSingleton = DatabaseSingleton.getInstance();

        EventRepository eventRepository = new EventRepository(databaseSingleton);

        Server server = ServerBuilder.forPort(8081).addService(new GreeterImpl()).build().start();
        System.out.println("Server started, listening on " + server.getPort());
        server.awaitTermination();

        //eventRepository.createUser("Danny");
    }
}
