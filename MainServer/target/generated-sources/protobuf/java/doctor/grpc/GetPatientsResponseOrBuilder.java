// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: doctor.proto

package doctor.grpc;

public interface GetPatientsResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:GetPatientsResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .PatientDtoMessage patients = 1;</code>
   */
  java.util.List<doctor.grpc.PatientDtoMessage> 
      getPatientsList();
  /**
   * <code>repeated .PatientDtoMessage patients = 1;</code>
   */
  doctor.grpc.PatientDtoMessage getPatients(int index);
  /**
   * <code>repeated .PatientDtoMessage patients = 1;</code>
   */
  int getPatientsCount();
  /**
   * <code>repeated .PatientDtoMessage patients = 1;</code>
   */
  java.util.List<? extends doctor.grpc.PatientDtoMessageOrBuilder> 
      getPatientsOrBuilderList();
  /**
   * <code>repeated .PatientDtoMessage patients = 1;</code>
   */
  doctor.grpc.PatientDtoMessageOrBuilder getPatientsOrBuilder(
      int index);
}
