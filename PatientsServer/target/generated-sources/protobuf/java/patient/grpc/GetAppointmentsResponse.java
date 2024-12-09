// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: patient.proto

package patient.grpc;

/**
 * Protobuf type {@code GetAppointmentsResponse}
 */
public  final class GetAppointmentsResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:GetAppointmentsResponse)
    GetAppointmentsResponseOrBuilder {
  // Use GetAppointmentsResponse.newBuilder() to construct.
  private GetAppointmentsResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetAppointmentsResponse() {
    appointments_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private GetAppointmentsResponse(
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
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              appointments_ = new java.util.ArrayList<patient.grpc.AppointmentInfo>();
              mutable_bitField0_ |= 0x00000001;
            }
            appointments_.add(
                input.readMessage(patient.grpc.AppointmentInfo.parser(), extensionRegistry));
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
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        appointments_ = java.util.Collections.unmodifiableList(appointments_);
      }
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return patient.grpc.PatientOuterClass.internal_static_GetAppointmentsResponse_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return patient.grpc.PatientOuterClass.internal_static_GetAppointmentsResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            patient.grpc.GetAppointmentsResponse.class, patient.grpc.GetAppointmentsResponse.Builder.class);
  }

  public static final int APPOINTMENTS_FIELD_NUMBER = 1;
  private java.util.List<patient.grpc.AppointmentInfo> appointments_;
  /**
   * <code>repeated .AppointmentInfo appointments = 1;</code>
   */
  public java.util.List<patient.grpc.AppointmentInfo> getAppointmentsList() {
    return appointments_;
  }
  /**
   * <code>repeated .AppointmentInfo appointments = 1;</code>
   */
  public java.util.List<? extends patient.grpc.AppointmentInfoOrBuilder> 
      getAppointmentsOrBuilderList() {
    return appointments_;
  }
  /**
   * <code>repeated .AppointmentInfo appointments = 1;</code>
   */
  public int getAppointmentsCount() {
    return appointments_.size();
  }
  /**
   * <code>repeated .AppointmentInfo appointments = 1;</code>
   */
  public patient.grpc.AppointmentInfo getAppointments(int index) {
    return appointments_.get(index);
  }
  /**
   * <code>repeated .AppointmentInfo appointments = 1;</code>
   */
  public patient.grpc.AppointmentInfoOrBuilder getAppointmentsOrBuilder(
      int index) {
    return appointments_.get(index);
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
    for (int i = 0; i < appointments_.size(); i++) {
      output.writeMessage(1, appointments_.get(i));
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < appointments_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, appointments_.get(i));
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
    if (!(obj instanceof patient.grpc.GetAppointmentsResponse)) {
      return super.equals(obj);
    }
    patient.grpc.GetAppointmentsResponse other = (patient.grpc.GetAppointmentsResponse) obj;

    boolean result = true;
    result = result && getAppointmentsList()
        .equals(other.getAppointmentsList());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getAppointmentsCount() > 0) {
      hash = (37 * hash) + APPOINTMENTS_FIELD_NUMBER;
      hash = (53 * hash) + getAppointmentsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static patient.grpc.GetAppointmentsResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static patient.grpc.GetAppointmentsResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static patient.grpc.GetAppointmentsResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static patient.grpc.GetAppointmentsResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static patient.grpc.GetAppointmentsResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static patient.grpc.GetAppointmentsResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static patient.grpc.GetAppointmentsResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static patient.grpc.GetAppointmentsResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static patient.grpc.GetAppointmentsResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static patient.grpc.GetAppointmentsResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static patient.grpc.GetAppointmentsResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static patient.grpc.GetAppointmentsResponse parseFrom(
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
  public static Builder newBuilder(patient.grpc.GetAppointmentsResponse prototype) {
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
   * Protobuf type {@code GetAppointmentsResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:GetAppointmentsResponse)
      patient.grpc.GetAppointmentsResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return patient.grpc.PatientOuterClass.internal_static_GetAppointmentsResponse_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return patient.grpc.PatientOuterClass.internal_static_GetAppointmentsResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              patient.grpc.GetAppointmentsResponse.class, patient.grpc.GetAppointmentsResponse.Builder.class);
    }

    // Construct using patient.grpc.GetAppointmentsResponse.newBuilder()
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
        getAppointmentsFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      if (appointmentsBuilder_ == null) {
        appointments_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        appointmentsBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return patient.grpc.PatientOuterClass.internal_static_GetAppointmentsResponse_descriptor;
    }

    public patient.grpc.GetAppointmentsResponse getDefaultInstanceForType() {
      return patient.grpc.GetAppointmentsResponse.getDefaultInstance();
    }

    public patient.grpc.GetAppointmentsResponse build() {
      patient.grpc.GetAppointmentsResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public patient.grpc.GetAppointmentsResponse buildPartial() {
      patient.grpc.GetAppointmentsResponse result = new patient.grpc.GetAppointmentsResponse(this);
      int from_bitField0_ = bitField0_;
      if (appointmentsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          appointments_ = java.util.Collections.unmodifiableList(appointments_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.appointments_ = appointments_;
      } else {
        result.appointments_ = appointmentsBuilder_.build();
      }
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
      if (other instanceof patient.grpc.GetAppointmentsResponse) {
        return mergeFrom((patient.grpc.GetAppointmentsResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(patient.grpc.GetAppointmentsResponse other) {
      if (other == patient.grpc.GetAppointmentsResponse.getDefaultInstance()) return this;
      if (appointmentsBuilder_ == null) {
        if (!other.appointments_.isEmpty()) {
          if (appointments_.isEmpty()) {
            appointments_ = other.appointments_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureAppointmentsIsMutable();
            appointments_.addAll(other.appointments_);
          }
          onChanged();
        }
      } else {
        if (!other.appointments_.isEmpty()) {
          if (appointmentsBuilder_.isEmpty()) {
            appointmentsBuilder_.dispose();
            appointmentsBuilder_ = null;
            appointments_ = other.appointments_;
            bitField0_ = (bitField0_ & ~0x00000001);
            appointmentsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getAppointmentsFieldBuilder() : null;
          } else {
            appointmentsBuilder_.addAllMessages(other.appointments_);
          }
        }
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
      patient.grpc.GetAppointmentsResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (patient.grpc.GetAppointmentsResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<patient.grpc.AppointmentInfo> appointments_ =
      java.util.Collections.emptyList();
    private void ensureAppointmentsIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        appointments_ = new java.util.ArrayList<patient.grpc.AppointmentInfo>(appointments_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        patient.grpc.AppointmentInfo, patient.grpc.AppointmentInfo.Builder, patient.grpc.AppointmentInfoOrBuilder> appointmentsBuilder_;

    /**
     * <code>repeated .AppointmentInfo appointments = 1;</code>
     */
    public java.util.List<patient.grpc.AppointmentInfo> getAppointmentsList() {
      if (appointmentsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(appointments_);
      } else {
        return appointmentsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .AppointmentInfo appointments = 1;</code>
     */
    public int getAppointmentsCount() {
      if (appointmentsBuilder_ == null) {
        return appointments_.size();
      } else {
        return appointmentsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .AppointmentInfo appointments = 1;</code>
     */
    public patient.grpc.AppointmentInfo getAppointments(int index) {
      if (appointmentsBuilder_ == null) {
        return appointments_.get(index);
      } else {
        return appointmentsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .AppointmentInfo appointments = 1;</code>
     */
    public Builder setAppointments(
        int index, patient.grpc.AppointmentInfo value) {
      if (appointmentsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureAppointmentsIsMutable();
        appointments_.set(index, value);
        onChanged();
      } else {
        appointmentsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .AppointmentInfo appointments = 1;</code>
     */
    public Builder setAppointments(
        int index, patient.grpc.AppointmentInfo.Builder builderForValue) {
      if (appointmentsBuilder_ == null) {
        ensureAppointmentsIsMutable();
        appointments_.set(index, builderForValue.build());
        onChanged();
      } else {
        appointmentsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .AppointmentInfo appointments = 1;</code>
     */
    public Builder addAppointments(patient.grpc.AppointmentInfo value) {
      if (appointmentsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureAppointmentsIsMutable();
        appointments_.add(value);
        onChanged();
      } else {
        appointmentsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .AppointmentInfo appointments = 1;</code>
     */
    public Builder addAppointments(
        int index, patient.grpc.AppointmentInfo value) {
      if (appointmentsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureAppointmentsIsMutable();
        appointments_.add(index, value);
        onChanged();
      } else {
        appointmentsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .AppointmentInfo appointments = 1;</code>
     */
    public Builder addAppointments(
        patient.grpc.AppointmentInfo.Builder builderForValue) {
      if (appointmentsBuilder_ == null) {
        ensureAppointmentsIsMutable();
        appointments_.add(builderForValue.build());
        onChanged();
      } else {
        appointmentsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .AppointmentInfo appointments = 1;</code>
     */
    public Builder addAppointments(
        int index, patient.grpc.AppointmentInfo.Builder builderForValue) {
      if (appointmentsBuilder_ == null) {
        ensureAppointmentsIsMutable();
        appointments_.add(index, builderForValue.build());
        onChanged();
      } else {
        appointmentsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .AppointmentInfo appointments = 1;</code>
     */
    public Builder addAllAppointments(
        java.lang.Iterable<? extends patient.grpc.AppointmentInfo> values) {
      if (appointmentsBuilder_ == null) {
        ensureAppointmentsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, appointments_);
        onChanged();
      } else {
        appointmentsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .AppointmentInfo appointments = 1;</code>
     */
    public Builder clearAppointments() {
      if (appointmentsBuilder_ == null) {
        appointments_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        appointmentsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .AppointmentInfo appointments = 1;</code>
     */
    public Builder removeAppointments(int index) {
      if (appointmentsBuilder_ == null) {
        ensureAppointmentsIsMutable();
        appointments_.remove(index);
        onChanged();
      } else {
        appointmentsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .AppointmentInfo appointments = 1;</code>
     */
    public patient.grpc.AppointmentInfo.Builder getAppointmentsBuilder(
        int index) {
      return getAppointmentsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .AppointmentInfo appointments = 1;</code>
     */
    public patient.grpc.AppointmentInfoOrBuilder getAppointmentsOrBuilder(
        int index) {
      if (appointmentsBuilder_ == null) {
        return appointments_.get(index);  } else {
        return appointmentsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .AppointmentInfo appointments = 1;</code>
     */
    public java.util.List<? extends patient.grpc.AppointmentInfoOrBuilder> 
         getAppointmentsOrBuilderList() {
      if (appointmentsBuilder_ != null) {
        return appointmentsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(appointments_);
      }
    }
    /**
     * <code>repeated .AppointmentInfo appointments = 1;</code>
     */
    public patient.grpc.AppointmentInfo.Builder addAppointmentsBuilder() {
      return getAppointmentsFieldBuilder().addBuilder(
          patient.grpc.AppointmentInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .AppointmentInfo appointments = 1;</code>
     */
    public patient.grpc.AppointmentInfo.Builder addAppointmentsBuilder(
        int index) {
      return getAppointmentsFieldBuilder().addBuilder(
          index, patient.grpc.AppointmentInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .AppointmentInfo appointments = 1;</code>
     */
    public java.util.List<patient.grpc.AppointmentInfo.Builder> 
         getAppointmentsBuilderList() {
      return getAppointmentsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        patient.grpc.AppointmentInfo, patient.grpc.AppointmentInfo.Builder, patient.grpc.AppointmentInfoOrBuilder> 
        getAppointmentsFieldBuilder() {
      if (appointmentsBuilder_ == null) {
        appointmentsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            patient.grpc.AppointmentInfo, patient.grpc.AppointmentInfo.Builder, patient.grpc.AppointmentInfoOrBuilder>(
                appointments_,
                ((bitField0_ & 0x00000001) == 0x00000001),
                getParentForChildren(),
                isClean());
        appointments_ = null;
      }
      return appointmentsBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:GetAppointmentsResponse)
  }

  // @@protoc_insertion_point(class_scope:GetAppointmentsResponse)
  private static final patient.grpc.GetAppointmentsResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new patient.grpc.GetAppointmentsResponse();
  }

  public static patient.grpc.GetAppointmentsResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetAppointmentsResponse>
      PARSER = new com.google.protobuf.AbstractParser<GetAppointmentsResponse>() {
    public GetAppointmentsResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new GetAppointmentsResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GetAppointmentsResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetAppointmentsResponse> getParserForType() {
    return PARSER;
  }

  public patient.grpc.GetAppointmentsResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

