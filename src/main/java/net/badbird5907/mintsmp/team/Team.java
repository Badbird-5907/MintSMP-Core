package net.badbird5907.mintsmp.team;

import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<User> players = new ArrayList<>();
    public Team(String name){
        this.name = name;
    }
}
