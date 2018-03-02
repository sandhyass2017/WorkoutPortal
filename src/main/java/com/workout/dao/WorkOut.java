package com.workout.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Workout")
public class WorkOut {

	private interface Table {
		String WORKOUT_ID = "WORKOUT_ID";
		String TITLE = "TITLE";
		String CALBURNTPERUNITTIME = "CALBURNTPERUNITTIME";
		String UNIT_TIME = "UNIT_TIME";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = Table.WORKOUT_ID)
	private Long workoutId;

	@Column(name = Table.TITLE)
	private String title;

	@Column(name = Table.CALBURNTPERUNITTIME)
	private Double calBurntPerUnitTime;

	@Enumerated(EnumType.STRING)
	@Column(name = Table.UNIT_TIME)
	private UnitTime unitTime;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	@JsonManagedReference
	private User user;

	public WorkOut() {
		super();
	}

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

	public UnitTime getUnitTime() {
		return unitTime;
	}

	public void setUnitTime(UnitTime unitTime) {
		this.unitTime = unitTime;
	}

	public Double getCalBurntPerUnitTime() {
		return calBurntPerUnitTime;
	}

	public void setCalBurntPerUnitTime(Double calBurntPerUnitTime) {
		this.calBurntPerUnitTime = calBurntPerUnitTime;
	}

	/*@OneToMany(mappedBy = "txnId", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, orphanRemoval = true)
	@JsonManagedReference
	@JsonIgnore
	private List<WorkOutTransactions> workoutTransactions = new ArrayList<>();*/

	public WorkOut(Long workoutId, Double calBurntPerUnitTime, String title, UnitTime unitTime) {
		super();
		this.workoutId = workoutId;
		this.calBurntPerUnitTime = calBurntPerUnitTime;
		this.title = title;
		this.unitTime = unitTime;
	}

	public WorkOut(Long workoutId, Double calBurntPerUnitTime, String title, UnitTime unitTime, User user) {
		super();
		this.workoutId = workoutId;
		this.title = title;
		this.calBurntPerUnitTime = calBurntPerUnitTime;
		this.unitTime = unitTime;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
