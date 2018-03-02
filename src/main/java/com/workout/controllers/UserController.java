package com.workout.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.workout.dao.User;
import com.workout.services.UserService;


@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public ResponseEntity<User> createUser(@RequestBody User userObj) {
        User user = userService.createUser(userObj);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ResponseEntity<String> login(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {

		ResponseEntity<String> response = null;
		Map<String, Object> message = new HashMap<String, Object>();
	  if (error != null) {
		  message.put("message","Invalid username and password!");
          message.put("Status", "Error");
          response = new ResponseEntity<String>(new Gson().toJson(message), HttpStatus.FORBIDDEN);
	  }

	  if (logout != null) {
		  message.put("message","You've been logged out successfully.");
          message.put("Status", "Success");
          response = new ResponseEntity<String>(new Gson().toJson(message), HttpStatus.OK);
	  }
	  message.put("message","User Authenticated Successfully.");
      message.put("Status", "Success");
      response = new ResponseEntity<String>(new Gson().toJson(message), HttpStatus.OK);

	  return response;

	}

}
