package team.airpal.Model;

/**
 * Created by Shreya on 10/13/17.
 */

public class Meetup {
    private String name;
    private String description;
    private String location;
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

    public void setListOfUsers(User[] listOfUsers) {
        this.listOfUsers = listOfUsers;
    }
}
