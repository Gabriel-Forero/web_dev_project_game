package com.javeriana.Game.controller;

import java.util.List;

import com.javeriana.Game.dto.AddUserDTO;
import com.javeriana.Game.dto.AuthenticationDTO;

import com.javeriana.Game.model.Team;
import com.javeriana.Game.model.User;
import com.javeriana.Game.service.TeamService;
import com.javeriana.Game.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path="/user")
public class UserController {

    private final UserService userService;
    private final TeamService teamService;

    public UserController(UserService userService, TeamService teamService) {
        this.userService = userService;
        this.teamService = teamService;
    }

    @GetMapping("/findUserById/{userId}")
    public ResponseEntity<User> findUserById(@PathVariable Long userId){

        User user = userService.findUserById(userId);
        return new ResponseEntity<User>(user, HttpStatus.OK);
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
    public ResponseEntity<User> addUser(@RequestBody AddUserDTO userDTO){

        Team team =  null;
        if(!userDTO.getUserAdmin()){
            log.info("it is not admin");
            team = teamService.findByTeamId(userDTO.getTeamId());
            if(team == null){
                log.info("team not found");
                return new ResponseEntity( HttpStatus.OK);
            }
        }
        userDTO.setTeam(team);
        User user =userService.addUser(userDTO);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User user){

        User userExists = userService.findUserById(userId);

        if(userExists == null){
            log.info("User not found");
            return new ResponseEntity<User>( HttpStatus.NOT_FOUND);
        }
        user.setTeam(userExists.getTeam());
        User userUpdated = userService.updateUser(user);
        return new ResponseEntity<User>(userUpdated, HttpStatus.OK);
    }

    @GetMapping("/findAllUsers")
    public ResponseEntity<List<User>> findAllUser(){
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
}
