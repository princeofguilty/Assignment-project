package com.example.sockettest;
import com.example.sockettest.*;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class Classroom_Overview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classroom_overview);
        Bundle extras = getIntent().getExtras();
        setTitle(extras.getString("classname") + " : " + extras.getString("classid"));

    }
}