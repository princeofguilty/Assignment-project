package com.example.sockettest;

import java.util.ArrayList;
import java.util.List;

public class Classroom implements java.io.Serializable {
    private String name="New Class";
    private String id;
    private String Describtion;
    private int AssignmentsCount=0;
    private List<Student> studentsList= new ArrayList<Student>();
    private List<Teacher> teachersList= new ArrayList<Teacher>();
    private List<Assignment> listofAssignments = new ArrayList<Assignment>();

    public void addStudent(Student s){
        studentsList.add(s);
    }

    public void addTeacher(Teacher s){
        teachersList.add(s);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getDescribtion() {
        return Describtion;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescribtion(String describtion) {
        Describtion = describtion;
    }

    public Classroom(List<Classroom> clist){
        clist.add(this);
    }
    public Classroom(){
    }
    public Classroom(String name, String id, String describtion, List<Classroom> clist){
        setName(name);
        setId(id);
        setDescribtion(describtion);
        clist.add(this);
    }
    public static void removeClassroom(Classroom c, List<Classroom> clist){
        clist.remove(c);
    }
    public static List<Classroom> findClassroom_name(String name, List<Classroom> clist){
        List<Classroom> findings = new ArrayList<Classroom>();
        for(Classroom c : clist){
            if(c.getName().equals(name)){
                findings.add(c);
            }
        }
        return findings;
    }
    public static List<Classroom> findClassroom_id(String id, List<Classroom> clist){
        List<Classroom> findings = new ArrayList<Classroom>();
        for(Classroom c : clist){
            if(c.getId().equals(id)){
                findings.add(c);
            }
        }
        return findings;
    }

    public void removeStudent(Student s){
        studentsList.remove(s);
    }

    public void removeTeacher(Teacher s){
        teachersList.remove(s);
    }

    public void addAssignment(Assignment a){
        listofAssignments.add(a);
        AssignmentsCount++;
    }

    public List<Assignment> getListofAssignments(){
        return listofAssignments;
    }

    public int getAssignmentsCount(){
        return AssignmentsCount;
    }

    public static Classroom findbyid(String id, List<Classroom> clist){
        for(Classroom c: clist){
            if (c.getId().equals(id))
                return c;
        }
        return null;
    }
}
