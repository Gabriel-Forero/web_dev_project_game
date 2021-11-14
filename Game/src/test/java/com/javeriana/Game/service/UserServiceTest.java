package com.javeriana.Game.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ActiveProfiles;

import com.javeriana.Game.Utils;
import com.javeriana.Game.exceptions.UserNotFoundException;
import com.javeriana.Game.model.User;
import com.javeriana.Game.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ActiveProfiles("UnitTestUserService")
@SpringBootTest
@AutoConfigureMockMvc
class UserServiceTest {

	@MockBean
	private  UserRepository userRepo;

	@Autowired
	private UserService userService;

	@Test
	void findUserByDocumentCorrectly() {
		when(userRepo.findByDocument("1")).thenReturn(Utils.buildUser());

		User expected = Utils.buildUser();
		User response = userService.findUserByDocument("1");

		assertEquals(expected, response);
	}

	@Test
	void findUserByDocumentUserNotFound() {
		when(userRepo.findByDocument("2")).thenThrow( UserNotFoundException.class);

		EmptyResultDataAccessException response = assertThrows(EmptyResultDataAccessException.class, () ->{
			userService.findUserByDocument("2");
		});;

		assertEquals("com.javeriana.Game.exceptions.UserNotFoundException", response.getMessage());
	}

	@Test
	void updateUser() {


		when(userRepo.save(Utils.buildUser())).thenReturn(Utils.buildUser());
		User expected = Utils.buildUser();

		User response =  userService.updateUser(Utils.buildUser());

		assertEquals(expected, response);

	}

	@Test
	void updateUserNullUser() {

		User response = userService.updateUser(null);

		assertNull(response);
	}

	@Test
	void authenicationCorrect() {
		when(userRepo.findByDocument("1")).thenReturn(Utils.buildUser());

		User expected = Utils.buildUser();
		User response = userService.authenication("1","pass");

		assertEquals(expected, response);
	}

	@Test
	void authenicationThrowBadCredentials() {
		when(userRepo.findByDocument("1")).thenReturn(Utils.buildUser());

		EmptyResultDataAccessException expected = new EmptyResultDataAccessException("bad credentials", 1);
		EmptyResultDataAccessException response = assertThrows(EmptyResultDataAccessException.class,() ->{
																   userService.authenication("1","pass1");
															   });

		assertEquals("bad credentials",response.getMessage());
	}
}