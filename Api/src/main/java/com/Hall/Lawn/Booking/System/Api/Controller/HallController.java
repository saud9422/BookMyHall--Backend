package com.Hall.Lawn.Booking.System.Api.Controller;

import com.Hall.Lawn.Booking.System.Api.Entity.Halls;
import com.Hall.Lawn.Booking.System.Api.Entity.User;
import com.Hall.Lawn.Booking.System.Api.Exception.UserNotFoundException;
import com.Hall.Lawn.Booking.System.Api.Repository.UserRepository;
import com.Hall.Lawn.Booking.System.Api.Service.HallService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hall")
public class HallController {
    private final HallService hallService;
    private final UserRepository userRepository;
    public HallController(HallService hallService,UserRepository userRepository) {
        this.hallService = hallService;
        this.userRepository = userRepository;
    }

    @GetMapping("/get")
    public Halls getHallById(@RequestParam long hallId) {

        return hallService.getHallById(hallId);
    }

    @GetMapping("/all")
    public List<Halls> findAllHalls() {
        return hallService.getAllHalls();
    }

    @PostMapping(value = "/save",
    consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Halls save(@RequestPart("hall") Halls hall,
                               @RequestPart(value = "images", required = false)List<MultipartFile> images ,
                               Authentication authentication) throws IOException {
        String username = authentication.getName();
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UserNotFoundException("No user found with email: " + username);
        } else {
          return hallService.addHall(hall,images,user);
        }
    }

}
