package net.bgsystems.sku.web.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.bgsystems.util.ReflectionUtils;
import net.bgsystems.util.web.User;

@RestController
@RequestMapping("app")
public class AppController {
	
	@Autowired
	private User sessionUser;

	@GetMapping("currentUser")
	public ResponseEntity<User> currentUser() throws Throwable {
		return new ResponseEntity<User>(ReflectionUtils.copy(sessionUser, User.class, true), HttpStatus.OK);
	}
}
