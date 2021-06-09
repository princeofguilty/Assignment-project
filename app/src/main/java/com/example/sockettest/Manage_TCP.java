package com.example.sockettest;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;


class Check_Server_TCP extends AsyncTask<String, Void, Void> {
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
//            Log.d("test_object",MainActivity.fromServer.msg);
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

class Send_Receive_TCP extends AsyncTask<Packet, Void, Void> {
    Socket s = MainActivity.s;
    @Override
    protected Void doInBackground(Packet... packet) {
        try{
            MainActivity.objectOutputStream.writeObject(packet[0]);
        }catch (Exception e){
            Log.d("master", String.valueOf(e));
        }
        try {
            MainActivity.fromServer=(Packet)MainActivity.objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
//
//class Teacher_TCP extends AsyncTask<Packet, Void, Void> {
//    PrintWriter writer;
//    Socket s = MainActivity.s;
//    @Override
//    protected Void doInBackground(Packet... teacher) {
//        try{
//            MainActivity.objectOutputStream.writeObject(teacher[0]);
//        }catch (Exception e){
//            Log.d("master", "6");
//            Log.d("master", String.valueOf(e));
//        }
//        return null;
//    }
//}
