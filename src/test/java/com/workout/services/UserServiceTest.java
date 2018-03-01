package com.workout.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.workout.dao.User;
import com.workout.repository.UserRepository;

public class UserServiceTest {
	
	
	@InjectMocks
    private UserService service;

    @Mock
    private UserRepository repository;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    User sampleUser = new User((long) 1, "password", "userName");
    

	@Test
	public void testCreateUser() {
		when(repository.save(sampleUser)).thenReturn(sampleUser);
		User respose=service.createUser(sampleUser);
		assertThat(respose.equals(sampleUser));
	}


	@Test
	public void testAuthenticateUser() {
		when(repository.findByEmailId(sampleUser.getUserName())).thenReturn(sampleUser.getUserId());
		long respose=service.authenticateUser(sampleUser.getUserName(),sampleUser.getPassword());
		assertThat(respose);
	}

}
