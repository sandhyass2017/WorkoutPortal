package com.workout.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.workout.dao.User;
import com.workout.dao.WorkOut;
import com.workout.dao.WorkOutTransactions;
import com.workout.repository.WorkoutTransactionsRepo;

public class WorkoutTransactionServiceTest {
	
	@InjectMocks
    private WorkoutTransactionService service;

    @Mock
    private WorkoutTransactionsRepo repository;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    WorkOut workout= new WorkOut((long)1, (double)123, "Jumping", null);
	//WorkOutTransactions workoutTxn= new WorkOutTransactions((long) 1,LocalDateTime.of(2018,03,12 , 9, 15), LocalDateTime.of(2018,03,12 , 11, 15),workout);
	WorkOutTransactions workoutTxn= new WorkOutTransactions((long) 1,LocalDateTime.now(), LocalDateTime.now(),workout);

	@Test
	public void testUpdateWorkoutDuration() {
		when(repository.save(workoutTxn)).thenReturn(workoutTxn);
		WorkOutTransactions respose=service.updateWorkoutTxnDetails(workoutTxn);
		assertThat(respose.equals(workoutTxn));
	}

}
