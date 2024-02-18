package edu.psu.sweng888.listviewapp;

import java.io.Serializable;

public class ItemInformation implements Serializable {
    private String id;
    private String professor;
    private String title;
    private String description;

    public ItemInformation(String id, String professor, String title, String description) {
        this.id = id;
        this.professor = professor;
        this.description = description;
        this.title = title;
    }
    public String getID() {
        return id;
    }

    public String getProfessor() {
        return professor;
    }


    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }
}
