// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: patient.proto

package patient.grpc;

public interface CityListResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:CityListResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .CityRequest cities = 1;</code>
   */
  java.util.List<patient.grpc.CityRequest> 
      getCitiesList();
  /**
   * <code>repeated .CityRequest cities = 1;</code>
   */
  patient.grpc.CityRequest getCities(int index);
  /**
   * <code>repeated .CityRequest cities = 1;</code>
   */
  int getCitiesCount();
  /**
   * <code>repeated .CityRequest cities = 1;</code>
   */
  java.util.List<? extends patient.grpc.CityRequestOrBuilder> 
      getCitiesOrBuilderList();
  /**
   * <code>repeated .CityRequest cities = 1;</code>
   */
  patient.grpc.CityRequestOrBuilder getCitiesOrBuilder(
      int index);
}
