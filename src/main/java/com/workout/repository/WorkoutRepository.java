package com.workout.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.workout.dao.WorkOut;

public interface WorkoutRepository extends CrudRepository<WorkOut, Integer> {
	
	@Query("SELECT WO.workoutId,WO.calBurntPerUnitTime,WO.title,WO.unitTime,WO.user.userName FROM WorkOut WO US WHERE WO.user.userId= :userId")
	Iterable<WorkOut> findByUserId(@Param("userId") Long userId);

}
