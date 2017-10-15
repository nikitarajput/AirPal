package team.airpal.Model;

import java.sql.Time;

/**
 * Created by Shreya on 10/13/17.
 */

public class Journey {
    private String flightNumber;
    private String departureAirport;
    private String destinationAirport;
    private String startTime;
    private String endTime;

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

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
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

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
