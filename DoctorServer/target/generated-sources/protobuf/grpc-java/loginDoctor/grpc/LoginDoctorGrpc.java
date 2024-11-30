package loginDoctor.grpc;

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
    comments = "Source: loginDoctor.proto")
public final class LoginDoctorGrpc {

  private LoginDoctorGrpc() {}

  public static final String SERVICE_NAME = "LoginDoctor";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<loginDoctor.grpc.LoginDoctorRequest,
      loginDoctor.grpc.LoginDoctorResponse> METHOD_LOGIN_DOCTOR =
      io.grpc.MethodDescriptor.<loginDoctor.grpc.LoginDoctorRequest, loginDoctor.grpc.LoginDoctorResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "LoginDoctor", "loginDoctor"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              loginDoctor.grpc.LoginDoctorRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              loginDoctor.grpc.LoginDoctorResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LoginDoctorStub newStub(io.grpc.Channel channel) {
    return new LoginDoctorStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LoginDoctorBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LoginDoctorBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LoginDoctorFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LoginDoctorFutureStub(channel);
  }

  /**
   */
  public static abstract class LoginDoctorImplBase implements io.grpc.BindableService {

    /**
     */
    public void loginDoctor(loginDoctor.grpc.LoginDoctorRequest request,
        io.grpc.stub.StreamObserver<loginDoctor.grpc.LoginDoctorResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LOGIN_DOCTOR, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_LOGIN_DOCTOR,
            asyncUnaryCall(
              new MethodHandlers<
                loginDoctor.grpc.LoginDoctorRequest,
                loginDoctor.grpc.LoginDoctorResponse>(
                  this, METHODID_LOGIN_DOCTOR)))
          .build();
    }
  }

  /**
   */
  public static final class LoginDoctorStub extends io.grpc.stub.AbstractStub<LoginDoctorStub> {
    private LoginDoctorStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LoginDoctorStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LoginDoctorStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LoginDoctorStub(channel, callOptions);
    }

    /**
     */
    public void loginDoctor(loginDoctor.grpc.LoginDoctorRequest request,
        io.grpc.stub.StreamObserver<loginDoctor.grpc.LoginDoctorResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LOGIN_DOCTOR, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class LoginDoctorBlockingStub extends io.grpc.stub.AbstractStub<LoginDoctorBlockingStub> {
    private LoginDoctorBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LoginDoctorBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LoginDoctorBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LoginDoctorBlockingStub(channel, callOptions);
    }

    /**
     */
    public loginDoctor.grpc.LoginDoctorResponse loginDoctor(loginDoctor.grpc.LoginDoctorRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LOGIN_DOCTOR, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class LoginDoctorFutureStub extends io.grpc.stub.AbstractStub<LoginDoctorFutureStub> {
    private LoginDoctorFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LoginDoctorFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LoginDoctorFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LoginDoctorFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<loginDoctor.grpc.LoginDoctorResponse> loginDoctor(
        loginDoctor.grpc.LoginDoctorRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LOGIN_DOCTOR, getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN_DOCTOR = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LoginDoctorImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LoginDoctorImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN_DOCTOR:
          serviceImpl.loginDoctor((loginDoctor.grpc.LoginDoctorRequest) request,
              (io.grpc.stub.StreamObserver<loginDoctor.grpc.LoginDoctorResponse>) responseObserver);
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

  private static final class LoginDoctorDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return loginDoctor.grpc.LoginDoctorOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (LoginDoctorGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LoginDoctorDescriptorSupplier())
              .addMethod(METHOD_LOGIN_DOCTOR)
              .build();
        }
      }
    }
    return result;
  }
}
