package com.javeriana.Game.service;
import com.javeriana.Game.dto.AddUserDTO;
import com.javeriana.Game.exceptions.UserNotFoundException;
import com.javeriana.Game.model.User;
import com.javeriana.Game.repository.UserRepository;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepo;

    public  UserService(UserRepository userRepo) {
        this.userRepo=userRepo;
    }

    public User addUser(AddUserDTO userDTO) {

        User user =  new User();
        user.setTeam(userDTO.getTeam());
        user.setUserRole(userDTO.getUserRole());
        user.setUserName(userDTO.getUserName());
        user.setUserAdmin(userDTO.getUserAdmin());
        user.setUserDocument(userDTO.getUserDocument());
        user.setUserPassword(userDTO.getUserPassword());
        return userRepo.save(user);
    }

    public List<User> findAllUsers(){
        return userRepo.findAll();
    }

    public User updateUser(User user) {

        if( user != null){
            log.info("user {} updated",user.toString());
            return userRepo.save(user);
        }
        return null;

    }

    public void deleteUserById(Long id) {
        userRepo.deleteById(id);
    }

    public User findUserByDocument(String document) {
        try {
            return userRepo.findByDocument(document);
        }
        catch (UserNotFoundException u){
            log.error(String.valueOf(u));
            throw new EmptyResultDataAccessException(String.valueOf(u), 1);
        }
    }

    public User authenication(String document, String password){

        try {

            User user=  userRepo.findByDocument(document);
            if(password.equals(user.getUserPassword())){
                return user;
            }
            throw new EmptyResultDataAccessException("bad credentials", 1);
        }
        catch (UserNotFoundException u){
            log.error(String.valueOf(u));
            throw new EmptyResultDataAccessException(String.valueOf(u), 1);
        }
    }

    public User findUserById(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User not by id: " + id +" not found"));
    }

}
