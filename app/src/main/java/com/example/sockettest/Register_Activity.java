package com.example.sockettest;

import androidx.appcompat.app.AppCompatActivity;
import com.example.sockettest.*;

import android.app.ActionBar;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Register_Activity extends AppCompatActivity {

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

    public void Button_text(View v){
        RadioButton rb = (RadioButton)v;
        Button b = findViewById(R.id.RegisterButton);
        b.setText(("Register "+rb.getText().toString()));
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
        Log.d("tcp_test", "herex");
        if(type.toLowerCase().equals("register student")){
            Log.d("tcp_test", "here");
            Student s = new Student(name, id, username, password);
            Student_TCP st = new Student_TCP();
            st.doInBackground(s);
            Log.d("tcp_test", st.toString());
        }
        else if(type.toLowerCase().equals("register teacher")){
            Teacher s = new Teacher(name, id, username, password);
            Teacher_TCP st = new Teacher_TCP();
            st.doInBackground(s);
            Log.d("tcp_test", st.toString());
        }

    }

}