package com.example.cw1601java;

import java.time.LocalDate;

public class RaceBaseDetails {
	private LocalDate date;
	private String location;

	public RaceBaseDetails(LocalDate date, String location) {
		this.date = date;
		this.location = location;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}

