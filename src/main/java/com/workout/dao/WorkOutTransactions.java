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
		String TXNID = "TXNID";
		String START_TIME = "START_TIME";
		String STOP_TIME = "STOP_TIME";
		String DURATION = "DURATION";
		String CALSBURNT = "CALSBURNT";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = Table.TXNID)
	private Long txnId;

	@Column(name = Table.START_TIME)
	private java.time.LocalTime startTime;

	@Column(name = Table.STOP_TIME)
	private java.time.LocalDateTime stopTime;

	@Column(name = Table.DURATION)
	private java.time.LocalDateTime duration;
	
	@Column(name = Table.CALSBURNT)
	private Double calBurnt;

	public Double getCalBurnt() {
		return calBurnt;
	}

	public void setCalBurnt(Double calBurnt) {
		this.calBurnt = calBurnt;
	}

	public Long getTxnId() {
		return txnId;
	}

	public void setTxnId(Long txnId) {
		this.txnId = txnId;
	}

	public java.time.LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(java.time.LocalTime startTime) {
		this.startTime = startTime;
	}

	public java.time.LocalDateTime getStopTime() {
		return stopTime;
	}

	public void setStopTime(java.time.LocalDateTime stopTime) {
		this.stopTime = stopTime;
	}

	public java.time.LocalDateTime getDuration() {
		return duration;
	}

	public void setDuration(java.time.LocalDateTime duration) {
		this.duration = duration;
	}
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "workoutId")
	@JsonBackReference
	private WorkOut workout;
}
