package com.example.trainingapp.controllers.auth;

import com.example.trainingapp.entities.NormaluserEntity;
import com.example.trainingapp.services.functionality.UserService.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*")

public class AuthenticationController {
    private final AuthenticationService service;
    @GetMapping("/hello")
    public ResponseEntity<String> register(){
        return ResponseEntity.ok("milus");
    }



    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest  request){
    return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticatedRequest  request){
        return ResponseEntity.ok(service.authenticate(request));

    }


}
