package team.airpal.Model;

import java.sql.Time;

/**
 * Created by Shreya on 10/13/17.
 */

public class Journey {
    private String departureAirport;
    private String destinationAirport;

    public Journey(String departureAirport, String destinationAirport) {
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

}
