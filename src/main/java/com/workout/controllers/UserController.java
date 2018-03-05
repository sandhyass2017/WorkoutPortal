package com.workout.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<String> createUser(@RequestBody User userObj) {
		Map<String, Object> message = new HashMap<String, Object>();
		Long userExists = userService.findByUserName(userObj);
		ResponseEntity<String> response = null;
		if (userExists != null) {
			message.put("message", "There is already a user registered with the email provided!");
			message.put("Status", "Error");
			response = new ResponseEntity<String>(new Gson().toJson(message), HttpStatus.FORBIDDEN);
		} else {
			userService.createUser(userObj);
			message.put("message", "User has been registered successfully!");
			message.put("Status", "Success");
			response = new ResponseEntity<String>(new Gson().toJson(message), HttpStatus.OK);
		}
		return response;
	}

	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public ResponseEntity<String> login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ResponseEntity<String> response = null;
		Map<String, Object> message = new HashMap<String, Object>();
		if (error != null) {
			message.put("message", "Invalid username and password!");
			message.put("Status", "Error");
			response = new ResponseEntity<String>(new Gson().toJson(message), HttpStatus.FORBIDDEN);
		} else {
			message.put("message", "User Authenticated Successfully.");
			message.put("Status", "Success");
			response = new ResponseEntity<String>(new Gson().toJson(message), HttpStatus.OK);
		}

		if (logout != null) {
			message.put("message", "You've been logged out successfully.");
			message.put("Status", "Success");
			response = new ResponseEntity<String>(new Gson().toJson(message), HttpStatus.OK);
		}
		return response;

	}

}
