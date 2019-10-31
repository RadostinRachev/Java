package com.example.myfirstapp;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.ArrayList;

@Entity(tableName = "note_table")
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int id;
    //private String title;
    //private String description;
    private ArrayList<String> checks = new ArrayList<>();
    private String result;


    public Note(String result, ArrayList<String> checks) {
        //this.title = title;
        //this.description = description;
        this.checks = checks;
        this.result = result;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
/*
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
*/
    public String getResult() {
        return result;
    }

    @TypeConverters({Converters.class})
    public ArrayList<String> getChecks() { return checks; }
}

