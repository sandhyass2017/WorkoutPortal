package com.workout.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workout.dao.WorkOutTransactions;
import com.workout.repository.WorkoutTransactionsRepo;

@Service
public class WorkoutTransactionService {

	@Autowired
	private WorkoutTransactionsRepo workoutTransactionRepo;
	
	
	public WorkOutTransactions updateWorkoutTxnDetails(WorkOutTransactions workoutTransactions) {
		workoutTransactionRepo.save(workoutTransactions);
		return workoutTransactions;
	}
	
	public List<WorkOutTransactions> getWorkoutTxnDetails(Long workoutId) {
		List<WorkOutTransactions> workoutTxnList=workoutTransactionRepo.findByWorkId(workoutId);
		return workoutTxnList;
	}

}
