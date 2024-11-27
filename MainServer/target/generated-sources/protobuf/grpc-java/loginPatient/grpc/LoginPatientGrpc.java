package loginPatient.grpc;

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
    comments = "Source: loginPatient.proto")
public final class LoginPatientGrpc {

  private LoginPatientGrpc() {}

  public static final String SERVICE_NAME = "LoginPatient";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<loginPatient.grpc.LoginRequest,
      loginPatient.grpc.LoginResponse> METHOD_LOGIN_PATIENT =
      io.grpc.MethodDescriptor.<loginPatient.grpc.LoginRequest, loginPatient.grpc.LoginResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "LoginPatient", "loginPatient"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              loginPatient.grpc.LoginRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              loginPatient.grpc.LoginResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LoginPatientStub newStub(io.grpc.Channel channel) {
    return new LoginPatientStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LoginPatientBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LoginPatientBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LoginPatientFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LoginPatientFutureStub(channel);
  }

  /**
   */
  public static abstract class LoginPatientImplBase implements io.grpc.BindableService {

    /**
     */
    public void loginPatient(loginPatient.grpc.LoginRequest request,
        io.grpc.stub.StreamObserver<loginPatient.grpc.LoginResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LOGIN_PATIENT, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_LOGIN_PATIENT,
            asyncUnaryCall(
              new MethodHandlers<
                loginPatient.grpc.LoginRequest,
                loginPatient.grpc.LoginResponse>(
                  this, METHODID_LOGIN_PATIENT)))
          .build();
    }
  }

  /**
   */
  public static final class LoginPatientStub extends io.grpc.stub.AbstractStub<LoginPatientStub> {
    private LoginPatientStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LoginPatientStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LoginPatientStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LoginPatientStub(channel, callOptions);
    }

    /**
     */
    public void loginPatient(loginPatient.grpc.LoginRequest request,
        io.grpc.stub.StreamObserver<loginPatient.grpc.LoginResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LOGIN_PATIENT, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class LoginPatientBlockingStub extends io.grpc.stub.AbstractStub<LoginPatientBlockingStub> {
    private LoginPatientBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LoginPatientBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LoginPatientBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LoginPatientBlockingStub(channel, callOptions);
    }

    /**
     */
    public loginPatient.grpc.LoginResponse loginPatient(loginPatient.grpc.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LOGIN_PATIENT, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class LoginPatientFutureStub extends io.grpc.stub.AbstractStub<LoginPatientFutureStub> {
    private LoginPatientFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LoginPatientFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LoginPatientFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LoginPatientFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<loginPatient.grpc.LoginResponse> loginPatient(
        loginPatient.grpc.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LOGIN_PATIENT, getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN_PATIENT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LoginPatientImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LoginPatientImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN_PATIENT:
          serviceImpl.loginPatient((loginPatient.grpc.LoginRequest) request,
              (io.grpc.stub.StreamObserver<loginPatient.grpc.LoginResponse>) responseObserver);
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

  private static final class LoginPatientDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return loginPatient.grpc.LoginPatientOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (LoginPatientGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LoginPatientDescriptorSupplier())
              .addMethod(METHOD_LOGIN_PATIENT)
              .build();
        }
      }
    }
    return result;
  }
}
