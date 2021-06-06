/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sockettest;

import java.io.Serializable;

/**
 *
 * @author BASILYJOK3R
 */
public class Packet implements Serializable {
    String msg;
    Person person;
    public Packet(String msg) {
        this.msg = msg;
    }
    public Packet(String msg, Person person) {
        this.msg = msg;
        this.person = person;
    }
    @Override
    public String toString() {
        return msg;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    public void Clear(){
        msg = null;
        person = null;
    }

}
