package team.airpal.Model;

import java.sql.Time;

/**
 * Created by Shreya on 10/13/17.
 */

public class Journey {
    private int flightNumber;
    private String depatureAirport;
    private String destinationAirport;
    private Time startTime;
    private Time endTime;

    public Journey(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public String getDepatureAirport() {
        return depatureAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setDepatureAirport(String depatureAirport) {
        this.depatureAirport = depatureAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.depatureAirport = destinationAirport;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
}
