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
public final class PatientGrpc {

  private PatientGrpc() {}

  public static final String SERVICE_NAME = "Patient";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<patient.grpc.CreateAppointment,
      patient.grpc.DBresponse> METHOD_CREATE_APPOINTMENT =
      io.grpc.MethodDescriptor.<patient.grpc.CreateAppointment, patient.grpc.DBresponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "Patient", "createAppointment"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              patient.grpc.CreateAppointment.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              patient.grpc.DBresponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<patient.grpc.PatientRequest,
      patient.grpc.LoginResponse> METHOD_LOGIN_PATIENT =
      io.grpc.MethodDescriptor.<patient.grpc.PatientRequest, patient.grpc.LoginResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "Patient", "loginPatient"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              patient.grpc.PatientRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              patient.grpc.LoginResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<patient.grpc.RegisterRequest,
      patient.grpc.DBresponse> METHOD_REGISTER_PATIENT =
      io.grpc.MethodDescriptor.<patient.grpc.RegisterRequest, patient.grpc.DBresponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "Patient", "registerPatient"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              patient.grpc.RegisterRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              patient.grpc.DBresponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<patient.grpc.GetCities,
      patient.grpc.CityListResponse> METHOD_GET_CITIES =
      io.grpc.MethodDescriptor.<patient.grpc.GetCities, patient.grpc.CityListResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "Patient", "getCities"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              patient.grpc.GetCities.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              patient.grpc.CityListResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<patient.grpc.CityRequest,
      patient.grpc.ClinicListResponse> METHOD_GET_CLINICS =
      io.grpc.MethodDescriptor.<patient.grpc.CityRequest, patient.grpc.ClinicListResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "Patient", "getClinics"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              patient.grpc.CityRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              patient.grpc.ClinicListResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<patient.grpc.Clinic,
      patient.grpc.DoctorListResponse> METHOD_GET_DOCTORS =
      io.grpc.MethodDescriptor.<patient.grpc.Clinic, patient.grpc.DoctorListResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "Patient", "getDoctors"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              patient.grpc.Clinic.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              patient.grpc.DoctorListResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<patient.grpc.UpdateUserRequest,
      patient.grpc.DBresponse> METHOD_UPDATE_USER =
      io.grpc.MethodDescriptor.<patient.grpc.UpdateUserRequest, patient.grpc.DBresponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "Patient", "updateUser"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              patient.grpc.UpdateUserRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              patient.grpc.DBresponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<patient.grpc.PatientRequest,
      patient.grpc.GetAppointmentsResponse> METHOD_GET_APPOINTMENTS_BY_PATIENT_CPR =
      io.grpc.MethodDescriptor.<patient.grpc.PatientRequest, patient.grpc.GetAppointmentsResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "Patient", "getAppointmentsByPatientCpr"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              patient.grpc.PatientRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              patient.grpc.GetAppointmentsResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<patient.grpc.CancelAppointmentRequest,
      patient.grpc.DBresponse> METHOD_CANCEL_APPOINTMENT =
      io.grpc.MethodDescriptor.<patient.grpc.CancelAppointmentRequest, patient.grpc.DBresponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "Patient", "cancelAppointment"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              patient.grpc.CancelAppointmentRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              patient.grpc.DBresponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PatientStub newStub(io.grpc.Channel channel) {
    return new PatientStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PatientBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PatientBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PatientFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PatientFutureStub(channel);
  }

  /**
   */
  public static abstract class PatientImplBase implements io.grpc.BindableService {

    /**
     */
    public void createAppointment(patient.grpc.CreateAppointment request,
        io.grpc.stub.StreamObserver<patient.grpc.DBresponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CREATE_APPOINTMENT, responseObserver);
    }

