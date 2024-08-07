package com.ynov.webfullstack.back.Service;

import com.ynov.webfullstack.back.Exceptions.AuthenticationFailedException;
import com.ynov.webfullstack.back.Exceptions.UserAlreadyExistsException;
import org.springframework.security.core.AuthenticationException;
import com.ynov.webfullstack.back.Models.DTO.LoginUserDto;
import com.ynov.webfullstack.back.Models.DTO.RegisterUserDto;
import com.ynov.webfullstack.back.Models.Utilisateur;
import com.ynov.webfullstack.back.Repositories.UtilisateurRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UtilisateurRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UtilisateurRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Utilisateur signup(RegisterUserDto input) {
        Utilisateur UserFound = userRepository.findByEmail(input.getEmail()).orElse(null);
        if (UserFound != null) {
            throw new UserAlreadyExistsException("User already exists");
        }
        Utilisateur user = new Utilisateur();
        user.setNom(input.getNom());
        user.setPrenom(input.getPrenom());
        user.setEmail(input.getEmail());
        user.setMdp(passwordEncoder.encode(input.getPassword()));

        return userRepository.save(user);
    }

    public Utilisateur authenticate(LoginUserDto input) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            input.getEmail(),
                            input.getPassword()
                    )
            );
        } catch (AuthenticationException e) {
            throw new AuthenticationFailedException("Invalid email or password");
        }
        return userRepository.findByEmail(input.getEmail())
                .orElseThrow(() -> new AuthenticationFailedException("User not found after authentication"));

    }
}
