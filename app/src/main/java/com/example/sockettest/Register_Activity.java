package com.example.sockettest;

import androidx.appcompat.app.AppCompatActivity;
import com.example.sockettest.*;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import java.io.IOException;
import java.net.Socket;

public class Register_Activity extends AppCompatActivity {
private int person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            ((EditText)findViewById(R.id.RegisterUsername)).setText(extras.getString("username"));
            ((EditText)findViewById(R.id.RegisterPassword)).setText(extras.getString("password"));
        }
    }

   /* public void Button_text(View v){
        RadioButton rb = (RadioButton)v;
        Button b = findViewById(R.id.RegisterButton);
        b.setText(("Register "+rb.getText().toString()));
    }*/
   public void Button_text(View v){
       person=0;
   }

    public void Button_text1(View v){
       person=1;
    }

    public void Register_button_call(View v){
        Button b = (Button)v;
        EditText box = findViewById(R.id.RegisterName);
        String name = box.getText().toString();
        box = findViewById(R.id.RegisterUsername);
        String username = box.getText().toString();
        box = findViewById(R.id.RegisterId);
        String id = box.getText().toString();
        box = findViewById(R.id.RegisterPassword);
        String password = box.getText().toString();
        String type = b.getText().toString();
        Log.d("tcp_test", "here");
        //if(type.toLowerCase().equals("register student"))
         if (person==0){
            Log.d("tcp_test", "here");
            Student p = new Student(person,name, id, username, password);
             new Thread(new Runnable(){
                 public void run(){
                     Log.d("master", "2");
                     if (MainActivity.s==null)
                         try {
                             MainActivity.s = new Socket("192.168.1.5",9994);
                         } catch (IOException e) {
                             Log.d("master", e.toString());
                         }
                     Student_TCP st = new Student_TCP();
                     //String username_s = Username.getText().toString();
                     //String password_s = Password.getText().toString();
                     Log.d("master", "2.5");
                     st.doInBackground(p);
                     Log.d("master", "3");
                     }
             }).start();
        }
        //else if(type.toLowerCase().equals("register teacher"))
        else if (person==1){
            Person s = new Teacher(person,name, id, username, password);
            Teacher_TCP st = new Teacher_TCP();
            st.doInBackground(s);
            Log.d("tcp_test", st.toString());
        }

    }

}