package com.example.cw1601java;

public class DriverDetails {
    private String Name;
    private int Age;
    private String Team;
    private String Car;
    private int CurrentPoints;
    private int position;


    public DriverDetails(String Name, int Age, String Team, String Car, int CurrentPoints) {
        this.Name = Name;
        this.Age = Age;
        this.Team = Team;
        this.Car = Car;
        this.CurrentPoints = CurrentPoints;
        this.position = 0;
    }


    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getTeam() {
        return Team;
    }

    public void setTeam(String Team) {
        this.Team = Team;
    }

    public String getCar() {
        return Car;
    }

    public void setCar(String Car) {
        this.Car = Car;
    }
    public int getCurrentPoints() {
        return CurrentPoints;
    }

    public void setCurrentPoints(int CurrentPoints) {
        this.CurrentPoints = CurrentPoints;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}

