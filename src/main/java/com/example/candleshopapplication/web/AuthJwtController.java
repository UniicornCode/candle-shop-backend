package com.example.candleshopapplication.web;

import com.example.candleshopapplication.repository.UserRepository;
import com.example.candleshopapplication.security.jwt.JwtUtils;
import com.example.candleshopapplication.security.jwt.request.LoginRequest;
import com.example.candleshopapplication.security.jwt.request.SignupRequest;
import com.example.candleshopapplication.security.jwt.response.JwtResponse;
import com.example.candleshopapplication.security.jwt.response.MessageResponse;
import com.example.candleshopapplication.security.services.UserDetailsImpl;
import com.example.candleshopapplication.security.services.UserDetailsServiceImpl;
import com.example.candleshopapplication.service.ShoppingCartService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthJwtController {

    private final AuthenticationManager authenticationManager;
    private final ShoppingCartService shoppingCartService;
    private final UserDetailsServiceImpl userDetailsService;
    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;


    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getRole().toString(),
                userDetails.getAddress()));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }
        shoppingCartService.create(signUpRequest.getUsername());
        userDetailsService.register(signUpRequest);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
