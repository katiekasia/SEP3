package doctor.grpc;

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
    comments = "Source: doctor.proto")
public final class DoctorGrpc {

  private DoctorGrpc() {}

  public static final String SERVICE_NAME = "Doctor";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<doctor.grpc.LoginDoctorRequest,
      doctor.grpc.LoginDoctorResponse> METHOD_LOGIN_DOCTOR =
      io.grpc.MethodDescriptor.<doctor.grpc.LoginDoctorRequest, doctor.grpc.LoginDoctorResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "Doctor", "loginDoctor"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              doctor.grpc.LoginDoctorRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              doctor.grpc.LoginDoctorResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<doctor.grpc.ChangePasswordRequest,
      doctor.grpc.LoginDoctorResponse> METHOD_CHANGE_PASSWORD =
      io.grpc.MethodDescriptor.<doctor.grpc.ChangePasswordRequest, doctor.grpc.LoginDoctorResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "Doctor", "changePassword"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              doctor.grpc.ChangePasswordRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              doctor.grpc.LoginDoctorResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<doctor.grpc.GetDoctorByIdRequest,
      doctor.grpc.GetDoctorByIdResponse> METHOD_GET_DOCTOR_BY_ID =
      io.grpc.MethodDescriptor.<doctor.grpc.GetDoctorByIdRequest, doctor.grpc.GetDoctorByIdResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "Doctor", "getDoctorById"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              doctor.grpc.GetDoctorByIdRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              doctor.grpc.GetDoctorByIdResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<doctor.grpc.GetPatientsRequest,
      doctor.grpc.GetPatientsResponse> METHOD_GET_PATIENTS_BY_DOCTOR_ID =
      io.grpc.MethodDescriptor.<doctor.grpc.GetPatientsRequest, doctor.grpc.GetPatientsResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "Doctor", "getPatientsByDoctorId"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              doctor.grpc.GetPatientsRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              doctor.grpc.GetPatientsResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<doctor.grpc.AddPrescriptionRequest,
      doctor.grpc.Response> METHOD_ADD_PRESCRIPTION =
      io.grpc.MethodDescriptor.<doctor.grpc.AddPrescriptionRequest, doctor.grpc.Response>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "Doctor", "addPrescription"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              doctor.grpc.AddPrescriptionRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              doctor.grpc.Response.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DoctorStub newStub(io.grpc.Channel channel) {
    return new DoctorStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DoctorBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DoctorBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DoctorFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DoctorFutureStub(channel);
  }

  /**
   */
  public static abstract class DoctorImplBase implements io.grpc.BindableService {

    /**
     */
    public void loginDoctor(doctor.grpc.LoginDoctorRequest request,
        io.grpc.stub.StreamObserver<doctor.grpc.LoginDoctorResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LOGIN_DOCTOR, responseObserver);
    }

