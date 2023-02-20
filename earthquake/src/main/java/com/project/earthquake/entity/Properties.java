package com.project.earthquake.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Properties extends Earthquake{

	public Properties(String country, String place, double magnitude, LocalDateTime time, Properties properties) {
		super(country, place, magnitude, time, properties);
		
	}


/*
    private String place;
    private double mag;
    private Date time;
	public Properties(String place, double mag, Date time) {
		super(place);
		this.place = place;
		this.mag = mag;
		this.time = time;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public double getMag() {
		return mag;
	}
	public void setMag(double mag) {
		this.mag = mag;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
   */ 
    
    
	
}