package team.airpal.Model;

/**
 * Created by Shreya on 10/13/17.
 */

public class Meetup {
    private String name;
    private String description;
    private String location;
    private Journey associatedJourney;
    private User[] listOfUsers;

    public Meetup (String name, String description, String location) {
        this.name = name;
        this.description = description;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public Journey getAssociatedJourney() { return associatedJourney; }

    public User[] getListOfUsers() {
        return listOfUsers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAssociatedJourney(Journey associatedJourney) {
        this.associatedJourney =  associatedJourney;
    }

    public void setListOfUsers(User[] listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

    public String flightInfo() {
        return "From " + associatedJourney.getDepatureAirport() + " To "
                + associatedJourney.getDestinationAirport() + " (DL"
                + associatedJourney.getFlightNumber() + ")";
    }
}
