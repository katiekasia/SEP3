package via.pro3.mainserver.service;

import example.grpc.GreeterGrpc;
import example.grpc.HelloReply;
import example.grpc.HelloRequest;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import via.pro3.mainserver.DatabaseSingleton;
import via.pro3.mainserver.EventRepository;

@GrpcService
public class GreeterImpl extends GreeterGrpc.GreeterImplBase {
  private final EventRepository eventRepository;

  public GreeterImpl() {
    DatabaseSingleton singleton = DatabaseSingleton.getInstance();
    this.eventRepository = new EventRepository(singleton);
  }

  @Override
  public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
    String name = request.getName().toString();

    eventRepository.createUser(name); // Your logic here

    String greeting = "Hello " + name + "!";
    HelloReply reply = HelloReply.newBuilder().setMessage(greeting).build();

    responseObserver.onNext(reply);
    responseObserver.onCompleted();
  }
}
