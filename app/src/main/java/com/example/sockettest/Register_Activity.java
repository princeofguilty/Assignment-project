package com.example.sockettest;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register_Activity extends AppCompatActivity {
    private int person;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Bundle extras = getIntent().getExtras();
        handler=new Handler(getApplicationContext().getMainLooper());
        if (extras != null) {
            ((EditText) findViewById(R.id.RegisterUsername)).setText(extras.getString("username"));
            ((EditText) findViewById(R.id.RegisterPassword)).setText(extras.getString("password"));
        }
    }

    /* public void Button_text(View v){
         RadioButton rb = (RadioButton)v;
         Button b = findViewById(R.id.RegisterButton);
         b.setText(("Register "+rb.getText().toString()));
     }*/
    public void Button_text(View v) {
        person = 0;
    }

    public void Button_text1(View v) {
        person = 1;
    }

    public void Register_button_call(View v) {
        Button b = (Button) v;
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

        Person per;
            Log.d("tcp_test", "here");
            if (person ==0)
                per = new Student(person, name, id, username, password);
            else
                per = new Teacher(person, name, id, username, password);
            Packet pack = new Packet("register", per);
            MainActivity.obj = pack;

            new Thread(new Runnable() {
                public void run() {
                    Send_Receive_TCP st = new Send_Receive_TCP();
                    Log.d("master", "2.5");
                    st.doInBackground(MainActivity.obj);
                    Log.d("master", "3");
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            cont();
                        }
                    });
                }
            }).start();

    }

    public void cont(){
        TextView tv = findViewById(R.id.USERNAME_TAKEN);
        if(MainActivity.fromServer.msg.equals("t")){
            CharSequence text;
            if (person == 0)
                text = "Student registered successfully!";
            else
                text = "Teacher registered successfully!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast;
            toast = Toast.makeText(Register_Activity.this, text, duration);
            toast.show();
            tv.setVisibility(View.INVISIBLE);
        }
        else {
            tv.setVisibility(View.VISIBLE);
        }
    }

}