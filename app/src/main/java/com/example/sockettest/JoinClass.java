package com.example.sockettest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class JoinClass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_class);
    }

    public void joinClassButton(View v){
        EditText e = (EditText)findViewById(R.id.AddClassId);
        MainActivity.toServer = new Packet("JOINCLASS", e.getText().toString());
        Send_Receive_TCP s = new Send_Receive_TCP();
        s.doInBackground(MainActivity.toServer);
    }
}