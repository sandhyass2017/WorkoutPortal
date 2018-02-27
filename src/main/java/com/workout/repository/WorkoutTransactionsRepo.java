package com.workout.repository;

import org.springframework.data.repository.CrudRepository;

import com.workout.dao.WorkOutTransactions;

public interface WorkoutTransactionsRepo extends CrudRepository<WorkOutTransactions, Integer> {

}
