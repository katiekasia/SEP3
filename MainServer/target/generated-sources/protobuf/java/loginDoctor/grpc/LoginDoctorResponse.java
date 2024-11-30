// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: loginDoctor.proto

package loginDoctor.grpc;

/**
 * Protobuf type {@code LoginDoctorResponse}
 */
public  final class LoginDoctorResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:LoginDoctorResponse)
    LoginDoctorResponseOrBuilder {
  // Use LoginDoctorResponse.newBuilder() to construct.
  private LoginDoctorResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private LoginDoctorResponse() {
    confirmation_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private LoginDoctorResponse(
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

            confirmation_ = s;
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
    return loginDoctor.grpc.LoginDoctorOuterClass.internal_static_LoginDoctorResponse_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return loginDoctor.grpc.LoginDoctorOuterClass.internal_static_LoginDoctorResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            loginDoctor.grpc.LoginDoctorResponse.class, loginDoctor.grpc.LoginDoctorResponse.Builder.class);
  }

  public static final int CONFIRMATION_FIELD_NUMBER = 1;
  private volatile java.lang.Object confirmation_;
  /**
   * <code>string confirmation = 1;</code>
   */
  public java.lang.String getConfirmation() {
    java.lang.Object ref = confirmation_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      confirmation_ = s;
      return s;
    }
  }
  /**
   * <code>string confirmation = 1;</code>
   */
  public com.google.protobuf.ByteString
      getConfirmationBytes() {
    java.lang.Object ref = confirmation_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      confirmation_ = b;
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
    if (!getConfirmationBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, confirmation_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getConfirmationBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, confirmation_);
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
    if (!(obj instanceof loginDoctor.grpc.LoginDoctorResponse)) {
      return super.equals(obj);
    }
    loginDoctor.grpc.LoginDoctorResponse other = (loginDoctor.grpc.LoginDoctorResponse) obj;

    boolean result = true;
    result = result && getConfirmation()
        .equals(other.getConfirmation());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + CONFIRMATION_FIELD_NUMBER;
    hash = (53 * hash) + getConfirmation().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static loginDoctor.grpc.LoginDoctorResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static loginDoctor.grpc.LoginDoctorResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static loginDoctor.grpc.LoginDoctorResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static loginDoctor.grpc.LoginDoctorResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static loginDoctor.grpc.LoginDoctorResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static loginDoctor.grpc.LoginDoctorResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static loginDoctor.grpc.LoginDoctorResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static loginDoctor.grpc.LoginDoctorResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static loginDoctor.grpc.LoginDoctorResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static loginDoctor.grpc.LoginDoctorResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static loginDoctor.grpc.LoginDoctorResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static loginDoctor.grpc.LoginDoctorResponse parseFrom(
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
  public static Builder newBuilder(loginDoctor.grpc.LoginDoctorResponse prototype) {
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
   * Protobuf type {@code LoginDoctorResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:LoginDoctorResponse)
      loginDoctor.grpc.LoginDoctorResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return loginDoctor.grpc.LoginDoctorOuterClass.internal_static_LoginDoctorResponse_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return loginDoctor.grpc.LoginDoctorOuterClass.internal_static_LoginDoctorResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              loginDoctor.grpc.LoginDoctorResponse.class, loginDoctor.grpc.LoginDoctorResponse.Builder.class);
    }

    // Construct using loginDoctor.grpc.LoginDoctorResponse.newBuilder()
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
      confirmation_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return loginDoctor.grpc.LoginDoctorOuterClass.internal_static_LoginDoctorResponse_descriptor;
    }

    public loginDoctor.grpc.LoginDoctorResponse getDefaultInstanceForType() {
      return loginDoctor.grpc.LoginDoctorResponse.getDefaultInstance();
    }

    public loginDoctor.grpc.LoginDoctorResponse build() {
      loginDoctor.grpc.LoginDoctorResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public loginDoctor.grpc.LoginDoctorResponse buildPartial() {
      loginDoctor.grpc.LoginDoctorResponse result = new loginDoctor.grpc.LoginDoctorResponse(this);
      result.confirmation_ = confirmation_;
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
      if (other instanceof loginDoctor.grpc.LoginDoctorResponse) {
        return mergeFrom((loginDoctor.grpc.LoginDoctorResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(loginDoctor.grpc.LoginDoctorResponse other) {
      if (other == loginDoctor.grpc.LoginDoctorResponse.getDefaultInstance()) return this;
      if (!other.getConfirmation().isEmpty()) {
        confirmation_ = other.confirmation_;
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
      loginDoctor.grpc.LoginDoctorResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (loginDoctor.grpc.LoginDoctorResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object confirmation_ = "";
    /**
     * <code>string confirmation = 1;</code>
     */
    public java.lang.String getConfirmation() {
      java.lang.Object ref = confirmation_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        confirmation_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string confirmation = 1;</code>
     */
    public com.google.protobuf.ByteString
        getConfirmationBytes() {
      java.lang.Object ref = confirmation_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        confirmation_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string confirmation = 1;</code>
     */
    public Builder setConfirmation(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      confirmation_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string confirmation = 1;</code>
     */
    public Builder clearConfirmation() {
      
      confirmation_ = getDefaultInstance().getConfirmation();
      onChanged();
      return this;
    }
    /**
     * <code>string confirmation = 1;</code>
     */
    public Builder setConfirmationBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      confirmation_ = value;
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


    // @@protoc_insertion_point(builder_scope:LoginDoctorResponse)
  }

  // @@protoc_insertion_point(class_scope:LoginDoctorResponse)
  private static final loginDoctor.grpc.LoginDoctorResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new loginDoctor.grpc.LoginDoctorResponse();
  }

  public static loginDoctor.grpc.LoginDoctorResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<LoginDoctorResponse>
      PARSER = new com.google.protobuf.AbstractParser<LoginDoctorResponse>() {
    public LoginDoctorResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new LoginDoctorResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<LoginDoctorResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<LoginDoctorResponse> getParserForType() {
    return PARSER;
  }

  public loginDoctor.grpc.LoginDoctorResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

