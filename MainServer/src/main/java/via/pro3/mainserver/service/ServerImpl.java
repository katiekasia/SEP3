package via.pro3.mainserver.service;

import example.grpc.loginResponse;
import example.grpc.loginRequest;
import example.grpc.ProtoGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import via.pro3.mainserver.DatabaseSingleton;
import via.pro3.mainserver.EventRepository;

@GrpcService
public class ServerImpl extends ProtoGrpc.ProtoImplBase {
    private final EventRepository eventRepository;

    public ServerImpl() {
        DatabaseSingleton database = DatabaseSingleton.getInstance();
        this.eventRepository = new EventRepository(database);
    }

    @Override
    public void loginDoctor(loginRequest request, StreamObserver<loginResponse> responseObserver) {
        String name = request.getEmail().toString();

        eventRepository.createUser(name);

        String greeting = "Hello " + name + "!";
        loginResponse reply = loginResponse.newBuilder().setEmail(greeting).build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
