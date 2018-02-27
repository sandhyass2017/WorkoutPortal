package com.workout.controllers;

import java.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.workout.dao.WorkOutTransactions;
import com.workout.services.WorkoutTransactionService;

public class WorkOutTransactionController {
	
	@Autowired
	private WorkoutTransactionService workoutTxnService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<WorkOutTransactions> calculateduration(@RequestBody WorkOutTransactions workoutTxn) {
		workoutTxn.setDuration(Duration.between(workoutTxn.getStartTime(),workoutTxn.getStopTime()));
		workoutTxn.setCalBurnt(calBurnt(workoutTxn.getDuration(),workoutTxn.getWorkout().getWorkoutId()));
		WorkOutTransactions workoutTxns = workoutTxnService.updateWorkoutDuration(workoutTxn);
        return new ResponseEntity<WorkOutTransactions>(workoutTxns, HttpStatus.OK);
    }

	public Double calBurnt(Duration duration,Long workId) {
		// Double calBurnt=workId * duration;
		
		return null;
		
	}
}
