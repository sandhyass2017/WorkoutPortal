package com.workout.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	/*@RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseEntity<String> authenticateUser(@RequestHeader("userName") String userName,
                                                   @RequestHeader("password") String password) {

        ResponseEntity<String> response = null;
        Long userId = userService.authenticateUser(userName, password);
        Map<String, Object> message = new HashMap<String, Object>();
        if (userId != null) {
            message.put("message", "User Authenticated Successfully.");
            message.put("userId", userId);
            message.put("Status", "Sucess");
            response = new ResponseEntity<String>(new Gson().toJson(message), HttpStatus.OK);
        } else {
            message.put("message", "Invalid User Credentails.");
            message.put("Status", "Error");
            response = new ResponseEntity<String>(new Gson().toJson(message), HttpStatus.FORBIDDEN);
        }

        return response;
    }*/
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	 public String login(Model model, String error, String logout) {
	 if (error != null)
	 model.addAttribute("error", "Your username and password is invalid.");

	 if (logout != null)
	 model.addAttribute("message", "You have been logged out successfully.");

	 return "login";
	 }

}
