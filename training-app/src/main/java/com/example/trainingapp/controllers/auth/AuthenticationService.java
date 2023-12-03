package com.example.trainingapp.controllers.auth;


import com.example.trainingapp.config.JwtService;
import com.example.trainingapp.controllers.NormalUserController;
import com.example.trainingapp.entities.NormaluserEntity;
import com.example.trainingapp.entities.PremiumuserEntity;
import com.example.trainingapp.entities.enums.Role;
import com.example.trainingapp.services.functionality.UserService.PremiumUserSerivice;
import com.example.trainingapp.services.functionality.UserService.UserService;
import com.example.trainingapp.services.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final PremiumUserSerivice premiumUserSerivice;
    private static final Logger logger = LoggerFactory.getLogger(NormalUserController.class);

    public AuthenticationResponse register(RegisterRequest request) {
        var user = NormaluserEntity.builder().firstName(request.getFirstname()).lastName(request.getLastname()).email(request.getEmail()).password(passwordEncoder.encode(request.getPassword())).birthDate(request.getBirthDate()).height(request.getHeight()).weight(request.getWeight()).palfactor(request.getPalfactor()).sex(request.isSex()).role(Role.USER).build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse updateToPremium() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        String email = ((NormaluserEntity) principal).getEmail();
        NormaluserEntity user = userService.findByEmail(email);
        PremiumuserEntity premiumuserEntity =(PremiumuserEntity)user;
        user.setRole(Role.PREMIUMUSER);
        premiumUserSerivice.save(premiumuserEntity);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticatedRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(), request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(jwtToken).build();

    }
}
