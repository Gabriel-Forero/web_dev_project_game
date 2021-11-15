package com.javeriana.Game.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import com.javeriana.Game.Utils;
import com.javeriana.Game.model.User;
import com.javeriana.Game.service.UserService;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControlerIntegrationTest {

	@Autowired
	private UserController userController;

	@Test
	void addUserIntegrationTest() {

		ResponseEntity<User> response = userController.addUser(Utils.buildAddUserDTO());

		assertNotNull(response);
	}


}
