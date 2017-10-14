package team.airpal.Model;

/**
 * Created by Shreya on 10/13/17.
 */

public class Meetup {
    private String name;
    private String description;
    private String departureAirport;
    private String destinationAirport;
    private String location;
    private int flightNumber;
    private User[] listOfUsers;

    public Meetup (String name, String description, String departureAirport, String destinationAirport, String location, int flightNumber) {
        this.name = name;
        this.description = description;
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.location = location;
        this.flightNumber = flightNumber;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public String getLocation() {
        return location;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public User[] getListOfUsers() {
        return listOfUsers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setListOfUsers(User[] listOfUsers) {
        this.listOfUsers = listOfUsers;
    }
}
