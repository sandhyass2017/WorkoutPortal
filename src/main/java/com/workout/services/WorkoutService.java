package com.workout.services;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<WorkOut> getWorkoutDetails(Long userId){
		List<WorkOut> workouList = new ArrayList<>();
		workouList = workoutRepo.findByUserId(userId);
		return workouList;
	}
}
