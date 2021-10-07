package com.javeriana.Game.controller;

import com.javeriana.Game.dto.AuthenticationDTO;

import com.javeriana.Game.model.User;
import com.javeriana.Game.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path="/user" ,consumes = "application/json;charset=utf-8")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<User> authenticate(@RequestBody AuthenticationDTO authenticationDTO){

        User user = userService.findUserByDocument(authenticationDTO.getUserDocument());
        if(user!=null)
            return new ResponseEntity<User>(user, HttpStatus.OK);
        else
            return new ResponseEntity( HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user){
        userService.addUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PutMapping("/updateUser/{userDocument}")
    public ResponseEntity<User> updateUser(@PathVariable String userDocument, @RequestBody User user){

        User userExists = userService.findUserByDocument( userDocument);

        if(userExists == null){
            log.info("User not found");
            return new ResponseEntity<User>( HttpStatus.NOT_FOUND);
        }
        User userUpdated = userService.updateUser(user);
        return new ResponseEntity<User>(userUpdated, HttpStatus.OK);


    }
}
