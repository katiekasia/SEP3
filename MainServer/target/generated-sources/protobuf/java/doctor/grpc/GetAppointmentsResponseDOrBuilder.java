// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: doctor.proto

package doctor.grpc;

public interface GetAppointmentsResponseDOrBuilder extends
    // @@protoc_insertion_point(interface_extends:GetAppointmentsResponseD)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .AppointmentInfoD appointments = 1;</code>
   */
  java.util.List<doctor.grpc.AppointmentInfoD> 
      getAppointmentsList();
  /**
   * <code>repeated .AppointmentInfoD appointments = 1;</code>
   */
  doctor.grpc.AppointmentInfoD getAppointments(int index);
  /**
   * <code>repeated .AppointmentInfoD appointments = 1;</code>
   */
  int getAppointmentsCount();
  /**
   * <code>repeated .AppointmentInfoD appointments = 1;</code>
   */
  java.util.List<? extends doctor.grpc.AppointmentInfoDOrBuilder> 
      getAppointmentsOrBuilderList();
  /**
   * <code>repeated .AppointmentInfoD appointments = 1;</code>
   */
  doctor.grpc.AppointmentInfoDOrBuilder getAppointmentsOrBuilder(
      int index);
}
