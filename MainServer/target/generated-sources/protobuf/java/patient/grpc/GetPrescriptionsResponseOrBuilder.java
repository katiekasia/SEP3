// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: patient.proto

package patient.grpc;

public interface GetPrescriptionsResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:GetPrescriptionsResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .PrescriptionInfo prescriptions = 1;</code>
   */
  java.util.List<patient.grpc.PrescriptionInfo> 
      getPrescriptionsList();
  /**
   * <code>repeated .PrescriptionInfo prescriptions = 1;</code>
   */
  patient.grpc.PrescriptionInfo getPrescriptions(int index);
  /**
   * <code>repeated .PrescriptionInfo prescriptions = 1;</code>
   */
  int getPrescriptionsCount();
  /**
   * <code>repeated .PrescriptionInfo prescriptions = 1;</code>
   */
  java.util.List<? extends patient.grpc.PrescriptionInfoOrBuilder> 
      getPrescriptionsOrBuilderList();
  /**
   * <code>repeated .PrescriptionInfo prescriptions = 1;</code>
   */
  patient.grpc.PrescriptionInfoOrBuilder getPrescriptionsOrBuilder(
      int index);
}
