package com.example.sockettest;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person{

    public static List<Teacher> teacherList = new ArrayList<Teacher>();
    private List<Assignment> ListofAssignments = new ArrayList<Assignment>();

    public Teacher(){
        super();
        teacherList.add(this);
    }
    public Teacher(String Name, String id) {
        super(Name, id);
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