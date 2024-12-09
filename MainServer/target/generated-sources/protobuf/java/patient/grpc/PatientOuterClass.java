// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: patient.proto

package patient.grpc;

public final class PatientOuterClass {
  private PatientOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CreateAppointment_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CreateAppointment_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CityRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CityRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CityListResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CityListResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ClinicListResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ClinicListResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Clinic_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Clinic_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GetCities_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GetCities_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_DoctorRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_DoctorRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_DoctorListResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_DoctorListResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_DBresponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_DBresponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RegisterRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RegisterRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_PatientRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PatientRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_LoginResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LoginResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AppointmentInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_AppointmentInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GetAppointmentsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GetAppointmentsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UpdateUserRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UpdateUserRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CancelAppointmentRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CancelAppointmentRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rpatient.proto\"\236\001\n\021CreateAppointment\022\014\n" +
      "\004type\030\001 \001(\t\022\023\n\013description\030\002 \001(\t\022\016\n\006stat" +
      "us\030\003 \001(\t\022\022\n\npatientCpr\030\004 \001(\t\022\020\n\010doctorId" +
      "\030\005 \001(\t\022\027\n\017appointmentDate\030\006 \001(\t\022\027\n\017appoi" +
      "ntmentTime\030\007 \001(\t\"/\n\013CityRequest\022\014\n\004name\030" +
      "\001 \001(\t\022\022\n\npostalcode\030\002 \001(\t\"0\n\020CityListRes" +
      "ponse\022\034\n\006cities\030\001 \003(\0132\014.CityRequest\".\n\022C" +
      "linicListResponse\022\030\n\007clinics\030\001 \003(\0132\007.Cli" +
      "nic\"3\n\006Clinic\022\n\n\002id\030\001 \001(\t\022\014\n\004name\030\002 \001(\t\022" +
      "\017\n\007address\030\003 \001(\t\"\034\n\tGetCities\022\017\n\007request",
      "\030\001 \001(\t\"X\n\rDoctorRequest\022\n\n\002id\030\001 \001(\t\022\021\n\tf" +
      "irstname\030\002 \001(\t\022\020\n\010lastname\030\003 \001(\t\022\026\n\016spec" +
      "ialisation\030\004 \001(\t\"4\n\022DoctorListResponse\022\036" +
      "\n\006doctor\030\001 \003(\0132\016.DoctorRequest\"\"\n\nDBresp" +
      "onse\022\024\n\014confirmation\030\001 \001(\t\"o\n\017RegisterRe" +
      "quest\022\014\n\004name\030\001 \001(\t\022\017\n\007surname\030\002 \001(\t\022\r\n\005" +
      "email\030\003 \001(\t\022\r\n\005phone\030\004 \001(\t\022\020\n\010password\030\005" +
      " \001(\t\022\r\n\005CPRNo\030\006 \001(\t\"\035\n\016PatientRequest\022\013\n" +
      "\003cpr\030\001 \001(\t\"k\n\rLoginResponse\022\014\n\004name\030\001 \001(" +
      "\t\022\017\n\007surname\030\002 \001(\t\022\r\n\005email\030\003 \001(\t\022\r\n\005pho",
      "ne\030\004 \001(\t\022\013\n\003cpr\030\005 \001(\t\022\020\n\010password\030\006 \001(\t\"" +
      "\247\002\n\017AppointmentInfo\022\n\n\002id\030\001 \001(\005\022\023\n\013descr" +
      "iption\030\002 \001(\t\022\014\n\004type\030\003 \001(\t\022\014\n\004date\030\004 \001(\t" +
      "\022\014\n\004time\030\005 \001(\t\022\016\n\006status\030\006 \001(\t\022\020\n\010doctor" +
      "Id\030\007 \001(\t\022\027\n\017doctorFirstName\030\010 \001(\t\022\026\n\016doc" +
      "torLastName\030\t \001(\t\022\034\n\024doctorSpecializatio" +
      "n\030\n \001(\t\022\022\n\nclinicName\030\013 \001(\t\022\024\n\014clinicStr" +
      "eet\030\014 \001(\t\022\032\n\022clinicStreetNumber\030\r \001(\t\022\022\n" +
      "\nclinicCity\030\016 \001(\t\"A\n\027GetAppointmentsResp" +
      "onse\022&\n\014appointments\030\001 \003(\0132\020.Appointment",
      "Info\"d\n\021UpdateUserRequest\022\013\n\003CPR\030\001 \001(\t\022\017" +
      "\n\007surname\030\002 \001(\t\022\r\n\005phone\030\003 \001(\t\022\r\n\005email\030" +
      "\004 \001(\t\022\023\n\013newPassword\030\005 \001(\t\"E\n\030CancelAppo" +
      "intmentRequest\022\025\n\rappointmentId\030\001 \001(\005\022\022\n" +
      "\npatientCpr\030\002 \001(\t2\361\003\n\007Patient\0226\n\021createA" +
      "ppointment\022\022.CreateAppointment\032\013.DBrespo" +
      "nse\"\000\0221\n\014loginPatient\022\017.PatientRequest\032\016" +
      ".LoginResponse\"\000\0222\n\017registerPatient\022\020.Re" +
      "gisterRequest\032\013.DBresponse\"\000\022*\n\tgetCitie" +
      "s\022\n.GetCities\032\021.CityListResponse\0221\n\ngetC",
      "linics\022\014.CityRequest\032\023.ClinicListRespons" +
      "e\"\000\022,\n\ngetDoctors\022\007.Clinic\032\023.DoctorListR" +
      "esponse\"\000\022/\n\nupdateUser\022\022.UpdateUserRequ" +
      "est\032\013.DBresponse\"\000\022J\n\033getAppointmentsByP" +
      "atientCpr\022\017.PatientRequest\032\030.GetAppointm" +
      "entsResponse\"\000\022=\n\021cancelAppointment\022\031.Ca" +
      "ncelAppointmentRequest\032\013.DBresponse\"\000B\020\n" +
      "\014patient.grpcP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_CreateAppointment_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_CreateAppointment_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CreateAppointment_descriptor,
        new java.lang.String[] { "Type", "Description", "Status", "PatientCpr", "DoctorId", "AppointmentDate", "AppointmentTime", });
    internal_static_CityRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_CityRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CityRequest_descriptor,
        new java.lang.String[] { "Name", "Postalcode", });
    internal_static_CityListResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_CityListResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CityListResponse_descriptor,
        new java.lang.String[] { "Cities", });
    internal_static_ClinicListResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_ClinicListResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ClinicListResponse_descriptor,
        new java.lang.String[] { "Clinics", });
    internal_static_Clinic_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_Clinic_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Clinic_descriptor,
        new java.lang.String[] { "Id", "Name", "Address", });
    internal_static_GetCities_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_GetCities_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GetCities_descriptor,
        new java.lang.String[] { "Request", });
    internal_static_DoctorRequest_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_DoctorRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_DoctorRequest_descriptor,
        new java.lang.String[] { "Id", "Firstname", "Lastname", "Specialisation", });
    internal_static_DoctorListResponse_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_DoctorListResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_DoctorListResponse_descriptor,
        new java.lang.String[] { "Doctor", });
    internal_static_DBresponse_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_DBresponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_DBresponse_descriptor,
        new java.lang.String[] { "Confirmation", });
    internal_static_RegisterRequest_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_RegisterRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RegisterRequest_descriptor,
        new java.lang.String[] { "Name", "Surname", "Email", "Phone", "Password", "CPRNo", });
    internal_static_PatientRequest_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_PatientRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_PatientRequest_descriptor,
        new java.lang.String[] { "Cpr", });
    internal_static_LoginResponse_descriptor =
      getDescriptor().getMessageTypes().get(11);
    internal_static_LoginResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_LoginResponse_descriptor,
        new java.lang.String[] { "Name", "Surname", "Email", "Phone", "Cpr", "Password", });
    internal_static_AppointmentInfo_descriptor =
      getDescriptor().getMessageTypes().get(12);
    internal_static_AppointmentInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_AppointmentInfo_descriptor,
        new java.lang.String[] { "Id", "Description", "Type", "Date", "Time", "Status", "DoctorId", "DoctorFirstName", "DoctorLastName", "DoctorSpecialization", "ClinicName", "ClinicStreet", "ClinicStreetNumber", "ClinicCity", });
    internal_static_GetAppointmentsResponse_descriptor =
      getDescriptor().getMessageTypes().get(13);
    internal_static_GetAppointmentsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GetAppointmentsResponse_descriptor,
        new java.lang.String[] { "Appointments", });
    internal_static_UpdateUserRequest_descriptor =
      getDescriptor().getMessageTypes().get(14);
    internal_static_UpdateUserRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UpdateUserRequest_descriptor,
        new java.lang.String[] { "CPR", "Surname", "Phone", "Email", "NewPassword", });
    internal_static_CancelAppointmentRequest_descriptor =
      getDescriptor().getMessageTypes().get(15);
    internal_static_CancelAppointmentRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CancelAppointmentRequest_descriptor,
        new java.lang.String[] { "AppointmentId", "PatientCpr", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
