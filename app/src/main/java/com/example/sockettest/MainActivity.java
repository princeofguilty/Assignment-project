package com.example.sockettest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;


public class MainActivity extends AppCompatActivity {
//    @SuppressLint("StaticFieldLeak")
    EditText textbox ;
    public static Socket s=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textbox = findViewById(R.id.editText);
        Log.d("master", "1");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            if(s!=null)
                s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Send(View v){
        new Thread(new Runnable(){
            public void run(){
                Log.d("master", "2");
                if (s==null)
                try {
                    s = new Socket("192.168.1.4",9999);
                } catch (IOException e) {
                    Log.d("master", e.toString());
                }
                BackgroundTask Task = new BackgroundTask();
                String message = textbox.getText().toString();
                Log.d("master", "2.5");
                Task.doInBackground(message);
                Log.d("master", "3");
            }
        }).start();

    }
}


class BackgroundTask extends AsyncTask<String, Void, Void>{

    PrintWriter writer;

    @Override
    protected Void doInBackground(String... voids) {

        try{
            String message=voids[0];
            writer = new PrintWriter(MainActivity.s.getOutputStream());
            writer.write(message+'\n');
            Log.d("master", message);
            writer.flush();
            Log.d("master", "5");
        }catch (Exception e){
            Log.d("master", "6");
            Log.d("master", String.valueOf(e));
        }

        return null;
    }


}