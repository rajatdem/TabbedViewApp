package cmu.edu.hw2rajatdem;

/**
 * Created by rajatmathur on 6/3/17.
 */

public class Event {
    private long id;
    private String name;
    private String dateTime;
    private String location;


    //all getters and setters except long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}