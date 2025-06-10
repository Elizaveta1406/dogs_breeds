package ru.omgtu.ivt.service;

import ru.omgtu.ivt.model.Role;
import ru.omgtu.ivt.model.dto.AuthRequest;
import ru.omgtu.ivt.model.dto.AuthResponse;
import ru.omgtu.ivt.model.entity.User;
import ru.omgtu.ivt.repository.UserRepository;
import ru.omgtu.ivt.config.security.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(AuthRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
                .accessToken(jwtTokenUtil.generateToken(user))
                .role(user.getRole().name())
                .build();
    }

    public AuthResponse login(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow();

        return AuthResponse.builder()
                .accessToken(jwtTokenUtil.generateToken(user))
                .role(user.getRole().name())
                .build();
    }
}
