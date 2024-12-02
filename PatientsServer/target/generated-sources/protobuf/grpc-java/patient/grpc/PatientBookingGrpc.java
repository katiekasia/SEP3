package patient.grpc;

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
    comments = "Source: patient.proto")
public final class PatientBookingGrpc {

  private PatientBookingGrpc() {}

  public static final String SERVICE_NAME = "PatientBooking";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<patient.grpc.CreateAppointment,
      patient.grpc.DBresponse> METHOD_CREATE_APPOINTMENT =
      io.grpc.MethodDescriptor.<patient.grpc.CreateAppointment, patient.grpc.DBresponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "PatientBooking", "createAppointment"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              patient.grpc.CreateAppointment.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              patient.grpc.DBresponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<patient.grpc.LoginRequest,
      patient.grpc.LoginResponse> METHOD_LOGIN_PATIENT =
      io.grpc.MethodDescriptor.<patient.grpc.LoginRequest, patient.grpc.LoginResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "PatientBooking", "loginPatient"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              patient.grpc.LoginRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              patient.grpc.LoginResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<patient.grpc.RegisterRequest,
      patient.grpc.DBresponse> METHOD_REGISTER_PATIENT =
      io.grpc.MethodDescriptor.<patient.grpc.RegisterRequest, patient.grpc.DBresponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "PatientBooking", "registerPatient"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              patient.grpc.RegisterRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              patient.grpc.DBresponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PatientBookingStub newStub(io.grpc.Channel channel) {
    return new PatientBookingStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PatientBookingBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PatientBookingBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PatientBookingFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PatientBookingFutureStub(channel);
  }

  /**
   */
  public static abstract class PatientBookingImplBase implements io.grpc.BindableService {

    /**
     */
    public void createAppointment(patient.grpc.CreateAppointment request,
        io.grpc.stub.StreamObserver<patient.grpc.DBresponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CREATE_APPOINTMENT, responseObserver);
    }

    /**
     */
    public void loginPatient(patient.grpc.LoginRequest request,
        io.grpc.stub.StreamObserver<patient.grpc.LoginResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LOGIN_PATIENT, responseObserver);
    }

    /**
     */
    public void registerPatient(patient.grpc.RegisterRequest request,
        io.grpc.stub.StreamObserver<patient.grpc.DBresponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_REGISTER_PATIENT, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_CREATE_APPOINTMENT,
            asyncUnaryCall(
              new MethodHandlers<
                patient.grpc.CreateAppointment,
                patient.grpc.DBresponse>(
                  this, METHODID_CREATE_APPOINTMENT)))
          .addMethod(
            METHOD_LOGIN_PATIENT,
            asyncUnaryCall(
              new MethodHandlers<
                patient.grpc.LoginRequest,
                patient.grpc.LoginResponse>(
                  this, METHODID_LOGIN_PATIENT)))
          .addMethod(
            METHOD_REGISTER_PATIENT,
            asyncUnaryCall(
              new MethodHandlers<
                patient.grpc.RegisterRequest,
                patient.grpc.DBresponse>(
                  this, METHODID_REGISTER_PATIENT)))
          .build();
    }
  }

  /**
   */
  public static final class PatientBookingStub extends io.grpc.stub.AbstractStub<PatientBookingStub> {
    private PatientBookingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PatientBookingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PatientBookingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PatientBookingStub(channel, callOptions);
    }

    /**
     */
    public void createAppointment(patient.grpc.CreateAppointment request,
        io.grpc.stub.StreamObserver<patient.grpc.DBresponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE_APPOINTMENT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void loginPatient(patient.grpc.LoginRequest request,
        io.grpc.stub.StreamObserver<patient.grpc.LoginResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LOGIN_PATIENT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void registerPatient(patient.grpc.RegisterRequest request,
        io.grpc.stub.StreamObserver<patient.grpc.DBresponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_REGISTER_PATIENT, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PatientBookingBlockingStub extends io.grpc.stub.AbstractStub<PatientBookingBlockingStub> {
    private PatientBookingBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PatientBookingBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PatientBookingBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PatientBookingBlockingStub(channel, callOptions);
    }

    /**
     */
    public patient.grpc.DBresponse createAppointment(patient.grpc.CreateAppointment request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CREATE_APPOINTMENT, getCallOptions(), request);
    }

    /**
     */
    public patient.grpc.LoginResponse loginPatient(patient.grpc.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LOGIN_PATIENT, getCallOptions(), request);
    }

    /**
     */
    public patient.grpc.DBresponse registerPatient(patient.grpc.RegisterRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_REGISTER_PATIENT, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PatientBookingFutureStub extends io.grpc.stub.AbstractStub<PatientBookingFutureStub> {
    private PatientBookingFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PatientBookingFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PatientBookingFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PatientBookingFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<patient.grpc.DBresponse> createAppointment(
        patient.grpc.CreateAppointment request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE_APPOINTMENT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<patient.grpc.LoginResponse> loginPatient(
        patient.grpc.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LOGIN_PATIENT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<patient.grpc.DBresponse> registerPatient(
        patient.grpc.RegisterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_REGISTER_PATIENT, getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_APPOINTMENT = 0;
  private static final int METHODID_LOGIN_PATIENT = 1;
  private static final int METHODID_REGISTER_PATIENT = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PatientBookingImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PatientBookingImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_APPOINTMENT:
          serviceImpl.createAppointment((patient.grpc.CreateAppointment) request,
              (io.grpc.stub.StreamObserver<patient.grpc.DBresponse>) responseObserver);
          break;
        case METHODID_LOGIN_PATIENT:
          serviceImpl.loginPatient((patient.grpc.LoginRequest) request,
              (io.grpc.stub.StreamObserver<patient.grpc.LoginResponse>) responseObserver);
          break;
        case METHODID_REGISTER_PATIENT:
          serviceImpl.registerPatient((patient.grpc.RegisterRequest) request,
              (io.grpc.stub.StreamObserver<patient.grpc.DBresponse>) responseObserver);
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

  private static final class PatientBookingDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return patient.grpc.Patient.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PatientBookingGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PatientBookingDescriptorSupplier())
              .addMethod(METHOD_CREATE_APPOINTMENT)
              .addMethod(METHOD_LOGIN_PATIENT)
              .addMethod(METHOD_REGISTER_PATIENT)
              .build();
        }
      }
    }
    return result;
  }
}
