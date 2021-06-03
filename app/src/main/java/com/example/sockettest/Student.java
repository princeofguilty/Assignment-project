package com.example.sockettest;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private String School;
    public static List<Student> studentList = new ArrayList<Student>();

    public Student(String msg,String Name, String Id){
        super(msg,Name, Id);
        studentList.add(this);
    }
    public Student(String msg,int type,String Name, String Id, String username, String password){
        super(msg,type,Name, Id, username, password);
        studentList.add(this);
        setSchool("aast");
    }

    public Student(String msg,String Name, String Id, String username, String password){
        super(msg,Name, Id, username, password);
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
