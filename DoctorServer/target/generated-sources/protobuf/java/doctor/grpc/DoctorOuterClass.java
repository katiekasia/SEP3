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
    internal_static_GetDoctorByIdRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GetDoctorByIdRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UniResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UniResponse_fieldAccessorTable;
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

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014doctor.proto\"\"\n\024GetDoctorByIdRequest\022\n" +
      "\n\002id\030\001 \001(\t\"\033\n\013UniResponse\022\014\n\004info\030\001 \001(\t\"" +
      "T\n\025GetDoctorByIdResponse\022\021\n\tfirstname\030\001 " +
      "\001(\t\022\020\n\010lastname\030\002 \001(\t\022\026\n\016specialisation\030" +
      "\003 \001(\t\"8\n\025ChangePasswordRequest\022\n\n\002id\030\001 \001" +
      "(\t\022\023\n\013newPassword\030\002 \001(\t\"j\n\023LoginDoctorRe" +
      "sponse\022\014\n\004name\030\001 \001(\t\022\017\n\007surname\030\002 \001(\t\022\026\n" +
      "\016specialisation\030\003 \001(\t\022\n\n\002id\030\004 \001(\t\022\020\n\010pas" +
      "sword\030\005 \001(\t2\302\001\n\006Doctor\022<\n\013loginDoctor\022\025." +
      "GetDoctorByIdRequest\032\024.LoginDoctorRespon",
      "se\"\000\0228\n\016changePassword\022\026.ChangePasswordR" +
      "equest\032\014.UniResponse\"\000\022@\n\rgetDoctorById\022" +
      "\025.GetDoctorByIdRequest\032\026.GetDoctorByIdRe" +
      "sponse\"\000B\017\n\013doctor.grpcP\001b\006proto3"
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
    internal_static_GetDoctorByIdRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_GetDoctorByIdRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GetDoctorByIdRequest_descriptor,
        new java.lang.String[] { "Id", });
    internal_static_UniResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_UniResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UniResponse_descriptor,
        new java.lang.String[] { "Info", });
    internal_static_GetDoctorByIdResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_GetDoctorByIdResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GetDoctorByIdResponse_descriptor,
        new java.lang.String[] { "Firstname", "Lastname", "Specialisation", });
    internal_static_ChangePasswordRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_ChangePasswordRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ChangePasswordRequest_descriptor,
        new java.lang.String[] { "Id", "NewPassword", });
    internal_static_LoginDoctorResponse_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_LoginDoctorResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_LoginDoctorResponse_descriptor,
        new java.lang.String[] { "Name", "Surname", "Specialisation", "Id", "Password", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
