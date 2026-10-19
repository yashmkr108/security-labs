package com.yash.securitylabs.user.service;

import com.yash.securitylabs.user.dto.UserRequest;
import com.yash.securitylabs.user.dto.UserResponse;
import com.yash.securitylabs.user.enitity.User;
import com.yash.securitylabs.user.mapper.UserMapper;
import com.yash.securitylabs.user.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse createUser(UserRequest request) {
        Optional<User> existingUser = userRepository.findByEmail(request.email());
        if (existingUser.isPresent()) {
            throw new RuntimeException("User already exists with this email");
        }
        String hashedPassword = passwordEncoder.encode(request.password());
        User user = new User(request.email(), hashedPassword);
        User savedUser = userRepository.save(user);

        return userMapper.toResponse(
                savedUser,
                HttpStatus.CREATED.value(),
                Instant.now()
        );
    }
}
