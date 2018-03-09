package com.workout.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.workout.dao.WorkOut;
import com.workout.repository.UserRepository;
import com.workout.services.WorkoutService;

@RestController
@RequestMapping("/workout")
@CrossOrigin
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class WorkoutController {
	
	@Autowired
	private WorkoutService workoutService;
	
	
	@Autowired
	private UserRepository userRepo;
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<WorkOut> defineWorkout(@RequestBody WorkOut workout) {
		workout.getUser().setUserId(userRepo.findByEmailId(workout.getUser().getUserName()));
		WorkOut workoutDetail = workoutService.defineWorkout(workout);
        return new ResponseEntity<WorkOut>(workoutDetail, HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<WorkOut>> getWorkoutDetails() {
		List<WorkOut> workoutDetails = workoutService.getWorkoutDetails();
        return new ResponseEntity<List<WorkOut>>(workoutDetails, HttpStatus.OK);
    }

}
