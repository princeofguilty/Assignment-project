package com.example.sockettest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;


public class MainActivity extends AppCompatActivity {
//    @SuppressLint("StaticFieldLeak")
    EditText Username, Password;
    public static Socket s=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Username = findViewById(R.id.UsernameField);
        Password = findViewById(R.id.PasswordField);
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

    public void Login(View v){
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
                String username_s = Username.getText().toString();
                String password_s = Password.getText().toString();
                Log.d("master", "2.5");
                Task.doInBackground(username_s, password_s, "LOGIN");
                Log.d("master", "3");
            }
        }).start();

    }

    public void Register(View v){
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
                String username_s = Username.getText().toString();
                String password_s = Password.getText().toString();
                Log.d("master", "2.5");
                Task.doInBackground(username_s, password_s, "REGISTER");
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
            String Username=voids[0];
            String Password=voids[1];
            writer = new PrintWriter(MainActivity.s.getOutputStream());
            writer.write( voids[2]+"> "+Username+':'+Password+'\n');
            Log.d("master", Username);
            writer.flush();
            Log.d("master", "5");
        }catch (Exception e){
            Log.d("master", "6");
            Log.d("master", String.valueOf(e));
        }

        return null;
    }


}