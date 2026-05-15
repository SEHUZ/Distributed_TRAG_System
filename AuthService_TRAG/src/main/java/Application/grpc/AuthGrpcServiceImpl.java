/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application.grpc;

import com.mycompany.grpc.*; 
import Application.Service.AuthManager;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class AuthGrpcServiceImpl extends AuthServiceGrpcGrpc.AuthServiceGrpcImplBase {

    @Autowired
    private AuthManager authManager;

    @Override
    public void login(LoginRequest request, StreamObserver<AuthResponse> responseObserver) {
        String token = authManager.generateToken(request.getUsername(), "ROLE_USER");
        AuthResponse response = AuthResponse.newBuilder()
                .setToken(token)
                .setSuccess(true)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void validateToken(TokenRequest request, StreamObserver<ValidationResponse> responseObserver) {
        boolean isValid = authManager.validateToken(request.getToken());
        
        ValidationResponse response = ValidationResponse.newBuilder()
                .setIsValid(isValid) 
                .build();
                
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}