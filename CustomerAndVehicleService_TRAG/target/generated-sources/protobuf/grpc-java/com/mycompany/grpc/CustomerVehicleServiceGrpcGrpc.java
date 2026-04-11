package com.mycompany.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: customer_vehicle.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CustomerVehicleServiceGrpcGrpc {

  private CustomerVehicleServiceGrpcGrpc() {}

  public static final java.lang.String SERVICE_NAME = "CustomerVehicleServiceGrpc";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.mycompany.grpc.CustomerRequest,
      com.mycompany.grpc.CustomerSummaryResponse> getGetCustomerSummaryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCustomerSummary",
      requestType = com.mycompany.grpc.CustomerRequest.class,
      responseType = com.mycompany.grpc.CustomerSummaryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mycompany.grpc.CustomerRequest,
      com.mycompany.grpc.CustomerSummaryResponse> getGetCustomerSummaryMethod() {
    io.grpc.MethodDescriptor<com.mycompany.grpc.CustomerRequest, com.mycompany.grpc.CustomerSummaryResponse> getGetCustomerSummaryMethod;
    if ((getGetCustomerSummaryMethod = CustomerVehicleServiceGrpcGrpc.getGetCustomerSummaryMethod) == null) {
      synchronized (CustomerVehicleServiceGrpcGrpc.class) {
        if ((getGetCustomerSummaryMethod = CustomerVehicleServiceGrpcGrpc.getGetCustomerSummaryMethod) == null) {
          CustomerVehicleServiceGrpcGrpc.getGetCustomerSummaryMethod = getGetCustomerSummaryMethod =
              io.grpc.MethodDescriptor.<com.mycompany.grpc.CustomerRequest, com.mycompany.grpc.CustomerSummaryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCustomerSummary"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.grpc.CustomerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.grpc.CustomerSummaryResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CustomerVehicleServiceGrpcMethodDescriptorSupplier("GetCustomerSummary"))
              .build();
        }
      }
    }
    return getGetCustomerSummaryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.mycompany.grpc.VehicleRequest,
      com.mycompany.grpc.VehicleSummaryResponse> getGetVehicleSummaryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetVehicleSummary",
      requestType = com.mycompany.grpc.VehicleRequest.class,
      responseType = com.mycompany.grpc.VehicleSummaryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mycompany.grpc.VehicleRequest,
      com.mycompany.grpc.VehicleSummaryResponse> getGetVehicleSummaryMethod() {
    io.grpc.MethodDescriptor<com.mycompany.grpc.VehicleRequest, com.mycompany.grpc.VehicleSummaryResponse> getGetVehicleSummaryMethod;
    if ((getGetVehicleSummaryMethod = CustomerVehicleServiceGrpcGrpc.getGetVehicleSummaryMethod) == null) {
      synchronized (CustomerVehicleServiceGrpcGrpc.class) {
        if ((getGetVehicleSummaryMethod = CustomerVehicleServiceGrpcGrpc.getGetVehicleSummaryMethod) == null) {
          CustomerVehicleServiceGrpcGrpc.getGetVehicleSummaryMethod = getGetVehicleSummaryMethod =
              io.grpc.MethodDescriptor.<com.mycompany.grpc.VehicleRequest, com.mycompany.grpc.VehicleSummaryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetVehicleSummary"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.grpc.VehicleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.grpc.VehicleSummaryResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CustomerVehicleServiceGrpcMethodDescriptorSupplier("GetVehicleSummary"))
              .build();
        }
      }
    }
    return getGetVehicleSummaryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.mycompany.grpc.EmptyRequest,
      com.mycompany.grpc.CustomerListResponse> getGetAllCustomersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllCustomers",
      requestType = com.mycompany.grpc.EmptyRequest.class,
      responseType = com.mycompany.grpc.CustomerListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mycompany.grpc.EmptyRequest,
      com.mycompany.grpc.CustomerListResponse> getGetAllCustomersMethod() {
    io.grpc.MethodDescriptor<com.mycompany.grpc.EmptyRequest, com.mycompany.grpc.CustomerListResponse> getGetAllCustomersMethod;
    if ((getGetAllCustomersMethod = CustomerVehicleServiceGrpcGrpc.getGetAllCustomersMethod) == null) {
      synchronized (CustomerVehicleServiceGrpcGrpc.class) {
        if ((getGetAllCustomersMethod = CustomerVehicleServiceGrpcGrpc.getGetAllCustomersMethod) == null) {
          CustomerVehicleServiceGrpcGrpc.getGetAllCustomersMethod = getGetAllCustomersMethod =
              io.grpc.MethodDescriptor.<com.mycompany.grpc.EmptyRequest, com.mycompany.grpc.CustomerListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllCustomers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.grpc.EmptyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.grpc.CustomerListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CustomerVehicleServiceGrpcMethodDescriptorSupplier("GetAllCustomers"))
              .build();
        }
      }
    }
    return getGetAllCustomersMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CustomerVehicleServiceGrpcStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CustomerVehicleServiceGrpcStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CustomerVehicleServiceGrpcStub>() {
        @java.lang.Override
        public CustomerVehicleServiceGrpcStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CustomerVehicleServiceGrpcStub(channel, callOptions);
        }
      };
    return CustomerVehicleServiceGrpcStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CustomerVehicleServiceGrpcBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CustomerVehicleServiceGrpcBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CustomerVehicleServiceGrpcBlockingStub>() {
        @java.lang.Override
        public CustomerVehicleServiceGrpcBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CustomerVehicleServiceGrpcBlockingStub(channel, callOptions);
        }
      };
    return CustomerVehicleServiceGrpcBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CustomerVehicleServiceGrpcFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CustomerVehicleServiceGrpcFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CustomerVehicleServiceGrpcFutureStub>() {
        @java.lang.Override
        public CustomerVehicleServiceGrpcFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CustomerVehicleServiceGrpcFutureStub(channel, callOptions);
        }
      };
    return CustomerVehicleServiceGrpcFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getCustomerSummary(com.mycompany.grpc.CustomerRequest request,
        io.grpc.stub.StreamObserver<com.mycompany.grpc.CustomerSummaryResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCustomerSummaryMethod(), responseObserver);
    }

    /**
     */
    default void getVehicleSummary(com.mycompany.grpc.VehicleRequest request,
        io.grpc.stub.StreamObserver<com.mycompany.grpc.VehicleSummaryResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetVehicleSummaryMethod(), responseObserver);
    }

    /**
     * <pre>
     * Add the new RPC method here
     * </pre>
     */
    default void getAllCustomers(com.mycompany.grpc.EmptyRequest request,
        io.grpc.stub.StreamObserver<com.mycompany.grpc.CustomerListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllCustomersMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CustomerVehicleServiceGrpc.
   */
  public static abstract class CustomerVehicleServiceGrpcImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CustomerVehicleServiceGrpcGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CustomerVehicleServiceGrpc.
   */
  public static final class CustomerVehicleServiceGrpcStub
      extends io.grpc.stub.AbstractAsyncStub<CustomerVehicleServiceGrpcStub> {
    private CustomerVehicleServiceGrpcStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CustomerVehicleServiceGrpcStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CustomerVehicleServiceGrpcStub(channel, callOptions);
    }

    /**
     */
    public void getCustomerSummary(com.mycompany.grpc.CustomerRequest request,
        io.grpc.stub.StreamObserver<com.mycompany.grpc.CustomerSummaryResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCustomerSummaryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getVehicleSummary(com.mycompany.grpc.VehicleRequest request,
        io.grpc.stub.StreamObserver<com.mycompany.grpc.VehicleSummaryResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetVehicleSummaryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Add the new RPC method here
     * </pre>
     */
    public void getAllCustomers(com.mycompany.grpc.EmptyRequest request,
        io.grpc.stub.StreamObserver<com.mycompany.grpc.CustomerListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllCustomersMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CustomerVehicleServiceGrpc.
   */
  public static final class CustomerVehicleServiceGrpcBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CustomerVehicleServiceGrpcBlockingStub> {
    private CustomerVehicleServiceGrpcBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CustomerVehicleServiceGrpcBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CustomerVehicleServiceGrpcBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.mycompany.grpc.CustomerSummaryResponse getCustomerSummary(com.mycompany.grpc.CustomerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCustomerSummaryMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.mycompany.grpc.VehicleSummaryResponse getVehicleSummary(com.mycompany.grpc.VehicleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetVehicleSummaryMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Add the new RPC method here
     * </pre>
     */
    public com.mycompany.grpc.CustomerListResponse getAllCustomers(com.mycompany.grpc.EmptyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllCustomersMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CustomerVehicleServiceGrpc.
   */
  public static final class CustomerVehicleServiceGrpcFutureStub
      extends io.grpc.stub.AbstractFutureStub<CustomerVehicleServiceGrpcFutureStub> {
    private CustomerVehicleServiceGrpcFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CustomerVehicleServiceGrpcFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CustomerVehicleServiceGrpcFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mycompany.grpc.CustomerSummaryResponse> getCustomerSummary(
        com.mycompany.grpc.CustomerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCustomerSummaryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mycompany.grpc.VehicleSummaryResponse> getVehicleSummary(
        com.mycompany.grpc.VehicleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetVehicleSummaryMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Add the new RPC method here
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mycompany.grpc.CustomerListResponse> getAllCustomers(
        com.mycompany.grpc.EmptyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllCustomersMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_CUSTOMER_SUMMARY = 0;
  private static final int METHODID_GET_VEHICLE_SUMMARY = 1;
  private static final int METHODID_GET_ALL_CUSTOMERS = 2;

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
        case METHODID_GET_CUSTOMER_SUMMARY:
          serviceImpl.getCustomerSummary((com.mycompany.grpc.CustomerRequest) request,
              (io.grpc.stub.StreamObserver<com.mycompany.grpc.CustomerSummaryResponse>) responseObserver);
          break;
        case METHODID_GET_VEHICLE_SUMMARY:
          serviceImpl.getVehicleSummary((com.mycompany.grpc.VehicleRequest) request,
              (io.grpc.stub.StreamObserver<com.mycompany.grpc.VehicleSummaryResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_CUSTOMERS:
          serviceImpl.getAllCustomers((com.mycompany.grpc.EmptyRequest) request,
              (io.grpc.stub.StreamObserver<com.mycompany.grpc.CustomerListResponse>) responseObserver);
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
          getGetCustomerSummaryMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.mycompany.grpc.CustomerRequest,
              com.mycompany.grpc.CustomerSummaryResponse>(
                service, METHODID_GET_CUSTOMER_SUMMARY)))
        .addMethod(
          getGetVehicleSummaryMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.mycompany.grpc.VehicleRequest,
              com.mycompany.grpc.VehicleSummaryResponse>(
                service, METHODID_GET_VEHICLE_SUMMARY)))
        .addMethod(
          getGetAllCustomersMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.mycompany.grpc.EmptyRequest,
              com.mycompany.grpc.CustomerListResponse>(
                service, METHODID_GET_ALL_CUSTOMERS)))
        .build();
  }

  private static abstract class CustomerVehicleServiceGrpcBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CustomerVehicleServiceGrpcBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.mycompany.grpc.CustomerVehicleProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CustomerVehicleServiceGrpc");
    }
  }

  private static final class CustomerVehicleServiceGrpcFileDescriptorSupplier
      extends CustomerVehicleServiceGrpcBaseDescriptorSupplier {
    CustomerVehicleServiceGrpcFileDescriptorSupplier() {}
  }

  private static final class CustomerVehicleServiceGrpcMethodDescriptorSupplier
      extends CustomerVehicleServiceGrpcBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CustomerVehicleServiceGrpcMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CustomerVehicleServiceGrpcGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CustomerVehicleServiceGrpcFileDescriptorSupplier())
              .addMethod(getGetCustomerSummaryMethod())
              .addMethod(getGetVehicleSummaryMethod())
              .addMethod(getGetAllCustomersMethod())
              .build();
        }
      }
    }
    return result;
  }
}
