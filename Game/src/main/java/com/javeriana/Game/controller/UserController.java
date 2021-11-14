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

    /**
     * Finds a user by id
     *
     * @param userId The user Identifier
     *
     * @return variable of {@link User} created
     */
    @GetMapping("/findUserById/{userId}")
    public ResponseEntity<User> findUserById(@PathVariable Long userId){

        User user = userService.findUserById(userId);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    /**
     * Finds a user by id
     *
     * @param userId The user Identifier
     *
     * @return variable of {@link User} found
     */
    @GetMapping("/findTeamByUserId/{userId}")
    public ResponseEntity<Team> findTeamByUserId(@PathVariable Long userId){

        User user = userService.findUserById(userId);
        return new ResponseEntity<Team>(user.getTeam(), HttpStatus.OK);
    }

    /**
     * Finds a user by document
     *
     * @param userDocument The user document
     *
     * @return variable of {@link Team} found
     */
    @GetMapping("/findTeamByUserDocument/{userDocument}")
    public ResponseEntity<Team> findTeamByUserDocument(@PathVariable String userDocument){

        User user = userService.findUserByDocument(userDocument);
        return new ResponseEntity<Team>(user.getTeam(), HttpStatus.OK);
    }

    /**
     * authenticates a user
     *
     * @param authenticationDTO The user document and password
     *
     * @return user {@link User} validated
     */
    @PostMapping("/login")
    public ResponseEntity<User> authenticate(@RequestBody AuthenticationDTO authenticationDTO){

        User user = userService.authenication(authenticationDTO.getUserDocument(), authenticationDTO.getUserPassword());
        if(user!=null)
            return new ResponseEntity<User>(user, HttpStatus.OK);
        else
            return new ResponseEntity( HttpStatus.NOT_FOUND);
    }

    /**
     * Finds a user by document
     *
     * @param userDocument The user Identifier
     *
     * @return variable of {@link User} found
     */
    @GetMapping("/findUserByDocument/{userDocument}")
    public ResponseEntity<User> findUserByDocument(@PathVariable String userDocument){

        User user = userService.findUserByDocument(userDocument);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    /**
     * CReates a user
     *
     * @param userDTO The user information to be created
     *
     * @return variable of {@link User} created
     */
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

    /**
     * Updates a user
     *
     * @param userId The user id
     * @param user The user information to be updated
     *
     * @return variable of {@link User} updated
     */
    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User user){

        User userExists = userService.findUserById(userId);

        if(userExists == null){
            return new ResponseEntity<User>( HttpStatus.NOT_FOUND);
        }
        user.setTeam(userExists.getTeam());
        User userUpdated = userService.updateUser(user);
        return new ResponseEntity<User>(userUpdated, HttpStatus.OK);
    }

    /**
     * find all users
     *
     * @return List of {@link User} found
     */
    @GetMapping("/findAllUsers")
    public ResponseEntity<List<User>> findAllUser(){
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    /**
     * Deletes a user
     *
     * @param userId The user id
     *
     */
    @DeleteMapping("/deleteUserById/{userId}")
    public ResponseEntity deleteUserById(@PathVariable Long userId){
        User userExists = userService.findUserById(userId);
        if (userExists == null){
            return new ResponseEntity( HttpStatus.NOT_FOUND);
        }
        userService.deleteUserById(userId);
        return new ResponseEntity( HttpStatus.OK);
    }
}
