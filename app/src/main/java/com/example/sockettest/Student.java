package com.example.sockettest;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private String School;
    public static List<Student> studentList = new ArrayList<Student>();

    public Student(String Name, String Id){
        super(Name, Id);
        studentList.add(this);
    }
    public Student(String Name, String Id, String school){
        super(Name, Id);
        studentList.add(this);
        setSchool(school);
    }

    public void setSchool(String school) {
        School = school;
    }

    public String getSchool() {
        return School;
    }

    @Override
    public void JoinClassroom(Classroom e) {
        super.JoinClassroom(e);
        e.addStudent(this);
    }

    @Override
    public void removeClassroom(Classroom c) {
        super.removeClassroom(c);
        c.removeStudent(this);
    }
}
