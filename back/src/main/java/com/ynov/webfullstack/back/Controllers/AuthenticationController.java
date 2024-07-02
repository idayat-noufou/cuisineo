package com.ynov.webfullstack.back.Controllers;

import com.ynov.webfullstack.back.Models.DTO.LoginUserDto;
import com.ynov.webfullstack.back.Models.DTO.RegisterUserDto;
import com.ynov.webfullstack.back.Models.Response.LoginResponse;
import com.ynov.webfullstack.back.Models.Utilisateur;
import com.ynov.webfullstack.back.Service.AuthenticationService;
import com.ynov.webfullstack.back.Service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Utilisateur> register(@RequestBody RegisterUserDto registerUserDto) {
        try {
            Utilisateur registeredUser = authenticationService.signup(registerUserDto);
            return ResponseEntity.ok(registeredUser);
        } catch (Exception e) {
            return ResponseEntity.status(409).build();
        }

    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        Utilisateur authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse;
        loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        Utilisateur jwtUser = new Utilisateur();
        jwtUser.setId(authenticatedUser.getId());
        jwtUser.setEmail(authenticatedUser.getEmail());
        jwtUser.setNom(authenticatedUser.getNom());
        jwtUser.setPrenom(authenticatedUser.getPrenom());
        loginResponse.setUser(jwtUser);

        return ResponseEntity.ok(loginResponse);
    }

    @GetMapping("/test")
    public String test() {
        System.out.println("Test");
        return "Hello!";
    }
}
