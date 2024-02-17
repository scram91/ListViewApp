package edu.psu.sweng888.listviewapp;

import java.io.Serializable;

public class ItemInformation implements Serializable {
    private int id;
    private int credits;
    private String description;

    public ItemInformation(int id, int credits, String description) {
        this.id = id;
        this.credits = credits;
        this.description = description;
    }

    public int getID() {
        return id;
    }

    public int getCredits() {
        return credits;
    }

    public String getDescription() {
        return description;
    }
}
