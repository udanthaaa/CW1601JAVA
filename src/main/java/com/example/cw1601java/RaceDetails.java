package com.example.cw1601java;

import java.time.LocalDate;

public class RaceDetails extends RaceBaseDetails {
    private String firstPlaceDriver;
    private String secondPlaceDriver;
    private String thirdPlaceDriver;
    private int firstPlacePoints;
    private int secondPlacePoints;
    private int thirdPlacePoints;

    public RaceDetails(LocalDate date, String location, String firstPlaceDriver, String secondPlaceDriver, String thirdPlaceDriver, int firstPlacePoints, int secondPlacePoints, int thirdPlacePoints) {
        super(date, location);
        this.firstPlaceDriver = firstPlaceDriver;
        this.secondPlaceDriver = secondPlaceDriver;
        this.thirdPlaceDriver = thirdPlaceDriver;
        this.firstPlacePoints = firstPlacePoints;
        this.secondPlacePoints = secondPlacePoints;
        this.thirdPlacePoints = thirdPlacePoints;
    }

    public String getFirstPlaceDriver() {
        return firstPlaceDriver;
    }

    public void setFirstPlaceDriver(String firstPlaceDriver) {
        this.firstPlaceDriver = firstPlaceDriver;
    }

    public int getFirstPlacePoints() {
        return firstPlacePoints;
    }

    public void setFirstPlacePoints(int firstPlacePoints) {
        this.firstPlacePoints = firstPlacePoints;
    }

    public String getSecondPlaceDriver() {
        return secondPlaceDriver;
    }

    public void setSecondPlaceDriver(String secondPlaceDriver) {
        this.secondPlaceDriver = secondPlaceDriver;
    }

    public int getSecondPlacePoints() {
        return secondPlacePoints;
    }

    public void setSecondPlacePoints(int secondPlacePoints) {
        this.secondPlacePoints = secondPlacePoints;
    }

    public String getThirdPlaceDriver() {
        return thirdPlaceDriver;
    }

    public void setThirdPlaceDriver(String thirdPlaceDriver) {
        this.thirdPlaceDriver = thirdPlaceDriver;
    }

    public int getThirdPlacePoints() {
        return thirdPlacePoints;
    }

    public void setThirdPlacePoints(int thirdPlacePoints) {
        this.thirdPlacePoints = thirdPlacePoints;
    }
}
