package com.project.earthquake.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat.Features;


public class Earthquake {
    private String country;
    private String place;
    private double magnitude;
    private LocalDateTime time;
    private Properties properties;
	
	
	public Earthquake(String country, String place, double magnitude, LocalDateTime time, Properties properties
		) {
		super();
		this.country = country;
		this.place = place;
		this.magnitude = magnitude;
		this.time = time;
		this.properties = properties;
		
		
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public double getMagnitude() {
		return magnitude;
	}
	public void setMagnitude(double magnitude) {
		this.magnitude = magnitude;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	
	
    
    
    
}