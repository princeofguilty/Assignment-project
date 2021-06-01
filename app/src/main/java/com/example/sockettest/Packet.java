package com.example.sockettest;

import java.io.Serializable;

public class Packet implements Serializable {
    String msg;

    public Packet(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
