package com.example.sockettest;

import java.util.ArrayList;
import java.util.List;

public class Assignment {
    private String title="New Assignment";
    private String id;
    private String Description;
    private Classroom classOfAssignment;
    private Teacher owner;

    public Assignment(Teacher t, Classroom c,String title, String description){
        this.title = title;
        this. Description = description;
        owner = t;
        classOfAssignment = c;
    }

}
