package com.mycompany.model;

public class Train
{
    private String trainName;
    private String departureTime;
    private String inWayTimeMinutes;

    public Train(String trainName, String departureTime, String inWayTimeMinutes)
    {
        this.trainName = trainName;
        this.departureTime = departureTime;
        this.inWayTimeMinutes = inWayTimeMinutes;
    }
}
