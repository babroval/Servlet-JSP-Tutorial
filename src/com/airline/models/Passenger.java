package com.airline.models;

import java.util.Date;

public class Passenger {

	private String firstName;
	private String lastName;
	private Date birthDate;
	private Gender gender;
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Date getBirth() {
		return birthDate;
	}
	
	public void setBirth(Date birth) {
		this.birthDate = birth;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Passenger [firstName=" + firstName + ", lastName=" + lastName + ", birth=" + birthDate + ", gender="
				+ gender + "]";
	}
	
	
}
