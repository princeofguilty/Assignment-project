package com.example.sockettest;

import java.util.ArrayList;
import java.util.List;

public class Person implements PersonInterface{
    private String name;
    private String Username;
    private String Password;
    private String id;
    public int joined_classes_count=0;
    private List<Classroom> JoinedClasses = new ArrayList<Classroom>();
    private List<Person> personList = new ArrayList<Person>();

    public Person(){}

    public Person(String Name, String Id){
        setName(Name);
        setId(Id);
    }


    public Person(String Name, String Id, String username, String password){
        setName(Name);
        setId(Id);
        setPassword(password);
        setUsername(username);
    }

    public boolean checkUsername(String username) {
        for(Person p: personList){
            if (p.getUsername().equals(username)){
                return false;
            }
        }
        return true;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getUsername() {
        return Username;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPassword() {
        return Password;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setName(String Name) {
        name = Name;
    }

    @Override
    public void setId(String Id) {
        id = Id;
    }

    @Override
    public List<Classroom> getJoinedClasses() {
        return JoinedClasses;
    }

    public void JoinClassroom(Classroom e) {
        JoinedClasses.add(e);
        joined_classes_count++;
    }
    public void removeClassroom(Classroom c){
        JoinedClasses.remove(c);
    }
}
