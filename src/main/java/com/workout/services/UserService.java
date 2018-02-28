package com.workout.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.workout.dao.User;
import com.workout.repository.UserRepository;

@Service
@Component
public class UserService {
	
	@Autowired
	private UserRepository  userRepo;
	
	
	public User createUser(User user) {
		userRepo.save(user);
		return user;

	}
	
	public Iterable<User> getUserList(){
		Iterable<User> userList=userRepo.findAll();
		return userList;
	}
	
	public Long authenticateUser(String userName, String password) {
		Long userId = userRepo.findByEmailId(userName);
		if (userId != null)
			return userId;
		return null;
	}

}
