package com.example.candleshopapplication.security.services;

import com.example.candleshopapplication.model.User;
import com.example.candleshopapplication.model.enumeration.Role;
import com.example.candleshopapplication.repository.UserRepository;
import com.example.candleshopapplication.security.jwt.request.SignupRequest;
import com.example.candleshopapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService, UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }


    @Override
    public void register(SignupRequest signupRequest) {
        User user = new User(signupRequest.getUsername(),
                signupRequest.getName(),
                signupRequest.getSurname(),
                encoder.encode(signupRequest.getPassword()),
                Role.valueOf(signupRequest.getRole()),
                signupRequest.getAddress());
        userRepository.save(user);
    }

}
