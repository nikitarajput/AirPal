package team.airpal.Model;

import java.sql.Time;

/**
 * Created by Shreya on 10/13/17.
 */

public class Journey {
    private String flightNumber;
    private String departureAirport;
    private String destinationAirport;
    private Time startTime;
    private Time endTime;

    public Journey(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDepatureAirport() {
        return departureAirport;
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

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setDepatureAirport(String departaureAirport) {
        this.departureAirport = departaureAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
}
