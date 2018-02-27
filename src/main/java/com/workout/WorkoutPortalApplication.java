package com.workout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class WorkoutPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkoutPortalApplication.class, args);
	}
}
