package com.javeriana.Game.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import com.javeriana.Game.model.User;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserIntegrationTest {

	@Autowired
	private TestRestTemplate rest;

	@LocalServerPort
	private int port;
	@Test
	void addUserIntegrationTest() {

		User user = rest.getForObject("http://localhost:"+port+"/findUserByDocument/nbpqnx", User.class);

		assertNotNull(user);
	}


}
