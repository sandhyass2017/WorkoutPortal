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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "User")
public class User {
	
	private interface Table {
		String USERID = "USERID";
		String USERNAME = "USERNAME";
		String PASSWORD = "PASSWORD";
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = Table.USERID)
	private Long userId;

	@Column(name = Table.PASSWORD)
	private String password;

	@Column(name = Table.USERNAME, unique = true)
	private String userName;
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@OneToMany(
            mappedBy = "user",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    @JsonManagedReference    
    @JsonIgnore
    private List<WorkOut> workout = new ArrayList<>();
}
