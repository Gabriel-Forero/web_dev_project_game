package com.javeriana.Game;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.javeriana.Game.dto.AddUserDTO;
import com.javeriana.Game.dto.AuthenticationDTO;
import com.javeriana.Game.model.User;

public class Utils {


	public static User buildUser(){
		User user = new User();
		user.setUserId(1L);
		user.setUserPassword("pass");
		user.setUserDocument("123");
		user.setUserName("Pepe");
		user.setUserRole(User.UserRoles.CAPTAIN);
		return user;
	}

	public static AddUserDTO buildAddUserDTO(){
		AddUserDTO user = new AddUserDTO();
		user.setUserPassword("pass");
		user.setUserDocument("123");
		user.setUserName("Pepe");
		user.setUserRole(User.UserRoles.CAPTAIN);
		return user;
	}

	public static AuthenticationDTO buildAuthDTO(){
		AuthenticationDTO auth = new AuthenticationDTO();
		auth.setUserDocument("123");
		auth.setUserPassword("pass");
		return auth;
	}

	public static ResponseEntity<User> buildUserResponseEntity(){
		return new ResponseEntity<User>(buildUser(), HttpStatus.OK);
	}


}
