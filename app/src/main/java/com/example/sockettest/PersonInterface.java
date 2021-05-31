package com.example.sockettest;

import java.util.List;

interface PersonInterface {
    public String getName();
    public String getId();
    public void setName(String Name);
    public void setId(String Id);
    public List<Classroom> getJoinedClasses();
}
