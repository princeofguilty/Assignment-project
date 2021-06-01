package com.example.sockettest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
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
            if(s!=null) {
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }

    public void Login(View v){
        new Thread(new Runnable(){
            public void run(){
                Log.d("master", "2");
                if (s==null)
                    try {
                        s = new Socket("192.168.1.5",9999);
                    } catch (IOException e) {
                        Log.d("master", e.toString());
                    }
                LOGIN_TCP Task = new LOGIN_TCP();
                String username_s = Username.getText().toString();
                String password_s = Password.getText().toString();
                Log.d("master", "2.5");
                Task.doInBackground(username_s, password_s, "LOGIN");
                Log.d("master", "3");
                while (true){
                    if (LOGIN_TCP.Status==1) {
                        Log.d("test_tcp", "about");
                        Intent i = new Intent(MainActivity.this, Classrooms_Activity.class);
                        i.putExtra("username", username_s);
                        i.putExtra("password", password_s);
                        startActivity(i);
                        LOGIN_TCP.Status = 0;
                        break;
                    }
                }
            }
        }).start();

    }

    public void Register(View v){
        new Thread(new Runnable(){
            public void run(){
                Log.d("master", "2");
                if (s==null)
                    try {
                        s = new Socket("192.168.1.5",9999);
                    } catch (IOException e) {
                        Log.d("master", e.toString());
                    }
                REG_TCP Task = new REG_TCP();
                //String username_s = Username.getText().toString();
                //String password_s = Password.getText().toString();
                Log.d("master", "2.5");
                Task.doInBackground("REGISTER");
                Log.d("master", "3");
                while (true){
                    if (REG_TCP.Status==1) {
                        Log.d("test_tcp", "about");
                        Intent i = new Intent(MainActivity.this, Register_Activity.class);
                        //i.putExtra("username", username_s);
                        //i.putExtra("password", password_s);
                        startActivity(i);
                        REG_TCP.Status = 0;
                        break;
                    }
                }
            }
        }).start();
//        Context context = getApplicationContext();
//        CharSequence text = "Hello toast!";
//        int duration = Toast.LENGTH_SHORT;
//        while (STD_TCP.cont==0){
//            Toast toast = Toast.makeText(context, text, duration);
//            toast.show();
//        }

    }

}

