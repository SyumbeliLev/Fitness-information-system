package ru.ithub.fitness.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.ithub.fitness.dto.UserDto;
import ru.ithub.fitness.entity.User;
import ru.ithub.fitness.mapper.UserMapper;
import ru.ithub.fitness.repository.UserRepository;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto registration(UserDto dto) {
        if (userRepository.existsByEmail(dto.getEmail()) || userRepository.existsByPhone(dto.getPhone())) {
            throw new RuntimeException("Already exists");
        }

        User newUser = userMapper.toEntity(dto);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));

        return userMapper.toDto(userRepository.save(newUser));
    }
}
