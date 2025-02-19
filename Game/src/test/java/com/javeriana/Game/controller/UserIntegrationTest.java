package com.javeriana.Game.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import com.javeriana.Game.model.User;
import com.javeriana.Game.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ActiveProfiles("integration")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserIntegrationTest {

	@Autowired
	private TestRestTemplate rest;

	@LocalServerPort
	private int port;


	@Test
	void addUserIntegrationTest() {

		User user = rest.getForObject("http://localhost:"+port+"/user/findUserById/1", User.class);

		System.out.println(user.toString());
		assertNotNull(user);
		assertEquals("bvhnujc",user.getUserName());
		assertEquals("ztlewfs",user.getUserDocument());

	}


}
