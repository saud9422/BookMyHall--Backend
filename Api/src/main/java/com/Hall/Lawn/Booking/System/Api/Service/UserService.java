package com.Hall.Lawn.Booking.System.Api.Service;

import com.Hall.Lawn.Booking.System.Api.DTO.RegisterRequest;
import com.Hall.Lawn.Booking.System.Api.DTO.UserDto;
import com.Hall.Lawn.Booking.System.Api.Entity.User;
import com.Hall.Lawn.Booking.System.Api.Enums.Role;
import com.Hall.Lawn.Booking.System.Api.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String saveUser(RegisterRequest request) {
        if (request.name() == null || request.email() == null || request.address() == null
                || request.phone() == null || request.password() == null) {
            return "Please fill all the fields";
        }

        if (userRepository.findByEmail(request.email()) != null) {
            return "Email already exists";
        }

        User user = new User();
        user.setName(request.name());
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setPhone(request.phone());
        user.setRole(Role.CONSUMER);
        user.setGender(request.gender());
        user.setAddress(request.address());

        User response = userRepository.save(user);
        return response != null ? "success" : "fail";
    }

    // Loads a user by email and returns it as a safe DTO (no password)
    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return null;
        }
        return new UserDto(user.getName(), user.getEmail(), user.getAddress(), user.getPhone(), user.getRole());
    }
}
