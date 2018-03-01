package com.workout.controllers;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import static java.util.concurrent.TimeUnit.NANOSECONDS;
import com.workout.dao.WorkOutTransactions;
import com.workout.services.WorkoutTransactionService;


@RestController
@RequestMapping("/workoutTxn")
@CrossOrigin
public class WorkOutTransactionController {

	@Autowired
	private WorkoutTransactionService workoutTxnService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<WorkOutTransactions> calculateduration(@RequestBody WorkOutTransactions workoutTxn) {
		workoutTxn.setDuration(Duration.between(workoutTxn.getStartTime(), workoutTxn.getStopTime()));
		workoutTxn.setCalBurnt(calBurnt(workoutTxn.getDuration(), workoutTxn.getWorkout().getCalBurntPerUnitTime()));
		WorkOutTransactions workoutTxns = workoutTxnService.updateWorkoutDuration(workoutTxn);
		return new ResponseEntity<WorkOutTransactions>(workoutTxns, HttpStatus.OK);
	}

	public Double calBurnt(Duration duration, Double calBurntPerUnitTime) {
		long nanos = (long) duration.toNanos();
		Double calBurnt = (calBurntPerUnitTime) * (NANOSECONDS.toSeconds(nanos));
		return calBurnt;

	}
}
