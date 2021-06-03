package com.example.sockettest;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person{

    public static List<Teacher> teacherList = new ArrayList<Teacher>();
    private List<Assignment> ListofAssignments = new ArrayList<Assignment>();

    public Teacher(String msg){
        super(msg);
        teacherList.add(this);
    }
    public Teacher(String msg,String Name, String id) {
        super(msg,Name, id);
        teacherList.add(this);
    }
    public Teacher(String msg,String Name, String id, String username, String password) {
        super(msg,Name, id, username, password);
        teacherList.add(this);
    }

    public Teacher(String msg,int type,String Name, String id, String username, String password) {
        super(msg,type,Name, id, username, password);
        teacherList.add(this);
    }

    @Override
    public void JoinClassroom(Classroom e) {
        super.JoinClassroom(e);
        e.addTeacher(this);
    }

    @Override
    public void removeClassroom(Classroom c) {
        super.removeClassroom(c);
        c.removeTeacher(this);
    }

    public void addAssignment(Assignment a){
        ListofAssignments.add(a);
    }
}
