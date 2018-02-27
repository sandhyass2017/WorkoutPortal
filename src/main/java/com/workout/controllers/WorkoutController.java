package com.workout.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.workout.dao.WorkOut;
import com.workout.services.WorkoutService;

@RestController
@RequestMapping("/workout")
@CrossOrigin
public class WorkoutController {
	
	@Autowired
	private WorkoutService workoutService;
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<WorkOut> defineWorkout(@RequestBody WorkOut workout) {
		WorkOut workoutDetail = workoutService.defineWorkout(workout);
        return new ResponseEntity<WorkOut>(workoutDetail, HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.GET, value="{userId}")
	public ResponseEntity<Iterable<WorkOut>> getWorkoutDetails(@PathVariable Long userId) {
		Iterable<WorkOut> workoutDetails = workoutService.getWorkoutDetails(userId);
        return new ResponseEntity<Iterable<WorkOut>>(workoutDetails, HttpStatus.OK);
    }

}
