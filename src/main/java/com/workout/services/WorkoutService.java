package com.workout.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workout.dao.WorkOut;
import com.workout.repository.WorkoutRepository;

@Service
public class WorkoutService {

	@Autowired
	private WorkoutRepository workoutRepo;
	
	public WorkOut defineWorkout(WorkOut workout) {
		workoutRepo.save(workout);
		return workout;

	}
	
	public Iterable<WorkOut> getWorkoutDetails(Long userId){
		Iterable<WorkOut> userList=workoutRepo.findByUserId(userId);
		return userList;
	}
}
