// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: doctor.proto

package doctor.grpc;

/**
 * Protobuf type {@code GetPatientsRequest}
 */
public  final class GetPatientsRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:GetPatientsRequest)
    GetPatientsRequestOrBuilder {
  // Use GetPatientsRequest.newBuilder() to construct.
  private GetPatientsRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetPatientsRequest() {
    doctorid_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private GetPatientsRequest(
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

            doctorid_ = s;
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
    return doctor.grpc.DoctorOuterClass.internal_static_GetPatientsRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return doctor.grpc.DoctorOuterClass.internal_static_GetPatientsRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            doctor.grpc.GetPatientsRequest.class, doctor.grpc.GetPatientsRequest.Builder.class);
  }

  public static final int DOCTORID_FIELD_NUMBER = 1;
  private volatile java.lang.Object doctorid_;
  /**
   * <code>string doctorid = 1;</code>
   */
  public java.lang.String getDoctorid() {
    java.lang.Object ref = doctorid_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      doctorid_ = s;
      return s;
    }
  }
  /**
   * <code>string doctorid = 1;</code>
   */
  public com.google.protobuf.ByteString
      getDoctoridBytes() {
    java.lang.Object ref = doctorid_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      doctorid_ = b;
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
    if (!getDoctoridBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, doctorid_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getDoctoridBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, doctorid_);
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
    if (!(obj instanceof doctor.grpc.GetPatientsRequest)) {
      return super.equals(obj);
    }
    doctor.grpc.GetPatientsRequest other = (doctor.grpc.GetPatientsRequest) obj;

    boolean result = true;
    result = result && getDoctorid()
        .equals(other.getDoctorid());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + DOCTORID_FIELD_NUMBER;
    hash = (53 * hash) + getDoctorid().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static doctor.grpc.GetPatientsRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static doctor.grpc.GetPatientsRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static doctor.grpc.GetPatientsRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static doctor.grpc.GetPatientsRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static doctor.grpc.GetPatientsRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static doctor.grpc.GetPatientsRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static doctor.grpc.GetPatientsRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static doctor.grpc.GetPatientsRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static doctor.grpc.GetPatientsRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static doctor.grpc.GetPatientsRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static doctor.grpc.GetPatientsRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static doctor.grpc.GetPatientsRequest parseFrom(
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
  public static Builder newBuilder(doctor.grpc.GetPatientsRequest prototype) {
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
   * Protobuf type {@code GetPatientsRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:GetPatientsRequest)
      doctor.grpc.GetPatientsRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return doctor.grpc.DoctorOuterClass.internal_static_GetPatientsRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return doctor.grpc.DoctorOuterClass.internal_static_GetPatientsRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              doctor.grpc.GetPatientsRequest.class, doctor.grpc.GetPatientsRequest.Builder.class);
    }

    // Construct using doctor.grpc.GetPatientsRequest.newBuilder()
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
      doctorid_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return doctor.grpc.DoctorOuterClass.internal_static_GetPatientsRequest_descriptor;
    }

    public doctor.grpc.GetPatientsRequest getDefaultInstanceForType() {
      return doctor.grpc.GetPatientsRequest.getDefaultInstance();
    }

    public doctor.grpc.GetPatientsRequest build() {
      doctor.grpc.GetPatientsRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public doctor.grpc.GetPatientsRequest buildPartial() {
      doctor.grpc.GetPatientsRequest result = new doctor.grpc.GetPatientsRequest(this);
      result.doctorid_ = doctorid_;
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
      if (other instanceof doctor.grpc.GetPatientsRequest) {
        return mergeFrom((doctor.grpc.GetPatientsRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(doctor.grpc.GetPatientsRequest other) {
      if (other == doctor.grpc.GetPatientsRequest.getDefaultInstance()) return this;
      if (!other.getDoctorid().isEmpty()) {
        doctorid_ = other.doctorid_;
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
      doctor.grpc.GetPatientsRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (doctor.grpc.GetPatientsRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object doctorid_ = "";
    /**
     * <code>string doctorid = 1;</code>
     */
    public java.lang.String getDoctorid() {
      java.lang.Object ref = doctorid_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        doctorid_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string doctorid = 1;</code>
     */
    public com.google.protobuf.ByteString
        getDoctoridBytes() {
      java.lang.Object ref = doctorid_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        doctorid_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string doctorid = 1;</code>
     */
    public Builder setDoctorid(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      doctorid_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string doctorid = 1;</code>
     */
    public Builder clearDoctorid() {
      
      doctorid_ = getDefaultInstance().getDoctorid();
      onChanged();
      return this;
    }
    /**
     * <code>string doctorid = 1;</code>
     */
    public Builder setDoctoridBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      doctorid_ = value;
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


    // @@protoc_insertion_point(builder_scope:GetPatientsRequest)
  }

  // @@protoc_insertion_point(class_scope:GetPatientsRequest)
  private static final doctor.grpc.GetPatientsRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new doctor.grpc.GetPatientsRequest();
  }

  public static doctor.grpc.GetPatientsRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetPatientsRequest>
      PARSER = new com.google.protobuf.AbstractParser<GetPatientsRequest>() {
    public GetPatientsRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new GetPatientsRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GetPatientsRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetPatientsRequest> getParserForType() {
    return PARSER;
  }

  public doctor.grpc.GetPatientsRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

