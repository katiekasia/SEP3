package registerPatient.grpc;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: registerPatient.proto")
public final class RegisterPatientGrpc {

  private RegisterPatientGrpc() {}

  public static final String SERVICE_NAME = "RegisterPatient";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<registerPatient.grpc.RegisterRequest,
      registerPatient.grpc.Response> METHOD_REGISTER_PATIENT =
      io.grpc.MethodDescriptor.<registerPatient.grpc.RegisterRequest, registerPatient.grpc.Response>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RegisterPatient", "registerPatient"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              registerPatient.grpc.RegisterRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              registerPatient.grpc.Response.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RegisterPatientStub newStub(io.grpc.Channel channel) {
    return new RegisterPatientStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RegisterPatientBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RegisterPatientBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RegisterPatientFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RegisterPatientFutureStub(channel);
  }

  /**
   */
  public static abstract class RegisterPatientImplBase implements io.grpc.BindableService {

    /**
     */
    public void registerPatient(registerPatient.grpc.RegisterRequest request,
        io.grpc.stub.StreamObserver<registerPatient.grpc.Response> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_REGISTER_PATIENT, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_REGISTER_PATIENT,
            asyncUnaryCall(
              new MethodHandlers<
                registerPatient.grpc.RegisterRequest,
                registerPatient.grpc.Response>(
                  this, METHODID_REGISTER_PATIENT)))
          .build();
    }
  }

  /**
   */
  public static final class RegisterPatientStub extends io.grpc.stub.AbstractStub<RegisterPatientStub> {
    private RegisterPatientStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RegisterPatientStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegisterPatientStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RegisterPatientStub(channel, callOptions);
    }

    /**
     */
    public void registerPatient(registerPatient.grpc.RegisterRequest request,
        io.grpc.stub.StreamObserver<registerPatient.grpc.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_REGISTER_PATIENT, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RegisterPatientBlockingStub extends io.grpc.stub.AbstractStub<RegisterPatientBlockingStub> {
    private RegisterPatientBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RegisterPatientBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegisterPatientBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RegisterPatientBlockingStub(channel, callOptions);
    }

    /**
     */
    public registerPatient.grpc.Response registerPatient(registerPatient.grpc.RegisterRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_REGISTER_PATIENT, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RegisterPatientFutureStub extends io.grpc.stub.AbstractStub<RegisterPatientFutureStub> {
    private RegisterPatientFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RegisterPatientFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegisterPatientFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RegisterPatientFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<registerPatient.grpc.Response> registerPatient(
        registerPatient.grpc.RegisterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_REGISTER_PATIENT, getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER_PATIENT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RegisterPatientImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RegisterPatientImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER_PATIENT:
          serviceImpl.registerPatient((registerPatient.grpc.RegisterRequest) request,
              (io.grpc.stub.StreamObserver<registerPatient.grpc.Response>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class RegisterPatientDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return registerPatient.grpc.RegisterPatientOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RegisterPatientGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RegisterPatientDescriptorSupplier())
              .addMethod(METHOD_REGISTER_PATIENT)
              .build();
        }
      }
    }
    return result;
  }
}
