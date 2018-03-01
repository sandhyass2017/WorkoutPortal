package com.workout.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.gson.Gson;
import com.workout.WorkoutPortalApplication;
import com.workout.dao.WorkOut;
import com.workout.dao.WorkOutTransactions;
import com.workout.services.WorkoutTransactionService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = WorkoutPortalApplication.class)
@WebMvcTest(value = WorkOutTransactionController.class, secure = false)
public class WorkOutTransactionControllerTest {

	
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	WorkOutTransactionController workOutTransactionController;

	@MockBean
	WorkoutTransactionService workoutTxnService;
	
	WorkOut workout= new WorkOut((long)1, (double)123, "Jumping", null);
	//WorkOutTransactions workoutTxn= new WorkOutTransactions((long) 1,LocalDateTime.of(2018,03,12 , 9, 15), LocalDateTime.of(2018,03,12 , 11, 15),workout);
	WorkOutTransactions workoutTxn= new WorkOutTransactions((long) 1,LocalDateTime.now(), LocalDateTime.now(),workout);
			
	
	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.workOutTransactionController).build();
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testCalculateduration() throws Exception {
		given(workoutTxnService.updateWorkoutTxnDetails(Mockito.any(WorkOutTransactions.class))).willReturn(workoutTxn);
		String content = new Gson().toJson(workoutTxn);
		ResultActions result = mockMvc
          .perform(post("/workoutTxn").content(content).contentType(APPLICATION_JSON_UTF8))
          .andExpect(status().isOk());
		assertThat(result.andReturn().equals(workoutTxn));		
	}

}
