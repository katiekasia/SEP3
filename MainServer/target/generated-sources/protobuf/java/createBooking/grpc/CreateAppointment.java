// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: patient.proto

package createBooking.grpc;

/**
 * Protobuf type {@code CreateAppointment}
 */
public  final class CreateAppointment extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:CreateAppointment)
    CreateAppointmentOrBuilder {
  // Use CreateAppointment.newBuilder() to construct.
  private CreateAppointment(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CreateAppointment() {
    patientCpr_ = "";
    status_ = "";
    description_ = "";
    type_ = "";
    doctorId_ = "";
    appointmentDate_ = "";
    appointmentTime_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private CreateAppointment(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            patientCpr_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            status_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            description_ = s;
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            type_ = s;
            break;
          }
          case 42: {
            java.lang.String s = input.readStringRequireUtf8();

            doctorId_ = s;
            break;
          }
          case 50: {
            java.lang.String s = input.readStringRequireUtf8();

            appointmentDate_ = s;
            break;
          }
          case 58: {
            java.lang.String s = input.readStringRequireUtf8();

            appointmentTime_ = s;
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return createBooking.grpc.Patient.internal_static_CreateAppointment_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return createBooking.grpc.Patient.internal_static_CreateAppointment_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            createBooking.grpc.CreateAppointment.class, createBooking.grpc.CreateAppointment.Builder.class);
  }

  public static final int PATIENTCPR_FIELD_NUMBER = 1;
  private volatile java.lang.Object patientCpr_;
  /**
   * <code>string patientCpr = 1;</code>
   */
  public java.lang.String getPatientCpr() {
    java.lang.Object ref = patientCpr_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      patientCpr_ = s;
      return s;
    }
  }
  /**
   * <code>string patientCpr = 1;</code>
   */
  public com.google.protobuf.ByteString
      getPatientCprBytes() {
    java.lang.Object ref = patientCpr_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      patientCpr_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int STATUS_FIELD_NUMBER = 2;
  private volatile java.lang.Object status_;
  /**
   * <code>string status = 2;</code>
   */
  public java.lang.String getStatus() {
    java.lang.Object ref = status_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      status_ = s;
      return s;
    }
  }
  /**
   * <code>string status = 2;</code>
   */
  public com.google.protobuf.ByteString
      getStatusBytes() {
    java.lang.Object ref = status_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      status_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DESCRIPTION_FIELD_NUMBER = 3;
  private volatile java.lang.Object description_;
  /**
   * <code>string description = 3;</code>
   */
  public java.lang.String getDescription() {
    java.lang.Object ref = description_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      description_ = s;
      return s;
    }
  }
  /**
   * <code>string description = 3;</code>
   */
  public com.google.protobuf.ByteString
      getDescriptionBytes() {
    java.lang.Object ref = description_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      description_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TYPE_FIELD_NUMBER = 4;
  private volatile java.lang.Object type_;
  /**
   * <code>string type = 4;</code>
   */
  public java.lang.String getType() {
    java.lang.Object ref = type_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      type_ = s;
      return s;
    }
  }
  /**
   * <code>string type = 4;</code>
   */
  public com.google.protobuf.ByteString
      getTypeBytes() {
    java.lang.Object ref = type_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      type_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DOCTORID_FIELD_NUMBER = 5;
  private volatile java.lang.Object doctorId_;
  /**
   * <code>string doctorId = 5;</code>
   */
  public java.lang.String getDoctorId() {
    java.lang.Object ref = doctorId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      doctorId_ = s;
      return s;
    }
  }
  /**
   * <code>string doctorId = 5;</code>
   */
  public com.google.protobuf.ByteString
      getDoctorIdBytes() {
    java.lang.Object ref = doctorId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      doctorId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int APPOINTMENTDATE_FIELD_NUMBER = 6;
  private volatile java.lang.Object appointmentDate_;
  /**
   * <code>string appointmentDate = 6;</code>
   */
  public java.lang.String getAppointmentDate() {
    java.lang.Object ref = appointmentDate_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      appointmentDate_ = s;
      return s;
    }
  }
  /**
   * <code>string appointmentDate = 6;</code>
   */
  public com.google.protobuf.ByteString
      getAppointmentDateBytes() {
    java.lang.Object ref = appointmentDate_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      appointmentDate_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int APPOINTMENTTIME_FIELD_NUMBER = 7;
  private volatile java.lang.Object appointmentTime_;
  /**
   * <code>string appointmentTime = 7;</code>
   */
  public java.lang.String getAppointmentTime() {
    java.lang.Object ref = appointmentTime_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      appointmentTime_ = s;
      return s;
    }
  }
  /**
   * <code>string appointmentTime = 7;</code>
   */
  public com.google.protobuf.ByteString
      getAppointmentTimeBytes() {
    java.lang.Object ref = appointmentTime_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      appointmentTime_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getPatientCprBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, patientCpr_);
    }
    if (!getStatusBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, status_);
    }
    if (!getDescriptionBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, description_);
    }
    if (!getTypeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, type_);
    }
    if (!getDoctorIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 5, doctorId_);
    }
    if (!getAppointmentDateBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 6, appointmentDate_);
    }
    if (!getAppointmentTimeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 7, appointmentTime_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getPatientCprBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, patientCpr_);
    }
    if (!getStatusBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, status_);
    }
    if (!getDescriptionBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, description_);
    }
    if (!getTypeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, type_);
    }
    if (!getDoctorIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, doctorId_);
    }
    if (!getAppointmentDateBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, appointmentDate_);
    }
    if (!getAppointmentTimeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(7, appointmentTime_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof createBooking.grpc.CreateAppointment)) {
      return super.equals(obj);
    }
    createBooking.grpc.CreateAppointment other = (createBooking.grpc.CreateAppointment) obj;

    boolean result = true;
    result = result && getPatientCpr()
        .equals(other.getPatientCpr());
    result = result && getStatus()
        .equals(other.getStatus());
    result = result && getDescription()
        .equals(other.getDescription());
    result = result && getType()
        .equals(other.getType());
    result = result && getDoctorId()
        .equals(other.getDoctorId());
    result = result && getAppointmentDate()
        .equals(other.getAppointmentDate());
    result = result && getAppointmentTime()
        .equals(other.getAppointmentTime());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + PATIENTCPR_FIELD_NUMBER;
    hash = (53 * hash) + getPatientCpr().hashCode();
    hash = (37 * hash) + STATUS_FIELD_NUMBER;
    hash = (53 * hash) + getStatus().hashCode();
    hash = (37 * hash) + DESCRIPTION_FIELD_NUMBER;
    hash = (53 * hash) + getDescription().hashCode();
    hash = (37 * hash) + TYPE_FIELD_NUMBER;
    hash = (53 * hash) + getType().hashCode();
    hash = (37 * hash) + DOCTORID_FIELD_NUMBER;
    hash = (53 * hash) + getDoctorId().hashCode();
    hash = (37 * hash) + APPOINTMENTDATE_FIELD_NUMBER;
    hash = (53 * hash) + getAppointmentDate().hashCode();
    hash = (37 * hash) + APPOINTMENTTIME_FIELD_NUMBER;
    hash = (53 * hash) + getAppointmentTime().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static createBooking.grpc.CreateAppointment parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static createBooking.grpc.CreateAppointment parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static createBooking.grpc.CreateAppointment parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static createBooking.grpc.CreateAppointment parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static createBooking.grpc.CreateAppointment parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static createBooking.grpc.CreateAppointment parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static createBooking.grpc.CreateAppointment parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static createBooking.grpc.CreateAppointment parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static createBooking.grpc.CreateAppointment parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static createBooking.grpc.CreateAppointment parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static createBooking.grpc.CreateAppointment parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static createBooking.grpc.CreateAppointment parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(createBooking.grpc.CreateAppointment prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code CreateAppointment}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:CreateAppointment)
      createBooking.grpc.CreateAppointmentOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return createBooking.grpc.Patient.internal_static_CreateAppointment_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return createBooking.grpc.Patient.internal_static_CreateAppointment_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              createBooking.grpc.CreateAppointment.class, createBooking.grpc.CreateAppointment.Builder.class);
    }

    // Construct using createBooking.grpc.CreateAppointment.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      patientCpr_ = "";

      status_ = "";

      description_ = "";

      type_ = "";

      doctorId_ = "";

      appointmentDate_ = "";

      appointmentTime_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return createBooking.grpc.Patient.internal_static_CreateAppointment_descriptor;
    }

    public createBooking.grpc.CreateAppointment getDefaultInstanceForType() {
      return createBooking.grpc.CreateAppointment.getDefaultInstance();
    }

    public createBooking.grpc.CreateAppointment build() {
      createBooking.grpc.CreateAppointment result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public createBooking.grpc.CreateAppointment buildPartial() {
      createBooking.grpc.CreateAppointment result = new createBooking.grpc.CreateAppointment(this);
      result.patientCpr_ = patientCpr_;
      result.status_ = status_;
      result.description_ = description_;
      result.type_ = type_;
      result.doctorId_ = doctorId_;
      result.appointmentDate_ = appointmentDate_;
      result.appointmentTime_ = appointmentTime_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof createBooking.grpc.CreateAppointment) {
        return mergeFrom((createBooking.grpc.CreateAppointment)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(createBooking.grpc.CreateAppointment other) {
      if (other == createBooking.grpc.CreateAppointment.getDefaultInstance()) return this;
      if (!other.getPatientCpr().isEmpty()) {
        patientCpr_ = other.patientCpr_;
        onChanged();
      }
      if (!other.getStatus().isEmpty()) {
        status_ = other.status_;
        onChanged();
      }
      if (!other.getDescription().isEmpty()) {
        description_ = other.description_;
        onChanged();
      }
      if (!other.getType().isEmpty()) {
        type_ = other.type_;
        onChanged();
      }
      if (!other.getDoctorId().isEmpty()) {
        doctorId_ = other.doctorId_;
        onChanged();
      }
      if (!other.getAppointmentDate().isEmpty()) {
        appointmentDate_ = other.appointmentDate_;
        onChanged();
      }
      if (!other.getAppointmentTime().isEmpty()) {
        appointmentTime_ = other.appointmentTime_;
        onChanged();
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      createBooking.grpc.CreateAppointment parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (createBooking.grpc.CreateAppointment) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object patientCpr_ = "";
    /**
     * <code>string patientCpr = 1;</code>
     */
    public java.lang.String getPatientCpr() {
      java.lang.Object ref = patientCpr_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        patientCpr_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string patientCpr = 1;</code>
     */
    public com.google.protobuf.ByteString
        getPatientCprBytes() {
      java.lang.Object ref = patientCpr_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        patientCpr_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string patientCpr = 1;</code>
     */
    public Builder setPatientCpr(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      patientCpr_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string patientCpr = 1;</code>
     */
    public Builder clearPatientCpr() {
      
      patientCpr_ = getDefaultInstance().getPatientCpr();
      onChanged();
      return this;
    }
    /**
     * <code>string patientCpr = 1;</code>
     */
    public Builder setPatientCprBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      patientCpr_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object status_ = "";
    /**
     * <code>string status = 2;</code>
     */
    public java.lang.String getStatus() {
      java.lang.Object ref = status_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        status_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string status = 2;</code>
     */
    public com.google.protobuf.ByteString
        getStatusBytes() {
      java.lang.Object ref = status_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        status_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string status = 2;</code>
     */
    public Builder setStatus(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      status_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string status = 2;</code>
     */
    public Builder clearStatus() {
      
      status_ = getDefaultInstance().getStatus();
      onChanged();
      return this;
    }
    /**
     * <code>string status = 2;</code>
     */
    public Builder setStatusBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      status_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object description_ = "";
    /**
     * <code>string description = 3;</code>
     */
    public java.lang.String getDescription() {
      java.lang.Object ref = description_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        description_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string description = 3;</code>
     */
    public com.google.protobuf.ByteString
        getDescriptionBytes() {
      java.lang.Object ref = description_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        description_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string description = 3;</code>
     */
    public Builder setDescription(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      description_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string description = 3;</code>
     */
    public Builder clearDescription() {
      
      description_ = getDefaultInstance().getDescription();
      onChanged();
      return this;
    }
    /**
     * <code>string description = 3;</code>
     */
    public Builder setDescriptionBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      description_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object type_ = "";
    /**
     * <code>string type = 4;</code>
     */
    public java.lang.String getType() {
      java.lang.Object ref = type_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        type_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string type = 4;</code>
     */
    public com.google.protobuf.ByteString
        getTypeBytes() {
      java.lang.Object ref = type_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        type_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string type = 4;</code>
     */
    public Builder setType(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      type_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string type = 4;</code>
     */
    public Builder clearType() {
      
      type_ = getDefaultInstance().getType();
      onChanged();
      return this;
    }
    /**
     * <code>string type = 4;</code>
     */
    public Builder setTypeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      type_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object doctorId_ = "";
    /**
     * <code>string doctorId = 5;</code>
     */
    public java.lang.String getDoctorId() {
      java.lang.Object ref = doctorId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        doctorId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string doctorId = 5;</code>
     */
    public com.google.protobuf.ByteString
        getDoctorIdBytes() {
      java.lang.Object ref = doctorId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        doctorId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string doctorId = 5;</code>
     */
    public Builder setDoctorId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      doctorId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string doctorId = 5;</code>
     */
    public Builder clearDoctorId() {
      
      doctorId_ = getDefaultInstance().getDoctorId();
      onChanged();
      return this;
    }
    /**
     * <code>string doctorId = 5;</code>
     */
    public Builder setDoctorIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      doctorId_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object appointmentDate_ = "";
    /**
     * <code>string appointmentDate = 6;</code>
     */
    public java.lang.String getAppointmentDate() {
      java.lang.Object ref = appointmentDate_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        appointmentDate_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string appointmentDate = 6;</code>
     */
    public com.google.protobuf.ByteString
        getAppointmentDateBytes() {
      java.lang.Object ref = appointmentDate_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        appointmentDate_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string appointmentDate = 6;</code>
     */
    public Builder setAppointmentDate(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      appointmentDate_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string appointmentDate = 6;</code>
     */
    public Builder clearAppointmentDate() {
      
      appointmentDate_ = getDefaultInstance().getAppointmentDate();
      onChanged();
      return this;
    }
    /**
     * <code>string appointmentDate = 6;</code>
     */
    public Builder setAppointmentDateBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      appointmentDate_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object appointmentTime_ = "";
    /**
     * <code>string appointmentTime = 7;</code>
     */
    public java.lang.String getAppointmentTime() {
      java.lang.Object ref = appointmentTime_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        appointmentTime_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string appointmentTime = 7;</code>
     */
    public com.google.protobuf.ByteString
        getAppointmentTimeBytes() {
      java.lang.Object ref = appointmentTime_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        appointmentTime_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string appointmentTime = 7;</code>
     */
    public Builder setAppointmentTime(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      appointmentTime_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string appointmentTime = 7;</code>
     */
    public Builder clearAppointmentTime() {
      
      appointmentTime_ = getDefaultInstance().getAppointmentTime();
      onChanged();
      return this;
    }
    /**
     * <code>string appointmentTime = 7;</code>
     */
    public Builder setAppointmentTimeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      appointmentTime_ = value;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:CreateAppointment)
  }

  // @@protoc_insertion_point(class_scope:CreateAppointment)
  private static final createBooking.grpc.CreateAppointment DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new createBooking.grpc.CreateAppointment();
  }

  public static createBooking.grpc.CreateAppointment getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CreateAppointment>
      PARSER = new com.google.protobuf.AbstractParser<CreateAppointment>() {
    public CreateAppointment parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new CreateAppointment(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<CreateAppointment> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CreateAppointment> getParserForType() {
    return PARSER;
  }

  public createBooking.grpc.CreateAppointment getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
