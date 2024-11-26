package example.grpc;

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
    comments = "Source: proto.proto")
public final class ProtoGrpc {

  private ProtoGrpc() {}

  public static final String SERVICE_NAME = "Proto";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<example.grpc.test1,
      example.grpc.test2> METHOD_LOGIN_DOCTOR =
      io.grpc.MethodDescriptor.<example.grpc.test1, example.grpc.test2>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "Proto", "loginDoctor"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              example.grpc.test1.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              example.grpc.test2.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProtoStub newStub(io.grpc.Channel channel) {
    return new ProtoStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProtoBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ProtoBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProtoFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ProtoFutureStub(channel);
  }

  /**
   */
  public static abstract class ProtoImplBase implements io.grpc.BindableService {

    /**
     */
    public void loginDoctor(example.grpc.test1 request,
        io.grpc.stub.StreamObserver<example.grpc.test2> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LOGIN_DOCTOR, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_LOGIN_DOCTOR,
            asyncUnaryCall(
              new MethodHandlers<
                example.grpc.test1,
                example.grpc.test2>(
                  this, METHODID_LOGIN_DOCTOR)))
          .build();
    }
  }

  /**
   */
  public static final class ProtoStub extends io.grpc.stub.AbstractStub<ProtoStub> {
    private ProtoStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProtoStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProtoStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProtoStub(channel, callOptions);
    }

    /**
     */
    public void loginDoctor(example.grpc.test1 request,
        io.grpc.stub.StreamObserver<example.grpc.test2> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LOGIN_DOCTOR, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ProtoBlockingStub extends io.grpc.stub.AbstractStub<ProtoBlockingStub> {
    private ProtoBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProtoBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProtoBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProtoBlockingStub(channel, callOptions);
    }

    /**
     */
    public example.grpc.test2 loginDoctor(example.grpc.test1 request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LOGIN_DOCTOR, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ProtoFutureStub extends io.grpc.stub.AbstractStub<ProtoFutureStub> {
    private ProtoFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProtoFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProtoFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProtoFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<example.grpc.test2> loginDoctor(
        example.grpc.test1 request) {
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
    private final ProtoImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProtoImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN_DOCTOR:
          serviceImpl.loginDoctor((example.grpc.test1) request,
              (io.grpc.stub.StreamObserver<example.grpc.test2>) responseObserver);
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

  private static final class ProtoDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return example.grpc.ProtoOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ProtoGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProtoDescriptorSupplier())
              .addMethod(METHOD_LOGIN_DOCTOR)
              .build();
        }
      }
    }
    return result;
  }
}
