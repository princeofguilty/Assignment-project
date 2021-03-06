package com.example.sockettest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements PersonInterface, Serializable {
    public int type = 0;
    private String name;
    private String Username;
    private String Password;
    private String id;
    public int joined_classes_count = 0;
    private List<Classroom> JoinedClasses = new ArrayList<Classroom>();

    public Person() {
    }

    public Person(String username, String password) {

        Username = username;
        Password = password;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public Person(int type, String name, String id, String username, String password) {

        this.type = type;
        this.name = name;
        Username = username;
        Password = password;
        this.id = id;
    }

    public Person(String Name, String Id, String username, String password) {
        setName(Name);
        setId(Id);
        setPassword(password);
        setUsername(username);
    }

    @Override
    public String toString() {
        return "Person{" + "type=" + type + ", name=" + name + ", Username=" + Username + ", Password=" + Password + ", id=" + id + '}';
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

    public void removeClassroom(Classroom c) {
        JoinedClasses.remove(c);
    }

    public static Person findPersonByUsername(String us, List<Person> p) {
        String usx = us.toLowerCase();
        for (Person i : p) {
            if (i.getUsername().toLowerCase().equals(usx)) {
                return i;
            }
        }
        return null;
    }
}
