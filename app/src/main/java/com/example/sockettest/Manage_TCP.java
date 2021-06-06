package com.example.sockettest;
import android.os.AsyncTask;
import android.util.Log;
import com.example.sockettest.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;


class REG_TCP extends AsyncTask<String, Void, Void> {
    public static int Status = 0; // 1: register
    
    PrintWriter writer;
    public static Socket s = MainActivity.s;
    @Override
    protected Void doInBackground(String... voids) {
        try{
            //String Username=voids[0];
            //String Password=voids[1];
            /*writer = new PrintWriter(s.getOutputStream());
            writer.write( voids[0]+"> "+'\n');
            //Log.d("master", Username);
            writer.flush();*/
            Packet p=new Packet(voids[0]);
            MainActivity.objectOutputStream.writeObject(p);
            MainActivity.objectOutputStream.flush();
            Log.d("master", "5");
        }catch (Exception e){
            Log.d("master", "6");
            Log.d("master", String.valueOf(e));
        }
        MainActivity.fromServer = null;
        try {
            MainActivity.fromServer=(Packet)MainActivity.objectInputStream.readObject();
            Log.d("test_object",MainActivity.fromServer.msg);
            if(MainActivity.fromServer.msg.equals("t")) {
                Status = 1;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
//            Log.d("tcp_test", "true");
        return null;
    }
}

class LOGIN_TCP extends AsyncTask<Packet, Void, Void> {
    public static int Status = 0; // 1: register
    PrintWriter writer;
    public static Socket s = MainActivity.s;
    @Override
    protected Void doInBackground(Packet... voids) {
        try{
            MainActivity.objectOutputStream.writeObject(voids[0]);
            MainActivity.objectOutputStream.flush();
            Log.d("master", "5");
        }catch (Exception e){
            Log.d("master", "6");
            Log.d("master", String.valueOf(e));
        }
        try {
            MainActivity.fromServer=(Packet)MainActivity.objectInputStream.readObject();
            Log.d("test_object",MainActivity.fromServer.msg);
            if(MainActivity.fromServer.msg.equals("t")) {
                Status = 1;
//                Packet
            }else if (MainActivity.fromServer.msg.equals("f"))
                Status=0;
        } catch (IOException | ClassNotFoundException e) {
            Log.d("try", "1");
            e.printStackTrace();
        }
//            Log.d("tcp_test", "true");
        return null;
    }
}

class Student_TCP extends AsyncTask<Packet, Void, Void> {
    PrintWriter writer;
    Socket s = MainActivity.s;
    @Override
    protected Void doInBackground(Packet... student) {
        try{
            MainActivity.objectOutputStream.writeObject(student[0]);
        }catch (Exception e){
            Log.d("master", "6");
            Log.d("master", String.valueOf(e));
        }
        return null;
    }
}

class Teacher_TCP extends AsyncTask<Packet, Void, Void> {
    PrintWriter writer;
    Socket s = MainActivity.s;
    @Override
    protected Void doInBackground(Packet... teacher) {
        try{
            MainActivity.objectOutputStream.writeObject(teacher[0]);
        }catch (Exception e){
            Log.d("master", "6");
            Log.d("master", String.valueOf(e));
        }
        return null;
    }
}

class Class_TCP extends AsyncTask<Classroom, Void, Void> {
    PrintWriter writer;
    Socket s = MainActivity.s;
    @Override
    protected Void doInBackground(Classroom... classroom) {
        try{
            MainActivity.objectOutputStream.writeObject(classroom[0]);
        }catch (Exception e){
            Log.d("master", "6");
            Log.d("master", String.valueOf(e));
        }
        return null;
    }
}
class Assignment_TCP extends AsyncTask<Assignment, Void, Void> {
    PrintWriter writer;
    Socket s = MainActivity.s;
    @Override
    protected Void doInBackground(Assignment... assignment) {
        try{
            MainActivity.objectOutputStream.writeObject(assignment[0]);
        }catch (Exception e){
            Log.d("master", "6");
            Log.d("master", String.valueOf(e));
        }
        return null;
    }
}

public class Manage_TCP {
    public static void Send_Student(){
        new Thread(new Runnable(){
            public void run(){
                /*if (REG_TCP.s==null)
                    try {
                        REG_TCP.s = new Socket("192.168.1.5",9992);
                    } catch (IOException e) {
                        Log.d("master", e.toString());
                    }*/
                REG_TCP Task = new REG_TCP();
                Log.d("master", "2.5");
                Task.doInBackground( "LOGIN");
                Log.d("master", "3");
            }
        }).start();
    }
}
