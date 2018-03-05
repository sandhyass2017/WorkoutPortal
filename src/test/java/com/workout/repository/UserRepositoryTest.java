package com.workout.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.workout.dao.User;

@RunWith(SpringRunner.class)
public class UserRepositoryTest {
	private SessionFactory sessionFactory;

	private Session session = null;
 
	@Autowired
    private UserRepository repository;
	
	
	
	@MockBean
    private	User user;
    
    
    @Before

	public void before() {
    	Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(User.class);
		configuration.setProperty("hibernate.dialect",
				"org.hibernate.dialect.MySQL5Dialect");
		configuration.setProperty("hibernate.connection.driver_class",
				"com.mysql.jdbc.Driver");
		configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/workoutPortal");
		configuration.setProperty("hibernate.connection.username" , "root");
		configuration.setProperty("hibernate.connection.password" , "root");
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		user = new User((long)1, "password", "dfhf@cts.com");
		//session.save(user);
	}



	@Test
	public void testFindByEmailId() {
	    User response = repository.findOne(1);
	    assertNotNull(response);
	    assertEquals(user.getUserId(), response);
	}
	@After

	public void after() {

		session.close();

		sessionFactory.close();

	}

}
