package com.workout.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Workout")
public class WorkOut {

	private interface Table {
		String WORKOUT_ID = "WORKOUT_ID";
		String TITLE = "TITLE";
		String CALBURNTPERUNITTIME="CALBURNTPERUNITTIME";
		String UNIT_TIME = "UNIT_TIME";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = Table.WORKOUT_ID)
	private Long workoutId;

	@Column(name = Table.TITLE)
	private String calBurntPerUnitTime;
	
	@Column(name = Table.CALBURNTPERUNITTIME)
	private String title;
	

	@Column(name = Table.UNIT_TIME)
	private String unitTime;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "userId")
	@JsonBackReference
	private User user;

	public Long getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(Long workoutId) {
		this.workoutId = workoutId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUnitTime() {
		return unitTime;
	}

	public void setUnitTime(String unitTime) {
		this.unitTime = unitTime;
	}
	
	public String getCalBurntPerUnitTime() {
		return calBurntPerUnitTime;
	}

	public void setCalBurntPerUnitTime(String calBurntPerUnitTime) {
		this.calBurntPerUnitTime = calBurntPerUnitTime;
	}
	@OneToMany(
            mappedBy = "id",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    @JsonManagedReference    
    @JsonIgnore
    private List<WorkOutTransactions> workoutTransactions = new ArrayList<>();
}
