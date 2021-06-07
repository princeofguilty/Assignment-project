package com.example.sockettest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class JoinClass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_class);
    }

    public void joinClassButton(View v) {
        new Thread(new Runnable() {
            public void run() {
                EditText classCode = findViewById(R.id.JoinClassId);
                Log.d("tcp_test", "here");
                Packet pack = new Packet("JOINCLASS", classCode.getText().toString(), new Person("", MainActivity.fromServer.person.getId(), "", ""));
                Log.d("master", "2");
                Send_Receive_TCP st = new Send_Receive_TCP();
                Log.d("master", "2.5");
                st.doInBackground(pack);
                Log.d("master", "3");
            }
        }).start();
        CharSequence text;
        text = "Class Join Requested!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(this, text, duration);
        toast.show();


    }
}