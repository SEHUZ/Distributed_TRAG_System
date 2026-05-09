package com.mycompany.grpc.inventory;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: inventory_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class InventoryAndServiceGrpcGrpc {

  private InventoryAndServiceGrpcGrpc() {}

  public static final java.lang.String SERVICE_NAME = "InventoryAndServiceGrpc";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.mycompany.grpc.inventory.ServiceRequest,
      com.mycompany.grpc.inventory.ServiceSummaryResponse> getGetServiceSummaryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetServiceSummary",
      requestType = com.mycompany.grpc.inventory.ServiceRequest.class,
      responseType = com.mycompany.grpc.inventory.ServiceSummaryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mycompany.grpc.inventory.ServiceRequest,
      com.mycompany.grpc.inventory.ServiceSummaryResponse> getGetServiceSummaryMethod() {
    io.grpc.MethodDescriptor<com.mycompany.grpc.inventory.ServiceRequest, com.mycompany.grpc.inventory.ServiceSummaryResponse> getGetServiceSummaryMethod;
    if ((getGetServiceSummaryMethod = InventoryAndServiceGrpcGrpc.getGetServiceSummaryMethod) == null) {
      synchronized (InventoryAndServiceGrpcGrpc.class) {
        if ((getGetServiceSummaryMethod = InventoryAndServiceGrpcGrpc.getGetServiceSummaryMethod) == null) {
          InventoryAndServiceGrpcGrpc.getGetServiceSummaryMethod = getGetServiceSummaryMethod =
              io.grpc.MethodDescriptor.<com.mycompany.grpc.inventory.ServiceRequest, com.mycompany.grpc.inventory.ServiceSummaryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetServiceSummary"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.grpc.inventory.ServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.grpc.inventory.ServiceSummaryResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InventoryAndServiceGrpcMethodDescriptorSupplier("GetServiceSummary"))
              .build();
        }
      }
    }
    return getGetServiceSummaryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.mycompany.grpc.inventory.ServiceRequest,
      com.mycompany.grpc.inventory.ServiceDetailResponse> getGetServiceDetailMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetServiceDetail",
      requestType = com.mycompany.grpc.inventory.ServiceRequest.class,
      responseType = com.mycompany.grpc.inventory.ServiceDetailResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mycompany.grpc.inventory.ServiceRequest,
      com.mycompany.grpc.inventory.ServiceDetailResponse> getGetServiceDetailMethod() {
    io.grpc.MethodDescriptor<com.mycompany.grpc.inventory.ServiceRequest, com.mycompany.grpc.inventory.ServiceDetailResponse> getGetServiceDetailMethod;
    if ((getGetServiceDetailMethod = InventoryAndServiceGrpcGrpc.getGetServiceDetailMethod) == null) {
      synchronized (InventoryAndServiceGrpcGrpc.class) {
        if ((getGetServiceDetailMethod = InventoryAndServiceGrpcGrpc.getGetServiceDetailMethod) == null) {
          InventoryAndServiceGrpcGrpc.getGetServiceDetailMethod = getGetServiceDetailMethod =
              io.grpc.MethodDescriptor.<com.mycompany.grpc.inventory.ServiceRequest, com.mycompany.grpc.inventory.ServiceDetailResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetServiceDetail"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.grpc.inventory.ServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.grpc.inventory.ServiceDetailResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InventoryAndServiceGrpcMethodDescriptorSupplier("GetServiceDetail"))
              .build();
        }
      }
    }
    return getGetServiceDetailMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.mycompany.grpc.inventory.EmptyRequest,
      com.mycompany.grpc.inventory.ServiceListResponse> getGetAllServicesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllServices",
      requestType = com.mycompany.grpc.inventory.EmptyRequest.class,
      responseType = com.mycompany.grpc.inventory.ServiceListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mycompany.grpc.inventory.EmptyRequest,
      com.mycompany.grpc.inventory.ServiceListResponse> getGetAllServicesMethod() {
    io.grpc.MethodDescriptor<com.mycompany.grpc.inventory.EmptyRequest, com.mycompany.grpc.inventory.ServiceListResponse> getGetAllServicesMethod;
    if ((getGetAllServicesMethod = InventoryAndServiceGrpcGrpc.getGetAllServicesMethod) == null) {
      synchronized (InventoryAndServiceGrpcGrpc.class) {
        if ((getGetAllServicesMethod = InventoryAndServiceGrpcGrpc.getGetAllServicesMethod) == null) {
          InventoryAndServiceGrpcGrpc.getGetAllServicesMethod = getGetAllServicesMethod =
              io.grpc.MethodDescriptor.<com.mycompany.grpc.inventory.EmptyRequest, com.mycompany.grpc.inventory.ServiceListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllServices"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.grpc.inventory.EmptyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.grpc.inventory.ServiceListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InventoryAndServiceGrpcMethodDescriptorSupplier("GetAllServices"))
              .build();
        }
      }
    }
    return getGetAllServicesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.mycompany.grpc.inventory.SupplyRequest,
      com.mycompany.grpc.inventory.SupplySummaryResponse> getGetSupplySummaryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSupplySummary",
      requestType = com.mycompany.grpc.inventory.SupplyRequest.class,
      responseType = com.mycompany.grpc.inventory.SupplySummaryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mycompany.grpc.inventory.SupplyRequest,
      com.mycompany.grpc.inventory.SupplySummaryResponse> getGetSupplySummaryMethod() {
    io.grpc.MethodDescriptor<com.mycompany.grpc.inventory.SupplyRequest, com.mycompany.grpc.inventory.SupplySummaryResponse> getGetSupplySummaryMethod;
    if ((getGetSupplySummaryMethod = InventoryAndServiceGrpcGrpc.getGetSupplySummaryMethod) == null) {
      synchronized (InventoryAndServiceGrpcGrpc.class) {
        if ((getGetSupplySummaryMethod = InventoryAndServiceGrpcGrpc.getGetSupplySummaryMethod) == null) {
          InventoryAndServiceGrpcGrpc.getGetSupplySummaryMethod = getGetSupplySummaryMethod =
              io.grpc.MethodDescriptor.<com.mycompany.grpc.inventory.SupplyRequest, com.mycompany.grpc.inventory.SupplySummaryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSupplySummary"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.grpc.inventory.SupplyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.grpc.inventory.SupplySummaryResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InventoryAndServiceGrpcMethodDescriptorSupplier("GetSupplySummary"))
              .build();
        }
      }
    }
    return getGetSupplySummaryMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static InventoryAndServiceGrpcStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InventoryAndServiceGrpcStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<InventoryAndServiceGrpcStub>() {
        @java.lang.Override
        public InventoryAndServiceGrpcStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new InventoryAndServiceGrpcStub(channel, callOptions);
        }
      };
    return InventoryAndServiceGrpcStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static InventoryAndServiceGrpcBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InventoryAndServiceGrpcBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<InventoryAndServiceGrpcBlockingStub>() {
        @java.lang.Override
        public InventoryAndServiceGrpcBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new InventoryAndServiceGrpcBlockingStub(channel, callOptions);
        }
      };
    return InventoryAndServiceGrpcBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static InventoryAndServiceGrpcFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InventoryAndServiceGrpcFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<InventoryAndServiceGrpcFutureStub>() {
        @java.lang.Override
        public InventoryAndServiceGrpcFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new InventoryAndServiceGrpcFutureStub(channel, callOptions);
        }
      };
    return InventoryAndServiceGrpcFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getServiceSummary(com.mycompany.grpc.inventory.ServiceRequest request,
        io.grpc.stub.StreamObserver<com.mycompany.grpc.inventory.ServiceSummaryResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetServiceSummaryMethod(), responseObserver);
    }

    /**
     */
    default void getServiceDetail(com.mycompany.grpc.inventory.ServiceRequest request,
        io.grpc.stub.StreamObserver<com.mycompany.grpc.inventory.ServiceDetailResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetServiceDetailMethod(), responseObserver);
    }

    /**
     */
    default void getAllServices(com.mycompany.grpc.inventory.EmptyRequest request,
        io.grpc.stub.StreamObserver<com.mycompany.grpc.inventory.ServiceListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllServicesMethod(), responseObserver);
    }

    /**
     */
    default void getSupplySummary(com.mycompany.grpc.inventory.SupplyRequest request,
        io.grpc.stub.StreamObserver<com.mycompany.grpc.inventory.SupplySummaryResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSupplySummaryMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service InventoryAndServiceGrpc.
   */
  public static abstract class InventoryAndServiceGrpcImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return InventoryAndServiceGrpcGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service InventoryAndServiceGrpc.
   */
  public static final class InventoryAndServiceGrpcStub
      extends io.grpc.stub.AbstractAsyncStub<InventoryAndServiceGrpcStub> {
    private InventoryAndServiceGrpcStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InventoryAndServiceGrpcStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InventoryAndServiceGrpcStub(channel, callOptions);
    }

    /**
     */
    public void getServiceSummary(com.mycompany.grpc.inventory.ServiceRequest request,
        io.grpc.stub.StreamObserver<com.mycompany.grpc.inventory.ServiceSummaryResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetServiceSummaryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getServiceDetail(com.mycompany.grpc.inventory.ServiceRequest request,
        io.grpc.stub.StreamObserver<com.mycompany.grpc.inventory.ServiceDetailResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetServiceDetailMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllServices(com.mycompany.grpc.inventory.EmptyRequest request,
        io.grpc.stub.StreamObserver<com.mycompany.grpc.inventory.ServiceListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllServicesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getSupplySummary(com.mycompany.grpc.inventory.SupplyRequest request,
        io.grpc.stub.StreamObserver<com.mycompany.grpc.inventory.SupplySummaryResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSupplySummaryMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service InventoryAndServiceGrpc.
   */
  public static final class InventoryAndServiceGrpcBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<InventoryAndServiceGrpcBlockingStub> {
    private InventoryAndServiceGrpcBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InventoryAndServiceGrpcBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InventoryAndServiceGrpcBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.mycompany.grpc.inventory.ServiceSummaryResponse getServiceSummary(com.mycompany.grpc.inventory.ServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServiceSummaryMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.mycompany.grpc.inventory.ServiceDetailResponse getServiceDetail(com.mycompany.grpc.inventory.ServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServiceDetailMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.mycompany.grpc.inventory.ServiceListResponse getAllServices(com.mycompany.grpc.inventory.EmptyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllServicesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.mycompany.grpc.inventory.SupplySummaryResponse getSupplySummary(com.mycompany.grpc.inventory.SupplyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSupplySummaryMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service InventoryAndServiceGrpc.
   */
  public static final class InventoryAndServiceGrpcFutureStub
      extends io.grpc.stub.AbstractFutureStub<InventoryAndServiceGrpcFutureStub> {
    private InventoryAndServiceGrpcFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InventoryAndServiceGrpcFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InventoryAndServiceGrpcFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mycompany.grpc.inventory.ServiceSummaryResponse> getServiceSummary(
        com.mycompany.grpc.inventory.ServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetServiceSummaryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mycompany.grpc.inventory.ServiceDetailResponse> getServiceDetail(
        com.mycompany.grpc.inventory.ServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetServiceDetailMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mycompany.grpc.inventory.ServiceListResponse> getAllServices(
        com.mycompany.grpc.inventory.EmptyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllServicesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mycompany.grpc.inventory.SupplySummaryResponse> getSupplySummary(
        com.mycompany.grpc.inventory.SupplyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSupplySummaryMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_SERVICE_SUMMARY = 0;
  private static final int METHODID_GET_SERVICE_DETAIL = 1;
  private static final int METHODID_GET_ALL_SERVICES = 2;
  private static final int METHODID_GET_SUPPLY_SUMMARY = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_SERVICE_SUMMARY:
          serviceImpl.getServiceSummary((com.mycompany.grpc.inventory.ServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.mycompany.grpc.inventory.ServiceSummaryResponse>) responseObserver);
          break;
        case METHODID_GET_SERVICE_DETAIL:
          serviceImpl.getServiceDetail((com.mycompany.grpc.inventory.ServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.mycompany.grpc.inventory.ServiceDetailResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_SERVICES:
          serviceImpl.getAllServices((com.mycompany.grpc.inventory.EmptyRequest) request,
              (io.grpc.stub.StreamObserver<com.mycompany.grpc.inventory.ServiceListResponse>) responseObserver);
          break;
        case METHODID_GET_SUPPLY_SUMMARY:
          serviceImpl.getSupplySummary((com.mycompany.grpc.inventory.SupplyRequest) request,
              (io.grpc.stub.StreamObserver<com.mycompany.grpc.inventory.SupplySummaryResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetServiceSummaryMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.mycompany.grpc.inventory.ServiceRequest,
              com.mycompany.grpc.inventory.ServiceSummaryResponse>(
                service, METHODID_GET_SERVICE_SUMMARY)))
        .addMethod(
          getGetServiceDetailMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.mycompany.grpc.inventory.ServiceRequest,
              com.mycompany.grpc.inventory.ServiceDetailResponse>(
                service, METHODID_GET_SERVICE_DETAIL)))
        .addMethod(
          getGetAllServicesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.mycompany.grpc.inventory.EmptyRequest,
              com.mycompany.grpc.inventory.ServiceListResponse>(
                service, METHODID_GET_ALL_SERVICES)))
        .addMethod(
          getGetSupplySummaryMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.mycompany.grpc.inventory.SupplyRequest,
              com.mycompany.grpc.inventory.SupplySummaryResponse>(
                service, METHODID_GET_SUPPLY_SUMMARY)))
        .build();
  }

  private static abstract class InventoryAndServiceGrpcBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    InventoryAndServiceGrpcBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.mycompany.grpc.inventory.InventoryServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("InventoryAndServiceGrpc");
    }
  }

  private static final class InventoryAndServiceGrpcFileDescriptorSupplier
      extends InventoryAndServiceGrpcBaseDescriptorSupplier {
    InventoryAndServiceGrpcFileDescriptorSupplier() {}
  }

  private static final class InventoryAndServiceGrpcMethodDescriptorSupplier
      extends InventoryAndServiceGrpcBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    InventoryAndServiceGrpcMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (InventoryAndServiceGrpcGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new InventoryAndServiceGrpcFileDescriptorSupplier())
              .addMethod(getGetServiceSummaryMethod())
              .addMethod(getGetServiceDetailMethod())
              .addMethod(getGetAllServicesMethod())
              .addMethod(getGetSupplySummaryMethod())
              .build();
        }
      }
    }
    return result;
  }
}
