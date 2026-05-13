/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grpc;

import com.mycompany.grpc.*; 
import Service.AuthManager;
import io.grpc.stub.StreamObserver;
import io.jsonwebtoken.Claims;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author chris
 */
@GrpcService
public class AuthGrpcServiceImpl extends AuthServiceGrpcGrpc.AuthServiceGrpcImplBase {

    @Autowired
    private AuthManager authManager;

    @Override
    public void login(LoginRequest request, StreamObserver<AuthResponse> responseObserver) {
        boolean isValid = request.getUsername().equals("admin") && request.getPassword().equals("1234");
        
        AuthResponse.Builder response = AuthResponse.newBuilder();
        if (isValid) {
            String token = authManager.generateToken(request.getUsername(), "ROLE_ADMIN");
            response.setSuccess(true).setToken(token).setRole("ROLE_ADMIN").setMessage("OK");
        } else {
            response.setSuccess(false).setMessage("Credenciales incorrectas");
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void validateToken(TokenRequest request, StreamObserver<ValidationResponse> responseObserver) {
        Claims claims = authManager.validateToken(request.getToken());
        ValidationResponse.Builder response = ValidationResponse.newBuilder();
        if (claims != null) {
            response.setIsValid(true).setUserId(claims.getSubject()).setRole(claims.get("role", String.class));
        } else {
            response.setIsValid(false);
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}