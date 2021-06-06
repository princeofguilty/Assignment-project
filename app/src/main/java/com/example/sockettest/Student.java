package com.example.sockettest;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private String School;
    public static List<Student> studentList = new ArrayList<Student>();

    public Student(int type,String Name, String Id, String username, String password){
        super(type,Name, Id, username, password);
        studentList.add(this);
        setSchool("aast");
    }

    public Student(String Name, String Id, String username, String password){
        super(Name, Id, username, password);
        studentList.add(this);
        setSchool("aast");
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
