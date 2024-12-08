// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: doctor.proto

package doctor.grpc;

/**
 * Protobuf type {@code GetDoctorByIdResponse}
 */
public  final class GetDoctorByIdResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:GetDoctorByIdResponse)
    GetDoctorByIdResponseOrBuilder {
  // Use GetDoctorByIdResponse.newBuilder() to construct.
  private GetDoctorByIdResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetDoctorByIdResponse() {
    firstname_ = "";
    lastname_ = "";
    specialisation_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private GetDoctorByIdResponse(
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

            firstname_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            lastname_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            specialisation_ = s;
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
    return doctor.grpc.DoctorOuterClass.internal_static_GetDoctorByIdResponse_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return doctor.grpc.DoctorOuterClass.internal_static_GetDoctorByIdResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            doctor.grpc.GetDoctorByIdResponse.class, doctor.grpc.GetDoctorByIdResponse.Builder.class);
  }

  public static final int FIRSTNAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object firstname_;
  /**
   * <code>string firstname = 1;</code>
   */
  public java.lang.String getFirstname() {
    java.lang.Object ref = firstname_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      firstname_ = s;
      return s;
    }
  }
  /**
   * <code>string firstname = 1;</code>
   */
  public com.google.protobuf.ByteString
      getFirstnameBytes() {
    java.lang.Object ref = firstname_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      firstname_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int LASTNAME_FIELD_NUMBER = 2;
  private volatile java.lang.Object lastname_;
  /**
   * <code>string lastname = 2;</code>
   */
  public java.lang.String getLastname() {
    java.lang.Object ref = lastname_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      lastname_ = s;
      return s;
    }
  }
  /**
   * <code>string lastname = 2;</code>
   */
  public com.google.protobuf.ByteString
      getLastnameBytes() {
    java.lang.Object ref = lastname_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      lastname_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SPECIALISATION_FIELD_NUMBER = 3;
  private volatile java.lang.Object specialisation_;
  /**
   * <code>string specialisation = 3;</code>
   */
  public java.lang.String getSpecialisation() {
    java.lang.Object ref = specialisation_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      specialisation_ = s;
      return s;
    }
  }
  /**
   * <code>string specialisation = 3;</code>
   */
  public com.google.protobuf.ByteString
      getSpecialisationBytes() {
    java.lang.Object ref = specialisation_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      specialisation_ = b;
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
    if (!getFirstnameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, firstname_);
    }
    if (!getLastnameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, lastname_);
    }
    if (!getSpecialisationBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, specialisation_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getFirstnameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, firstname_);
    }
    if (!getLastnameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, lastname_);
    }
    if (!getSpecialisationBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, specialisation_);
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
    if (!(obj instanceof doctor.grpc.GetDoctorByIdResponse)) {
      return super.equals(obj);
    }
    doctor.grpc.GetDoctorByIdResponse other = (doctor.grpc.GetDoctorByIdResponse) obj;

    boolean result = true;
    result = result && getFirstname()
        .equals(other.getFirstname());
    result = result && getLastname()
        .equals(other.getLastname());
    result = result && getSpecialisation()
        .equals(other.getSpecialisation());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + FIRSTNAME_FIELD_NUMBER;
    hash = (53 * hash) + getFirstname().hashCode();
    hash = (37 * hash) + LASTNAME_FIELD_NUMBER;
    hash = (53 * hash) + getLastname().hashCode();
    hash = (37 * hash) + SPECIALISATION_FIELD_NUMBER;
    hash = (53 * hash) + getSpecialisation().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static doctor.grpc.GetDoctorByIdResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static doctor.grpc.GetDoctorByIdResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static doctor.grpc.GetDoctorByIdResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static doctor.grpc.GetDoctorByIdResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static doctor.grpc.GetDoctorByIdResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static doctor.grpc.GetDoctorByIdResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static doctor.grpc.GetDoctorByIdResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static doctor.grpc.GetDoctorByIdResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static doctor.grpc.GetDoctorByIdResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static doctor.grpc.GetDoctorByIdResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static doctor.grpc.GetDoctorByIdResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static doctor.grpc.GetDoctorByIdResponse parseFrom(
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
  public static Builder newBuilder(doctor.grpc.GetDoctorByIdResponse prototype) {
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
   * Protobuf type {@code GetDoctorByIdResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:GetDoctorByIdResponse)
      doctor.grpc.GetDoctorByIdResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return doctor.grpc.DoctorOuterClass.internal_static_GetDoctorByIdResponse_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return doctor.grpc.DoctorOuterClass.internal_static_GetDoctorByIdResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              doctor.grpc.GetDoctorByIdResponse.class, doctor.grpc.GetDoctorByIdResponse.Builder.class);
    }

    // Construct using doctor.grpc.GetDoctorByIdResponse.newBuilder()
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
      firstname_ = "";

      lastname_ = "";

      specialisation_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return doctor.grpc.DoctorOuterClass.internal_static_GetDoctorByIdResponse_descriptor;
    }

    public doctor.grpc.GetDoctorByIdResponse getDefaultInstanceForType() {
      return doctor.grpc.GetDoctorByIdResponse.getDefaultInstance();
    }

    public doctor.grpc.GetDoctorByIdResponse build() {
      doctor.grpc.GetDoctorByIdResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public doctor.grpc.GetDoctorByIdResponse buildPartial() {
      doctor.grpc.GetDoctorByIdResponse result = new doctor.grpc.GetDoctorByIdResponse(this);
      result.firstname_ = firstname_;
      result.lastname_ = lastname_;
      result.specialisation_ = specialisation_;
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
      if (other instanceof doctor.grpc.GetDoctorByIdResponse) {
        return mergeFrom((doctor.grpc.GetDoctorByIdResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(doctor.grpc.GetDoctorByIdResponse other) {
      if (other == doctor.grpc.GetDoctorByIdResponse.getDefaultInstance()) return this;
      if (!other.getFirstname().isEmpty()) {
        firstname_ = other.firstname_;
        onChanged();
      }
      if (!other.getLastname().isEmpty()) {
        lastname_ = other.lastname_;
        onChanged();
      }
      if (!other.getSpecialisation().isEmpty()) {
        specialisation_ = other.specialisation_;
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
      doctor.grpc.GetDoctorByIdResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (doctor.grpc.GetDoctorByIdResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object firstname_ = "";
    /**
     * <code>string firstname = 1;</code>
     */
    public java.lang.String getFirstname() {
      java.lang.Object ref = firstname_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        firstname_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string firstname = 1;</code>
     */
    public com.google.protobuf.ByteString
        getFirstnameBytes() {
      java.lang.Object ref = firstname_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        firstname_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string firstname = 1;</code>
     */
    public Builder setFirstname(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      firstname_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string firstname = 1;</code>
     */
    public Builder clearFirstname() {
      
      firstname_ = getDefaultInstance().getFirstname();
      onChanged();
      return this;
    }
    /**
     * <code>string firstname = 1;</code>
     */
    public Builder setFirstnameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      firstname_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object lastname_ = "";
    /**
     * <code>string lastname = 2;</code>
     */
    public java.lang.String getLastname() {
      java.lang.Object ref = lastname_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        lastname_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string lastname = 2;</code>
     */
    public com.google.protobuf.ByteString
        getLastnameBytes() {
      java.lang.Object ref = lastname_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        lastname_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string lastname = 2;</code>
     */
    public Builder setLastname(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      lastname_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string lastname = 2;</code>
     */
    public Builder clearLastname() {
      
      lastname_ = getDefaultInstance().getLastname();
      onChanged();
      return this;
    }
    /**
     * <code>string lastname = 2;</code>
     */
    public Builder setLastnameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      lastname_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object specialisation_ = "";
    /**
     * <code>string specialisation = 3;</code>
     */
    public java.lang.String getSpecialisation() {
      java.lang.Object ref = specialisation_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        specialisation_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string specialisation = 3;</code>
     */
    public com.google.protobuf.ByteString
        getSpecialisationBytes() {
      java.lang.Object ref = specialisation_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        specialisation_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string specialisation = 3;</code>
     */
    public Builder setSpecialisation(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      specialisation_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string specialisation = 3;</code>
     */
    public Builder clearSpecialisation() {
      
      specialisation_ = getDefaultInstance().getSpecialisation();
      onChanged();
      return this;
    }
    /**
     * <code>string specialisation = 3;</code>
     */
    public Builder setSpecialisationBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      specialisation_ = value;
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


    // @@protoc_insertion_point(builder_scope:GetDoctorByIdResponse)
  }

  // @@protoc_insertion_point(class_scope:GetDoctorByIdResponse)
  private static final doctor.grpc.GetDoctorByIdResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new doctor.grpc.GetDoctorByIdResponse();
  }

  public static doctor.grpc.GetDoctorByIdResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetDoctorByIdResponse>
      PARSER = new com.google.protobuf.AbstractParser<GetDoctorByIdResponse>() {
    public GetDoctorByIdResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new GetDoctorByIdResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GetDoctorByIdResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetDoctorByIdResponse> getParserForType() {
    return PARSER;
  }

  public doctor.grpc.GetDoctorByIdResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

