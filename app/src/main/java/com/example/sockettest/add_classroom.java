package com.example.sockettest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class add_classroom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_classroom);
    }
    public void addClassButton(View v){
        new Thread(new Runnable() {
            @Override
            public void run() {
                EditText AddClassName = findViewById(R.id.AddClassName);
                EditText AddClassId = findViewById(R.id.AddClassId);
                EditText AddClassDescription = findViewById(R.id.AddClassDescription);
                Person temp = new Person();
                temp.setName(MainActivity.fromServer.person.getName());
                Classroom c = new Classroom();
                c.setName(AddClassName.getText().toString());
                c.setId(AddClassId.getText().toString());
                c.setDescribtion(AddClassDescription.getText().toString());
                temp.JoinClassroom(c);
                Log.d("new1", MainActivity.fromServer.person.getId());
                Packet tp = new Packet("CREATECLASSROOM", (String)MainActivity.fromServer.person.getUsername(), (Person)temp);
                Send_Receive_TCP s = new Send_Receive_TCP();
                s.doInBackground(tp);
            }
        }).start();

    }
}