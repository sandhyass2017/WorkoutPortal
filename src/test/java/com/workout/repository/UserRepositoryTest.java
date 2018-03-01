package com.workout.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.workout.WorkoutPortalApplication;
import com.workout.dao.User;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = WorkoutPortalApplication.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private UserRepository repository;

	@Test
	public void testFindByEmailId() {
		
		User user = new User((long)1, "password", "sandy@cts.com");
		
		entityManager.persist(user);
	    entityManager.flush();
	    
	    Long response = repository.findByEmailId(user.getUserName());
	    assertEquals(user.getUserId(), response);
		
	}

}
