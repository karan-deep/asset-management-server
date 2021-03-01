package com.project.controller;

import com.project.model.User;
import com.project.response.ErrorResponse;
import com.project.response.TokenResponse;
import com.project.service.UserService;
import com.project.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

// Enabling cross-origin resource sharing
@CrossOrigin
// marking class UserController as RestController for creating Restful controllers, it also adds the @Controller and @ResponseBody annotations
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/api/authenticate")
    public ResponseEntity authenticateLogin(@RequestBody User user) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        } catch (BadCredentialsException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse("Invalid login credentials, Please try again."));
        } catch (InternalAuthenticationServiceException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse("Invalid login credentials, Please try again."));
        }
        UserDetails userDetails = userService
                .loadUserByUsername(user.getUsername());
        final String token = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new TokenResponse(token));
    }

    @PostMapping("/api/register")
    private ResponseEntity addAsset(@RequestBody User user) {
        if (userService.loadUserByUsername(user.getUsername()) != null) {
            return ResponseEntity.badRequest().body(new ErrorResponse("User already exist with the same email address."));
        }
        userService.addUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }
}
