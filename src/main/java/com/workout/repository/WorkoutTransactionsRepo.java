package com.workout.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.workout.dao.WorkOutTransactions;

public interface WorkoutTransactionsRepo extends CrudRepository<WorkOutTransactions, Integer> {
	

	@Query("SELECT WT.txnId,WT.startTime,WT.stopTime,WT.duration,WT.calBurnt,WT.workout.workoutId FROM WorkOutTransactions WT WHERE WT.workout.workoutId= :workoutId")
	Iterable<WorkOutTransactions> findByWorkId(@Param("workoutId") Long workoutId);

}
