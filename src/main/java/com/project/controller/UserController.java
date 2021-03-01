package com.project.controller;

import com.project.service.UserService;
import org.springframework.web.bind.annotation.*;

// Enabling cross-origin resource sharing
@CrossOrigin
// marking class UserController as RestController for creating Restful controllers, it also adds the @Controller and @ResponseBody annotations
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/register")
    private ResponseEntity addAsset(@RequestBody User user) {
        if(userService.loadUserByUsername(user.getUsername())!=null){
            return ResponseEntity.badRequest().body(new ErrorResponse("User already exist with the same email address."));
        }
        userService.addUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }
}
