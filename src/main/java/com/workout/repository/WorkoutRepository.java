package com.workout.repository;

import org.springframework.data.repository.CrudRepository;

import com.workout.dao.WorkOut;

public interface WorkoutRepository extends CrudRepository<WorkOut, Integer> {

}
