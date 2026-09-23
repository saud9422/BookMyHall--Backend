package com.Hall.Lawn.Booking.System.Api.Controller;

import com.Hall.Lawn.Booking.System.Api.DTO.LoginRequest;
import com.Hall.Lawn.Booking.System.Api.DTO.RegisterRequest;
import com.Hall.Lawn.Booking.System.Api.DTO.UserDto;
import com.Hall.Lawn.Booking.System.Api.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/auth/")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SecurityContextRepository securityContextRepository;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequest request) {
        String response = userService.saveUser(request);
        if ("success".equals(response)) {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequest request, HttpServletResponse Httpresp, HttpServletRequest Httpreq) {
     Authentication athentication=  authenticationManager.authenticate(
             new UsernamePasswordAuthenticationToken(request.email(),request.password()));

     SecurityContext context= SecurityContextHolder.createEmptyContext();
      context.setAuthentication(athentication);
      SecurityContextHolder.setContext(context);

      securityContextRepository.saveContext(context,Httpreq,Httpresp);

        if(athentication.isAuthenticated()){
            return ResponseEntity.status(HttpStatus.OK).body("Login Successful");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login Failed");
    }

    @GetMapping("/profile")
    public ResponseEntity<UserDto> getProfile(@AuthenticationPrincipal UserDetails userDetails){
        String email = userDetails.getUsername();
        UserDto userDto = userService.getUserByEmail(email);
        if (userDto == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(userDto);
        }

    }

}
