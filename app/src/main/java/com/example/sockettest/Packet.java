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
    String msg2;
    Person person;
    public Packet(String msg) {
        this.msg = msg;
    }
    public Packet(String msg, String msg2) {
        this.msg = msg;
        this.msg2 = msg2;
        person = null;
    }
    public Packet(String msg, Person person) {
        this.msg = msg;
        this.person = person;
    }
    public Packet(String msg, String msg2, Person person) {
        this.msg = msg;
        this.msg2 = msg2;
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
        msg2 = null;
        person = null;
    }

}
