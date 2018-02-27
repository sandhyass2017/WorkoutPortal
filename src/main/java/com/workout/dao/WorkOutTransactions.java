package com.workout.dao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "WorkoutTransactions")
public class WorkOutTransactions {

	private interface Table {
		String ID = "ID";
		String START_TIME = "START_TIME";
		String END_TIME = "END_TIME";
		String DURATION = "DURATION";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = Table.ID)
	private Long id;

	@Column(name = Table.START_TIME)
	private java.time.LocalTime startTime;

	@Column(name = Table.END_TIME)
	private java.time.LocalTime endTime;

	@Column(name = Table.DURATION)
	private java.time.LocalTime duration;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public java.time.LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(java.time.LocalTime startTime) {
		this.startTime = startTime;
	}

	public java.time.LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(java.time.LocalTime endTime) {
		this.endTime = endTime;
	}

	public java.time.LocalTime getDuration() {
		return duration;
	}

	public void setDuration(java.time.LocalTime duration) {
		this.duration = duration;
	}
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "workoutId")
	@JsonBackReference
	private WorkOut workout;
}