    /**
     */
    public void loginPatient(patient.grpc.PatientRequest request,
        io.grpc.stub.StreamObserver<patient.grpc.LoginResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LOGIN_PATIENT, responseObserver);
    }

    /**
     */
    public void registerPatient(patient.grpc.RegisterRequest request,
        io.grpc.stub.StreamObserver<patient.grpc.DBresponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_REGISTER_PATIENT, responseObserver);
    }

    /**
     */
    public void getCities(patient.grpc.GetCities request,
        io.grpc.stub.StreamObserver<patient.grpc.CityListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_CITIES, responseObserver);
    }

    /**
     */
    public void getClinics(patient.grpc.CityRequest request,
        io.grpc.stub.StreamObserver<patient.grpc.ClinicListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_CLINICS, responseObserver);
    }

    /**
     */
    public void getDoctors(patient.grpc.Clinic request,
        io.grpc.stub.StreamObserver<patient.grpc.DoctorListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_DOCTORS, responseObserver);
    }

    /**
     */
    public void updateUser(patient.grpc.UpdateUserRequest request,
        io.grpc.stub.StreamObserver<patient.grpc.DBresponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_UPDATE_USER, responseObserver);
    }

    /**
     */
    public void getAppointmentsByPatientCpr(patient.grpc.PatientRequest request,
        io.grpc.stub.StreamObserver<patient.grpc.GetAppointmentsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_APPOINTMENTS_BY_PATIENT_CPR, responseObserver);
    }

    /**
     */
    public void cancelAppointment(patient.grpc.CancelAppointmentRequest request,
        io.grpc.stub.StreamObserver<patient.grpc.DBresponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CANCEL_APPOINTMENT, responseObserver);
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
                patient.grpc.PatientRequest,
                patient.grpc.LoginResponse>(
                  this, METHODID_LOGIN_PATIENT)))
          .addMethod(
            METHOD_REGISTER_PATIENT,
            asyncUnaryCall(
              new MethodHandlers<
                patient.grpc.RegisterRequest,
                patient.grpc.DBresponse>(
                  this, METHODID_REGISTER_PATIENT)))
          .addMethod(
            METHOD_GET_CITIES,
            asyncUnaryCall(
              new MethodHandlers<
                patient.grpc.GetCities,
                patient.grpc.CityListResponse>(
                  this, METHODID_GET_CITIES)))
          .addMethod(
            METHOD_GET_CLINICS,
            asyncUnaryCall(
              new MethodHandlers<
                patient.grpc.CityRequest,
                patient.grpc.ClinicListResponse>(
                  this, METHODID_GET_CLINICS)))
          .addMethod(
            METHOD_GET_DOCTORS,
            asyncUnaryCall(
              new MethodHandlers<
                patient.grpc.Clinic,
                patient.grpc.DoctorListResponse>(
                  this, METHODID_GET_DOCTORS)))
          .addMethod(
            METHOD_UPDATE_USER,
            asyncUnaryCall(
              new MethodHandlers<
                patient.grpc.UpdateUserRequest,
                patient.grpc.DBresponse>(
                  this, METHODID_UPDATE_USER)))
          .addMethod(
            METHOD_GET_APPOINTMENTS_BY_PATIENT_CPR,
            asyncUnaryCall(
              new MethodHandlers<
                patient.grpc.PatientRequest,
                patient.grpc.GetAppointmentsResponse>(
                  this, METHODID_GET_APPOINTMENTS_BY_PATIENT_CPR)))
          .addMethod(
            METHOD_CANCEL_APPOINTMENT,
            asyncUnaryCall(
              new MethodHandlers<
                patient.grpc.CancelAppointmentRequest,
                patient.grpc.DBresponse>(
                  this, METHODID_CANCEL_APPOINTMENT)))
          .build();
    }
  }

  /**
   */
  public static final class PatientStub extends io.grpc.stub.AbstractStub<PatientStub> {
    private PatientStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PatientStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PatientStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PatientStub(channel, callOptions);
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
    public void loginPatient(patient.grpc.PatientRequest request,
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

    /**
     */
    public void getCities(patient.grpc.GetCities request,
        io.grpc.stub.StreamObserver<patient.grpc.CityListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_CITIES, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getClinics(patient.grpc.CityRequest request,
        io.grpc.stub.StreamObserver<patient.grpc.ClinicListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_CLINICS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getDoctors(patient.grpc.Clinic request,
        io.grpc.stub.StreamObserver<patient.grpc.DoctorListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_DOCTORS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateUser(patient.grpc.UpdateUserRequest request,
        io.grpc.stub.StreamObserver<patient.grpc.DBresponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UPDATE_USER, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAppointmentsByPatientCpr(patient.grpc.PatientRequest request,
        io.grpc.stub.StreamObserver<patient.grpc.GetAppointmentsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_APPOINTMENTS_BY_PATIENT_CPR, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cancelAppointment(patient.grpc.CancelAppointmentRequest request,
        io.grpc.stub.StreamObserver<patient.grpc.DBresponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CANCEL_APPOINTMENT, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PatientBlockingStub extends io.grpc.stub.AbstractStub<PatientBlockingStub> {
    private PatientBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PatientBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PatientBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PatientBlockingStub(channel, callOptions);
    }

    /**
     */
    public patient.grpc.DBresponse createAppointment(patient.grpc.CreateAppointment request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CREATE_APPOINTMENT, getCallOptions(), request);
    }

    /**
     */
    public patient.grpc.LoginResponse loginPatient(patient.grpc.PatientRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LOGIN_PATIENT, getCallOptions(), request);
    }

    /**
     */
    public patient.grpc.DBresponse registerPatient(patient.grpc.RegisterRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_REGISTER_PATIENT, getCallOptions(), request);
    }

    /**
     */
    public patient.grpc.CityListResponse getCities(patient.grpc.GetCities request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_CITIES, getCallOptions(), request);
    }

    /**
     */
    public patient.grpc.ClinicListResponse getClinics(patient.grpc.CityRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_CLINICS, getCallOptions(), request);
    }

    /**
     */
    public patient.grpc.DoctorListResponse getDoctors(patient.grpc.Clinic request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_DOCTORS, getCallOptions(), request);
    }

    /**
     */
    public patient.grpc.DBresponse updateUser(patient.grpc.UpdateUserRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_UPDATE_USER, getCallOptions(), request);
    }

    /**
     */
    public patient.grpc.GetAppointmentsResponse getAppointmentsByPatientCpr(patient.grpc.PatientRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_APPOINTMENTS_BY_PATIENT_CPR, getCallOptions(), request);
    }

    /**
     */
    public patient.grpc.DBresponse cancelAppointment(patient.grpc.CancelAppointmentRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CANCEL_APPOINTMENT, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PatientFutureStub extends io.grpc.stub.AbstractStub<PatientFutureStub> {
    private PatientFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PatientFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PatientFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PatientFutureStub(channel, callOptions);
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
        patient.grpc.PatientRequest request) {
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

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<patient.grpc.CityListResponse> getCities(
        patient.grpc.GetCities request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_CITIES, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<patient.grpc.ClinicListResponse> getClinics(
        patient.grpc.CityRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_CLINICS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<patient.grpc.DoctorListResponse> getDoctors(
        patient.grpc.Clinic request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_DOCTORS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<patient.grpc.DBresponse> updateUser(
        patient.grpc.UpdateUserRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UPDATE_USER, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<patient.grpc.GetAppointmentsResponse> getAppointmentsByPatientCpr(
        patient.grpc.PatientRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_APPOINTMENTS_BY_PATIENT_CPR, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<patient.grpc.DBresponse> cancelAppointment(
        patient.grpc.CancelAppointmentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CANCEL_APPOINTMENT, getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_APPOINTMENT = 0;
  private static final int METHODID_LOGIN_PATIENT = 1;
  private static final int METHODID_REGISTER_PATIENT = 2;
  private static final int METHODID_GET_CITIES = 3;
  private static final int METHODID_GET_CLINICS = 4;
  private static final int METHODID_GET_DOCTORS = 5;
  private static final int METHODID_UPDATE_USER = 6;
  private static final int METHODID_GET_APPOINTMENTS_BY_PATIENT_CPR = 7;
  private static final int METHODID_CANCEL_APPOINTMENT = 8;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PatientImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PatientImplBase serviceImpl, int methodId) {
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
          serviceImpl.loginPatient((patient.grpc.PatientRequest) request,
              (io.grpc.stub.StreamObserver<patient.grpc.LoginResponse>) responseObserver);
          break;
        case METHODID_REGISTER_PATIENT:
          serviceImpl.registerPatient((patient.grpc.RegisterRequest) request,
              (io.grpc.stub.StreamObserver<patient.grpc.DBresponse>) responseObserver);
          break;
        case METHODID_GET_CITIES:
          serviceImpl.getCities((patient.grpc.GetCities) request,
              (io.grpc.stub.StreamObserver<patient.grpc.CityListResponse>) responseObserver);
          break;
        case METHODID_GET_CLINICS:
          serviceImpl.getClinics((patient.grpc.CityRequest) request,
              (io.grpc.stub.StreamObserver<patient.grpc.ClinicListResponse>) responseObserver);
          break;
        case METHODID_GET_DOCTORS:
          serviceImpl.getDoctors((patient.grpc.Clinic) request,
              (io.grpc.stub.StreamObserver<patient.grpc.DoctorListResponse>) responseObserver);
          break;
        case METHODID_UPDATE_USER:
          serviceImpl.updateUser((patient.grpc.UpdateUserRequest) request,
              (io.grpc.stub.StreamObserver<patient.grpc.DBresponse>) responseObserver);
          break;
        case METHODID_GET_APPOINTMENTS_BY_PATIENT_CPR:
          serviceImpl.getAppointmentsByPatientCpr((patient.grpc.PatientRequest) request,
              (io.grpc.stub.StreamObserver<patient.grpc.GetAppointmentsResponse>) responseObserver);
          break;
        case METHODID_CANCEL_APPOINTMENT:
          serviceImpl.cancelAppointment((patient.grpc.CancelAppointmentRequest) request,
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

  private static final class PatientDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return patient.grpc.PatientOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PatientGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PatientDescriptorSupplier())
              .addMethod(METHOD_CREATE_APPOINTMENT)
              .addMethod(METHOD_LOGIN_PATIENT)
              .addMethod(METHOD_REGISTER_PATIENT)
              .addMethod(METHOD_GET_CITIES)
              .addMethod(METHOD_GET_CLINICS)
              .addMethod(METHOD_GET_DOCTORS)
              .addMethod(METHOD_UPDATE_USER)
              .addMethod(METHOD_GET_APPOINTMENTS_BY_PATIENT_CPR)
              .addMethod(METHOD_CANCEL_APPOINTMENT)
              .build();
        }
      }
    }
    return result;
  }
}
