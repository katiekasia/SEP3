// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: doctor.proto

package doctor.grpc;

public final class DoctorOuterClass {
  private DoctorOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_EmptyRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_EmptyRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Response_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Response_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_LoginDoctorRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LoginDoctorRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GetDoctorByIdRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GetDoctorByIdRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GetDoctorByIdResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GetDoctorByIdResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ChangePasswordRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ChangePasswordRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_LoginDoctorResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LoginDoctorResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_PatientDtoMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PatientDtoMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GetPatientsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GetPatientsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GetPatientsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GetPatientsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AddPrescriptionRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_AddPrescriptionRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014doctor.proto\032\033google/protobuf/empty.pr" +
      "oto\"\016\n\014EmptyRequest\" \n\010Response\022\024\n\014confi" +
      "rmation\030\001 \001(\t\"2\n\022LoginDoctorRequest\022\n\n\002i" +
      "d\030\001 \001(\t\022\020\n\010password\030\002 \001(\t\"\"\n\024GetDoctorBy" +
      "IdRequest\022\n\n\002id\030\001 \001(\t\"T\n\025GetDoctorByIdRe" +
      "sponse\022\021\n\tfirstname\030\001 \001(\t\022\020\n\010lastname\030\002 " +
      "\001(\t\022\026\n\016specialisation\030\003 \001(\t\"Q\n\025ChangePas" +
      "swordRequest\022\n\n\002id\030\001 \001(\t\022\027\n\017currentPassw" +
      "ord\030\002 \001(\t\022\023\n\013newPassword\030\003 \001(\t\"+\n\023LoginD" +
      "octorResponse\022\024\n\014confirmation\030\001 \001(\t\"i\n\021P",
      "atientDtoMessage\022\013\n\003cpr\030\001 \001(\t\022\021\n\tfirstNa" +
      "me\030\002 \001(\t\022\020\n\010lastName\030\003 \001(\t\022\r\n\005email\030\004 \001(" +
      "\t\022\023\n\013phoneNumber\030\005 \001(\t\"&\n\022GetPatientsReq" +
      "uest\022\020\n\010doctorid\030\001 \001(\t\";\n\023GetPatientsRes" +
      "ponse\022$\n\010patients\030\001 \003(\0132\022.PatientDtoMess" +
      "age\"\246\001\n\026AddPrescriptionRequest\022\n\n\002id\030\001 \001" +
      "(\t\022\021\n\tdiagnosis\030\002 \001(\t\022\022\n\nmedication\030\003 \001(" +
      "\t\022\027\n\017recommendations\030\004 \001(\t\022\014\n\004date\030\005 \001(\t" +
      "\022\014\n\004time\030\006 \001(\t\022\022\n\npatientcpr\030\007 \001(\t\022\020\n\010do" +
      "ctorid\030\010 \001(\t2\307\002\n\006Doctor\022:\n\013loginDoctor\022\023",
      ".LoginDoctorRequest\032\024.LoginDoctorRespons" +
      "e\"\000\022@\n\016changePassword\022\026.ChangePasswordRe" +
      "quest\032\024.LoginDoctorResponse\"\000\022@\n\rgetDoct" +
      "orById\022\025.GetDoctorByIdRequest\032\026.GetDocto" +
      "rByIdResponse\"\000\022D\n\025getPatientsByDoctorId" +
      "\022\023.GetPatientsRequest\032\024.GetPatientsRespo" +
      "nse\"\000\0227\n\017addPrescription\022\027.AddPrescripti" +
      "onRequest\032\t.Response\"\000B\017\n\013doctor.grpcP\001b" +
      "\006proto3"
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
          com.google.protobuf.EmptyProto.getDescriptor(),
        }, assigner);
    internal_static_EmptyRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_EmptyRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_EmptyRequest_descriptor,
        new java.lang.String[] { });
    internal_static_Response_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Response_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Response_descriptor,
        new java.lang.String[] { "Confirmation", });
    internal_static_LoginDoctorRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_LoginDoctorRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_LoginDoctorRequest_descriptor,
        new java.lang.String[] { "Id", "Password", });
    internal_static_GetDoctorByIdRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_GetDoctorByIdRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GetDoctorByIdRequest_descriptor,
        new java.lang.String[] { "Id", });
    internal_static_GetDoctorByIdResponse_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_GetDoctorByIdResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GetDoctorByIdResponse_descriptor,
        new java.lang.String[] { "Firstname", "Lastname", "Specialisation", });
    internal_static_ChangePasswordRequest_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_ChangePasswordRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ChangePasswordRequest_descriptor,
        new java.lang.String[] { "Id", "CurrentPassword", "NewPassword", });
    internal_static_LoginDoctorResponse_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_LoginDoctorResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_LoginDoctorResponse_descriptor,
        new java.lang.String[] { "Confirmation", });
    internal_static_PatientDtoMessage_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_PatientDtoMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_PatientDtoMessage_descriptor,
        new java.lang.String[] { "Cpr", "FirstName", "LastName", "Email", "PhoneNumber", });
    internal_static_GetPatientsRequest_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_GetPatientsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GetPatientsRequest_descriptor,
        new java.lang.String[] { "Doctorid", });
    internal_static_GetPatientsResponse_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_GetPatientsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GetPatientsResponse_descriptor,
        new java.lang.String[] { "Patients", });
    internal_static_AddPrescriptionRequest_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_AddPrescriptionRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_AddPrescriptionRequest_descriptor,
        new java.lang.String[] { "Id", "Diagnosis", "Medication", "Recommendations", "Date", "Time", "Patientcpr", "Doctorid", });
    com.google.protobuf.EmptyProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
