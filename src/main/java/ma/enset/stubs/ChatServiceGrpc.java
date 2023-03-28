package ma.enset.stubs;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: chat.proto")
public final class ChatServiceGrpc {

  private ChatServiceGrpc() {}

  public static final String SERVICE_NAME = "ChatService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ma.enset.stubs.Chat.connect,
      ma.enset.stubs.Chat.CurrencyRequest> getDisconnectRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "disconnectRequest",
      requestType = ma.enset.stubs.Chat.connect.class,
      responseType = ma.enset.stubs.Chat.CurrencyRequest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ma.enset.stubs.Chat.connect,
      ma.enset.stubs.Chat.CurrencyRequest> getDisconnectRequestMethod() {
    io.grpc.MethodDescriptor<ma.enset.stubs.Chat.connect, ma.enset.stubs.Chat.CurrencyRequest> getDisconnectRequestMethod;
    if ((getDisconnectRequestMethod = ChatServiceGrpc.getDisconnectRequestMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getDisconnectRequestMethod = ChatServiceGrpc.getDisconnectRequestMethod) == null) {
          ChatServiceGrpc.getDisconnectRequestMethod = getDisconnectRequestMethod = 
              io.grpc.MethodDescriptor.<ma.enset.stubs.Chat.connect, ma.enset.stubs.Chat.CurrencyRequest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ChatService", "disconnectRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ma.enset.stubs.Chat.connect.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ma.enset.stubs.Chat.CurrencyRequest.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("disconnectRequest"))
                  .build();
          }
        }
     }
     return getDisconnectRequestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ma.enset.stubs.Chat.CurrencyRequest,
      ma.enset.stubs.Chat.CurrencyRequest> getFullCurrencyStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "fullCurrencyStream",
      requestType = ma.enset.stubs.Chat.CurrencyRequest.class,
      responseType = ma.enset.stubs.Chat.CurrencyRequest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ma.enset.stubs.Chat.CurrencyRequest,
      ma.enset.stubs.Chat.CurrencyRequest> getFullCurrencyStreamMethod() {
    io.grpc.MethodDescriptor<ma.enset.stubs.Chat.CurrencyRequest, ma.enset.stubs.Chat.CurrencyRequest> getFullCurrencyStreamMethod;
    if ((getFullCurrencyStreamMethod = ChatServiceGrpc.getFullCurrencyStreamMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getFullCurrencyStreamMethod = ChatServiceGrpc.getFullCurrencyStreamMethod) == null) {
          ChatServiceGrpc.getFullCurrencyStreamMethod = getFullCurrencyStreamMethod = 
              io.grpc.MethodDescriptor.<ma.enset.stubs.Chat.CurrencyRequest, ma.enset.stubs.Chat.CurrencyRequest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "ChatService", "fullCurrencyStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ma.enset.stubs.Chat.CurrencyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ma.enset.stubs.Chat.CurrencyRequest.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("fullCurrencyStream"))
                  .build();
          }
        }
     }
     return getFullCurrencyStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChatServiceStub newStub(io.grpc.Channel channel) {
    return new ChatServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChatServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ChatServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChatServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ChatServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ChatServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void disconnectRequest(ma.enset.stubs.Chat.connect request,
        io.grpc.stub.StreamObserver<ma.enset.stubs.Chat.CurrencyRequest> responseObserver) {
      asyncUnimplementedUnaryCall(getDisconnectRequestMethod(), responseObserver);
    }

    /**
     * <pre>
     *bidirectional streaming model
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ma.enset.stubs.Chat.CurrencyRequest> fullCurrencyStream(
        io.grpc.stub.StreamObserver<ma.enset.stubs.Chat.CurrencyRequest> responseObserver) {
      return asyncUnimplementedStreamingCall(getFullCurrencyStreamMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDisconnectRequestMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ma.enset.stubs.Chat.connect,
                ma.enset.stubs.Chat.CurrencyRequest>(
                  this, METHODID_DISCONNECT_REQUEST)))
          .addMethod(
            getFullCurrencyStreamMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                ma.enset.stubs.Chat.CurrencyRequest,
                ma.enset.stubs.Chat.CurrencyRequest>(
                  this, METHODID_FULL_CURRENCY_STREAM)))
          .build();
    }
  }

  /**
   */
  public static final class ChatServiceStub extends io.grpc.stub.AbstractStub<ChatServiceStub> {
    private ChatServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatServiceStub(channel, callOptions);
    }

    /**
     */
    public void disconnectRequest(ma.enset.stubs.Chat.connect request,
        io.grpc.stub.StreamObserver<ma.enset.stubs.Chat.CurrencyRequest> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDisconnectRequestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *bidirectional streaming model
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ma.enset.stubs.Chat.CurrencyRequest> fullCurrencyStream(
        io.grpc.stub.StreamObserver<ma.enset.stubs.Chat.CurrencyRequest> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getFullCurrencyStreamMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class ChatServiceBlockingStub extends io.grpc.stub.AbstractStub<ChatServiceBlockingStub> {
    private ChatServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ma.enset.stubs.Chat.CurrencyRequest disconnectRequest(ma.enset.stubs.Chat.connect request) {
      return blockingUnaryCall(
          getChannel(), getDisconnectRequestMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ChatServiceFutureStub extends io.grpc.stub.AbstractStub<ChatServiceFutureStub> {
    private ChatServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ma.enset.stubs.Chat.CurrencyRequest> disconnectRequest(
        ma.enset.stubs.Chat.connect request) {
      return futureUnaryCall(
          getChannel().newCall(getDisconnectRequestMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DISCONNECT_REQUEST = 0;
  private static final int METHODID_FULL_CURRENCY_STREAM = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ChatServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ChatServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DISCONNECT_REQUEST:
          serviceImpl.disconnectRequest((ma.enset.stubs.Chat.connect) request,
              (io.grpc.stub.StreamObserver<ma.enset.stubs.Chat.CurrencyRequest>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FULL_CURRENCY_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.fullCurrencyStream(
              (io.grpc.stub.StreamObserver<ma.enset.stubs.Chat.CurrencyRequest>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ChatServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChatServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ma.enset.stubs.Chat.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ChatService");
    }
  }

  private static final class ChatServiceFileDescriptorSupplier
      extends ChatServiceBaseDescriptorSupplier {
    ChatServiceFileDescriptorSupplier() {}
  }

  private static final class ChatServiceMethodDescriptorSupplier
      extends ChatServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ChatServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ChatServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ChatServiceFileDescriptorSupplier())
              .addMethod(getDisconnectRequestMethod())
              .addMethod(getFullCurrencyStreamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