    /**
     */
    public void changePassword(doctor.grpc.ChangePasswordRequest request,
        io.grpc.stub.StreamObserver<doctor.grpc.LoginDoctorResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CHANGE_PASSWORD, responseObserver);
    }

    /**
     */
    public void getDoctorById(doctor.grpc.GetDoctorByIdRequest request,
        io.grpc.stub.StreamObserver<doctor.grpc.GetDoctorByIdResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_DOCTOR_BY_ID, responseObserver);
    }

    /**
     */
    public void getPatientsByDoctorId(doctor.grpc.GetPatientsRequest request,
        io.grpc.stub.StreamObserver<doctor.grpc.GetPatientsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_PATIENTS_BY_DOCTOR_ID, responseObserver);
    }

    /**
     */
    public void addPrescription(doctor.grpc.AddPrescriptionRequest request,
        io.grpc.stub.StreamObserver<doctor.grpc.Response> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ADD_PRESCRIPTION, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_LOGIN_DOCTOR,
            asyncUnaryCall(
              new MethodHandlers<
                doctor.grpc.LoginDoctorRequest,
                doctor.grpc.LoginDoctorResponse>(
                  this, METHODID_LOGIN_DOCTOR)))
          .addMethod(
            METHOD_CHANGE_PASSWORD,
            asyncUnaryCall(
              new MethodHandlers<
                doctor.grpc.ChangePasswordRequest,
                doctor.grpc.LoginDoctorResponse>(
                  this, METHODID_CHANGE_PASSWORD)))
          .addMethod(
            METHOD_GET_DOCTOR_BY_ID,
            asyncUnaryCall(
              new MethodHandlers<
                doctor.grpc.GetDoctorByIdRequest,
                doctor.grpc.GetDoctorByIdResponse>(
                  this, METHODID_GET_DOCTOR_BY_ID)))
          .addMethod(
            METHOD_GET_PATIENTS_BY_DOCTOR_ID,
            asyncUnaryCall(
              new MethodHandlers<
                doctor.grpc.GetPatientsRequest,
                doctor.grpc.GetPatientsResponse>(
                  this, METHODID_GET_PATIENTS_BY_DOCTOR_ID)))
          .addMethod(
            METHOD_ADD_PRESCRIPTION,
            asyncUnaryCall(
              new MethodHandlers<
                doctor.grpc.AddPrescriptionRequest,
                doctor.grpc.Response>(
                  this, METHODID_ADD_PRESCRIPTION)))
          .build();
    }
  }

  /**
   */
  public static final class DoctorStub extends io.grpc.stub.AbstractStub<DoctorStub> {
    private DoctorStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DoctorStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DoctorStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DoctorStub(channel, callOptions);
    }

    /**
     */
    public void loginDoctor(doctor.grpc.LoginDoctorRequest request,
        io.grpc.stub.StreamObserver<doctor.grpc.LoginDoctorResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LOGIN_DOCTOR, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void changePassword(doctor.grpc.ChangePasswordRequest request,
        io.grpc.stub.StreamObserver<doctor.grpc.LoginDoctorResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CHANGE_PASSWORD, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getDoctorById(doctor.grpc.GetDoctorByIdRequest request,
        io.grpc.stub.StreamObserver<doctor.grpc.GetDoctorByIdResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_DOCTOR_BY_ID, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getPatientsByDoctorId(doctor.grpc.GetPatientsRequest request,
        io.grpc.stub.StreamObserver<doctor.grpc.GetPatientsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_PATIENTS_BY_DOCTOR_ID, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addPrescription(doctor.grpc.AddPrescriptionRequest request,
        io.grpc.stub.StreamObserver<doctor.grpc.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ADD_PRESCRIPTION, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DoctorBlockingStub extends io.grpc.stub.AbstractStub<DoctorBlockingStub> {
    private DoctorBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DoctorBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DoctorBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DoctorBlockingStub(channel, callOptions);
    }

    /**
     */
    public doctor.grpc.LoginDoctorResponse loginDoctor(doctor.grpc.LoginDoctorRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LOGIN_DOCTOR, getCallOptions(), request);
    }

    /**
     */
    public doctor.grpc.LoginDoctorResponse changePassword(doctor.grpc.ChangePasswordRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CHANGE_PASSWORD, getCallOptions(), request);
    }

    /**
     */
    public doctor.grpc.GetDoctorByIdResponse getDoctorById(doctor.grpc.GetDoctorByIdRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_DOCTOR_BY_ID, getCallOptions(), request);
    }

    /**
     */
    public doctor.grpc.GetPatientsResponse getPatientsByDoctorId(doctor.grpc.GetPatientsRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_PATIENTS_BY_DOCTOR_ID, getCallOptions(), request);
    }

    /**
     */
    public doctor.grpc.Response addPrescription(doctor.grpc.AddPrescriptionRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ADD_PRESCRIPTION, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DoctorFutureStub extends io.grpc.stub.AbstractStub<DoctorFutureStub> {
    private DoctorFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DoctorFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DoctorFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DoctorFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<doctor.grpc.LoginDoctorResponse> loginDoctor(
        doctor.grpc.LoginDoctorRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LOGIN_DOCTOR, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<doctor.grpc.LoginDoctorResponse> changePassword(
        doctor.grpc.ChangePasswordRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CHANGE_PASSWORD, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<doctor.grpc.GetDoctorByIdResponse> getDoctorById(
        doctor.grpc.GetDoctorByIdRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_DOCTOR_BY_ID, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<doctor.grpc.GetPatientsResponse> getPatientsByDoctorId(
        doctor.grpc.GetPatientsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_PATIENTS_BY_DOCTOR_ID, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<doctor.grpc.Response> addPrescription(
        doctor.grpc.AddPrescriptionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ADD_PRESCRIPTION, getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN_DOCTOR = 0;
  private static final int METHODID_CHANGE_PASSWORD = 1;
  private static final int METHODID_GET_DOCTOR_BY_ID = 2;
  private static final int METHODID_GET_PATIENTS_BY_DOCTOR_ID = 3;
  private static final int METHODID_ADD_PRESCRIPTION = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DoctorImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DoctorImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN_DOCTOR:
          serviceImpl.loginDoctor((doctor.grpc.LoginDoctorRequest) request,
              (io.grpc.stub.StreamObserver<doctor.grpc.LoginDoctorResponse>) responseObserver);
          break;
        case METHODID_CHANGE_PASSWORD:
          serviceImpl.changePassword((doctor.grpc.ChangePasswordRequest) request,
              (io.grpc.stub.StreamObserver<doctor.grpc.LoginDoctorResponse>) responseObserver);
          break;
        case METHODID_GET_DOCTOR_BY_ID:
          serviceImpl.getDoctorById((doctor.grpc.GetDoctorByIdRequest) request,
              (io.grpc.stub.StreamObserver<doctor.grpc.GetDoctorByIdResponse>) responseObserver);
          break;
        case METHODID_GET_PATIENTS_BY_DOCTOR_ID:
          serviceImpl.getPatientsByDoctorId((doctor.grpc.GetPatientsRequest) request,
              (io.grpc.stub.StreamObserver<doctor.grpc.GetPatientsResponse>) responseObserver);
          break;
        case METHODID_ADD_PRESCRIPTION:
          serviceImpl.addPrescription((doctor.grpc.AddPrescriptionRequest) request,
              (io.grpc.stub.StreamObserver<doctor.grpc.Response>) responseObserver);
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

  private static final class DoctorDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return doctor.grpc.DoctorOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (DoctorGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DoctorDescriptorSupplier())
              .addMethod(METHOD_LOGIN_DOCTOR)
              .addMethod(METHOD_CHANGE_PASSWORD)
              .addMethod(METHOD_GET_DOCTOR_BY_ID)
              .addMethod(METHOD_GET_PATIENTS_BY_DOCTOR_ID)
              .addMethod(METHOD_ADD_PRESCRIPTION)
              .build();
        }
      }
    }
    return result;
  }
}
