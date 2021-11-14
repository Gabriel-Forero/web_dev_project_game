package com.javeriana.Game.controller;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;


import com.javeriana.Game.model.User;
import com.javeriana.Game.service.UserService;
import com.javeriana.Game.Utils;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ActiveProfiles("UnitTestUserController")
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

	@MockBean
	private UserService userService;

	@Autowired
	private UserController userController;
	@Test
	void findUserByIdNotnull() {
		when(userService.findUserById(1L)).thenReturn(Utils.buildUser());

		ResponseEntity<User> response = userController.findUserById(1L);

		assertNotNull(response);
	}

	@Test
	void findUserByIdEquals() {
		when(userService.findUserById(1L)).thenReturn(Utils.buildUser());

		ResponseEntity<User> expected = Utils.buildUserResponseEntity();
		ResponseEntity<User> response = userController.findUserById(1L);

		assertEquals(expected, response);

	}

	@Test
	void authenticateOk() {

		when(userService.authenication("1","pass")).thenReturn(Utils.buildUser());

		ResponseEntity<User> response = userController.authenticate(Utils.buildAuthDTO());

		assertNotNull(response);
	}


	@Test
	void updateUserCorrectly() {

		when(userService.updateUser(Utils.buildUser())).thenReturn(Utils.buildUser());
		when(userService.findUserById(1L)).thenReturn(Utils.buildUser());

		ResponseEntity<User> expected = Utils.buildUserResponseEntity();

		ResponseEntity<User> response = userController.updateUser(1L,Utils.buildUser());

		assertEquals(expected, response);
	}

	@Test
	void updateUserUserDoesNotExist() {

		when(userService.findUserById(1L)).thenReturn(null);

		ResponseEntity<User> expected = new ResponseEntity<User>( HttpStatus.NOT_FOUND);

		ResponseEntity<User> response = userController.updateUser(1L,Utils.buildUser());

		assertEquals(expected, response);
	}

}