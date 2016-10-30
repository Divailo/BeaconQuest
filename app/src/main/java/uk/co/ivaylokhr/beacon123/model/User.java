package uk.co.ivaylokhr.beacon123.model;

/**
 * Created by Ivaylo on 29/10/2016.
 */

public class User {

    private String username;
    private int points;

    public User(String username, int points){
        this.username = username;
        this.points = points;
    }

    public String getUsername(){
        return username;
    }

    public int getPoints(){
        return points;
    }
}
