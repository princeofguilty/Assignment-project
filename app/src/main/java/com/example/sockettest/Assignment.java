package com.example.sockettest;

import java.util.ArrayList;
import java.util.List;

public class Assignment implements java.io.Serializable {
    private static int FINISHED=1, NOT_FINISHED=0, GRADED=2;
    private String title="New Assignment";
    private String id="asid34";
    private int State = NOT_FINISHED;
    private String Description="description lorem ipsum \n description lorem ipsum \n description lorem ipsum \n ";
    private String deadline="today";

    public Assignment(String title, String description){
        this.title = title;
        this. Description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAssignId(String id) {
        this.id = id;
    }

    public Assignment() {
    }

    public String getAssignId() {
        return id;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDescription() {
        return Description;
    }

    public void setState(int state) {
        State = state;
    }

    public int getState() {
        return State;
    }
}
