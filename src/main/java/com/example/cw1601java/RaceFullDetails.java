package com.example.cw1601java;

import java.time.LocalDate;

public class RaceFullDetails extends RaceBaseDetails {
	private String Name;
	private int currentPoints;
	private int position;

	public RaceFullDetails(LocalDate date, String location, String Name, int currentPoints, int position) {
		super(date, location);
		this.Name = Name;
		this.currentPoints = currentPoints;
		this.position = position;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public int getCurrentPoints(){
		return currentPoints;
	}

	public void setCurrentPoints(int currentPoints) {
		this.currentPoints = currentPoints;
	}
	public int getPosition(){
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
}
