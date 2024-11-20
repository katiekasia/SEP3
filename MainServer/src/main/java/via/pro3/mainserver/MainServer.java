package via.pro3.mainserver;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import via.pro3.mainserver.Model.Model;
import via.pro3.mainserver.Model.ModelManager;
import via.pro3.mainserver.database.DatabaseInterface;
import via.pro3.mainserver.database.DatabaseSingleton;
import via.pro3.mainserver.database.EventInterface;
import via.pro3.mainserver.database.EventRepository;
import via.pro3.mainserver.service.LoginImpl;
import via.pro3.mainserver.service.PatientImpl;
import via.pro3.mainserver.service.RegisterPatientImpl;
import via.pro3.mainserver.service.ServerImpl;

public class MainServer {
    public static void main(String[] args) throws Exception
    {
        DatabaseInterface databaseInterface = DatabaseSingleton.getInstance();

        EventInterface eventInterface = new EventRepository(databaseInterface);
        Model model = new ModelManager();

        Server server =
                ServerBuilder.forPort(9090).addService(new ServerImpl()).
                        addService(new PatientImpl()).
                        addService(new RegisterPatientImpl()).
                        addService(new LoginImpl(model)).
                        build().start();
        System.out.println("Server started, listening on " + server.getPort());
        server.awaitTermination();
    }
}
