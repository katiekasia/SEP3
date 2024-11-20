package via.pro3.mainserver.service;

import example.grpc.loginResponse;
import example.grpc.loginRequest;
import example.grpc.ProtoGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import via.pro3.mainserver.database.DatabaseInterface;
import via.pro3.mainserver.database.DatabaseSingleton;
import via.pro3.mainserver.database.EventInterface;
import via.pro3.mainserver.database.EventRepository;

@GrpcService
public class ServerImpl extends ProtoGrpc.ProtoImplBase {
    private final EventInterface eventRepository;

    public ServerImpl() {
        DatabaseInterface database = DatabaseSingleton.getInstance();
        this.eventRepository = new EventRepository(database);
    }
}
