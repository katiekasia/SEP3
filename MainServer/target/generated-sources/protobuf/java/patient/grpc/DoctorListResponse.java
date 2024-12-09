// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: patient.proto

package patient.grpc;

/**
 * Protobuf type {@code DoctorListResponse}
 */
public  final class DoctorListResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:DoctorListResponse)
    DoctorListResponseOrBuilder {
  // Use DoctorListResponse.newBuilder() to construct.
  private DoctorListResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private DoctorListResponse() {
    doctor_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private DoctorListResponse(
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
              doctor_ = new java.util.ArrayList<patient.grpc.DoctorRequest>();
              mutable_bitField0_ |= 0x00000001;
            }
            doctor_.add(
                input.readMessage(patient.grpc.DoctorRequest.parser(), extensionRegistry));
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
        doctor_ = java.util.Collections.unmodifiableList(doctor_);
      }
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return patient.grpc.PatientOuterClass.internal_static_DoctorListResponse_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return patient.grpc.PatientOuterClass.internal_static_DoctorListResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            patient.grpc.DoctorListResponse.class, patient.grpc.DoctorListResponse.Builder.class);
  }

  public static final int DOCTOR_FIELD_NUMBER = 1;
  private java.util.List<patient.grpc.DoctorRequest> doctor_;
  /**
   * <code>repeated .DoctorRequest doctor = 1;</code>
   */
  public java.util.List<patient.grpc.DoctorRequest> getDoctorList() {
    return doctor_;
  }
  /**
   * <code>repeated .DoctorRequest doctor = 1;</code>
   */
  public java.util.List<? extends patient.grpc.DoctorRequestOrBuilder> 
      getDoctorOrBuilderList() {
    return doctor_;
  }
  /**
   * <code>repeated .DoctorRequest doctor = 1;</code>
   */
  public int getDoctorCount() {
    return doctor_.size();
  }
  /**
   * <code>repeated .DoctorRequest doctor = 1;</code>
   */
  public patient.grpc.DoctorRequest getDoctor(int index) {
    return doctor_.get(index);
  }
  /**
   * <code>repeated .DoctorRequest doctor = 1;</code>
   */
  public patient.grpc.DoctorRequestOrBuilder getDoctorOrBuilder(
      int index) {
    return doctor_.get(index);
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
    for (int i = 0; i < doctor_.size(); i++) {
      output.writeMessage(1, doctor_.get(i));
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < doctor_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, doctor_.get(i));
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
    if (!(obj instanceof patient.grpc.DoctorListResponse)) {
      return super.equals(obj);
    }
    patient.grpc.DoctorListResponse other = (patient.grpc.DoctorListResponse) obj;

    boolean result = true;
    result = result && getDoctorList()
        .equals(other.getDoctorList());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getDoctorCount() > 0) {
      hash = (37 * hash) + DOCTOR_FIELD_NUMBER;
      hash = (53 * hash) + getDoctorList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static patient.grpc.DoctorListResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static patient.grpc.DoctorListResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static patient.grpc.DoctorListResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static patient.grpc.DoctorListResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static patient.grpc.DoctorListResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static patient.grpc.DoctorListResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static patient.grpc.DoctorListResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static patient.grpc.DoctorListResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static patient.grpc.DoctorListResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static patient.grpc.DoctorListResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static patient.grpc.DoctorListResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static patient.grpc.DoctorListResponse parseFrom(
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
  public static Builder newBuilder(patient.grpc.DoctorListResponse prototype) {
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
   * Protobuf type {@code DoctorListResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:DoctorListResponse)
      patient.grpc.DoctorListResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return patient.grpc.PatientOuterClass.internal_static_DoctorListResponse_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return patient.grpc.PatientOuterClass.internal_static_DoctorListResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              patient.grpc.DoctorListResponse.class, patient.grpc.DoctorListResponse.Builder.class);
    }

    // Construct using patient.grpc.DoctorListResponse.newBuilder()
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
        getDoctorFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      if (doctorBuilder_ == null) {
        doctor_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        doctorBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return patient.grpc.PatientOuterClass.internal_static_DoctorListResponse_descriptor;
    }

    public patient.grpc.DoctorListResponse getDefaultInstanceForType() {
      return patient.grpc.DoctorListResponse.getDefaultInstance();
    }

    public patient.grpc.DoctorListResponse build() {
      patient.grpc.DoctorListResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public patient.grpc.DoctorListResponse buildPartial() {
      patient.grpc.DoctorListResponse result = new patient.grpc.DoctorListResponse(this);
      int from_bitField0_ = bitField0_;
      if (doctorBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          doctor_ = java.util.Collections.unmodifiableList(doctor_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.doctor_ = doctor_;
      } else {
        result.doctor_ = doctorBuilder_.build();
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
      if (other instanceof patient.grpc.DoctorListResponse) {
        return mergeFrom((patient.grpc.DoctorListResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(patient.grpc.DoctorListResponse other) {
      if (other == patient.grpc.DoctorListResponse.getDefaultInstance()) return this;
      if (doctorBuilder_ == null) {
        if (!other.doctor_.isEmpty()) {
          if (doctor_.isEmpty()) {
            doctor_ = other.doctor_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureDoctorIsMutable();
            doctor_.addAll(other.doctor_);
          }
          onChanged();
        }
      } else {
        if (!other.doctor_.isEmpty()) {
          if (doctorBuilder_.isEmpty()) {
            doctorBuilder_.dispose();
            doctorBuilder_ = null;
            doctor_ = other.doctor_;
            bitField0_ = (bitField0_ & ~0x00000001);
            doctorBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getDoctorFieldBuilder() : null;
          } else {
            doctorBuilder_.addAllMessages(other.doctor_);
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
      patient.grpc.DoctorListResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (patient.grpc.DoctorListResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<patient.grpc.DoctorRequest> doctor_ =
      java.util.Collections.emptyList();
    private void ensureDoctorIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        doctor_ = new java.util.ArrayList<patient.grpc.DoctorRequest>(doctor_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        patient.grpc.DoctorRequest, patient.grpc.DoctorRequest.Builder, patient.grpc.DoctorRequestOrBuilder> doctorBuilder_;

    /**
     * <code>repeated .DoctorRequest doctor = 1;</code>
     */
    public java.util.List<patient.grpc.DoctorRequest> getDoctorList() {
      if (doctorBuilder_ == null) {
        return java.util.Collections.unmodifiableList(doctor_);
      } else {
        return doctorBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .DoctorRequest doctor = 1;</code>
     */
    public int getDoctorCount() {
      if (doctorBuilder_ == null) {
        return doctor_.size();
      } else {
        return doctorBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .DoctorRequest doctor = 1;</code>
     */
    public patient.grpc.DoctorRequest getDoctor(int index) {
      if (doctorBuilder_ == null) {
        return doctor_.get(index);
      } else {
        return doctorBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .DoctorRequest doctor = 1;</code>
     */
    public Builder setDoctor(
        int index, patient.grpc.DoctorRequest value) {
      if (doctorBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDoctorIsMutable();
        doctor_.set(index, value);
        onChanged();
      } else {
        doctorBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .DoctorRequest doctor = 1;</code>
     */
    public Builder setDoctor(
        int index, patient.grpc.DoctorRequest.Builder builderForValue) {
      if (doctorBuilder_ == null) {
        ensureDoctorIsMutable();
        doctor_.set(index, builderForValue.build());
        onChanged();
      } else {
        doctorBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .DoctorRequest doctor = 1;</code>
     */
    public Builder addDoctor(patient.grpc.DoctorRequest value) {
      if (doctorBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDoctorIsMutable();
        doctor_.add(value);
        onChanged();
      } else {
        doctorBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .DoctorRequest doctor = 1;</code>
     */
    public Builder addDoctor(
        int index, patient.grpc.DoctorRequest value) {
      if (doctorBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDoctorIsMutable();
        doctor_.add(index, value);
        onChanged();
      } else {
        doctorBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .DoctorRequest doctor = 1;</code>
     */
    public Builder addDoctor(
        patient.grpc.DoctorRequest.Builder builderForValue) {
      if (doctorBuilder_ == null) {
        ensureDoctorIsMutable();
        doctor_.add(builderForValue.build());
        onChanged();
      } else {
        doctorBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .DoctorRequest doctor = 1;</code>
     */
    public Builder addDoctor(
        int index, patient.grpc.DoctorRequest.Builder builderForValue) {
      if (doctorBuilder_ == null) {
        ensureDoctorIsMutable();
        doctor_.add(index, builderForValue.build());
        onChanged();
      } else {
        doctorBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .DoctorRequest doctor = 1;</code>
     */
    public Builder addAllDoctor(
        java.lang.Iterable<? extends patient.grpc.DoctorRequest> values) {
      if (doctorBuilder_ == null) {
        ensureDoctorIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, doctor_);
        onChanged();
      } else {
        doctorBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .DoctorRequest doctor = 1;</code>
     */
    public Builder clearDoctor() {
      if (doctorBuilder_ == null) {
        doctor_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        doctorBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .DoctorRequest doctor = 1;</code>
     */
    public Builder removeDoctor(int index) {
      if (doctorBuilder_ == null) {
        ensureDoctorIsMutable();
        doctor_.remove(index);
        onChanged();
      } else {
        doctorBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .DoctorRequest doctor = 1;</code>
     */
    public patient.grpc.DoctorRequest.Builder getDoctorBuilder(
        int index) {
      return getDoctorFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .DoctorRequest doctor = 1;</code>
     */
    public patient.grpc.DoctorRequestOrBuilder getDoctorOrBuilder(
        int index) {
      if (doctorBuilder_ == null) {
        return doctor_.get(index);  } else {
        return doctorBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .DoctorRequest doctor = 1;</code>
     */
    public java.util.List<? extends patient.grpc.DoctorRequestOrBuilder> 
         getDoctorOrBuilderList() {
      if (doctorBuilder_ != null) {
        return doctorBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(doctor_);
      }
    }
    /**
     * <code>repeated .DoctorRequest doctor = 1;</code>
     */
    public patient.grpc.DoctorRequest.Builder addDoctorBuilder() {
      return getDoctorFieldBuilder().addBuilder(
          patient.grpc.DoctorRequest.getDefaultInstance());
    }
    /**
     * <code>repeated .DoctorRequest doctor = 1;</code>
     */
    public patient.grpc.DoctorRequest.Builder addDoctorBuilder(
        int index) {
      return getDoctorFieldBuilder().addBuilder(
          index, patient.grpc.DoctorRequest.getDefaultInstance());
    }
    /**
     * <code>repeated .DoctorRequest doctor = 1;</code>
     */
    public java.util.List<patient.grpc.DoctorRequest.Builder> 
         getDoctorBuilderList() {
      return getDoctorFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        patient.grpc.DoctorRequest, patient.grpc.DoctorRequest.Builder, patient.grpc.DoctorRequestOrBuilder> 
        getDoctorFieldBuilder() {
      if (doctorBuilder_ == null) {
        doctorBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            patient.grpc.DoctorRequest, patient.grpc.DoctorRequest.Builder, patient.grpc.DoctorRequestOrBuilder>(
                doctor_,
                ((bitField0_ & 0x00000001) == 0x00000001),
                getParentForChildren(),
                isClean());
        doctor_ = null;
      }
      return doctorBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:DoctorListResponse)
  }

  // @@protoc_insertion_point(class_scope:DoctorListResponse)
  private static final patient.grpc.DoctorListResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new patient.grpc.DoctorListResponse();
  }

  public static patient.grpc.DoctorListResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DoctorListResponse>
      PARSER = new com.google.protobuf.AbstractParser<DoctorListResponse>() {
    public DoctorListResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new DoctorListResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<DoctorListResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DoctorListResponse> getParserForType() {
    return PARSER;
  }

  public patient.grpc.DoctorListResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
