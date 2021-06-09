package com.example.sockettest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
//    @SuppressLint("StaticFieldLeak")
    //
    public static Packet fromServer = null;
    public static Packet toServer = null;
    public static Classroom  c=null;
    public String ServerIP;
    public static EditText SIP;
    //
    EditText Username, Password;
    TextView msg;
    public static Socket s=null;
    static ObjectOutputStream objectOutputStream;
    static ObjectInputStream objectInputStream;
    public static Packet obj;
    Handler handler;
    public static List<Person> persons=new ArrayList<Person>();
    public static List<Classroom> clist=new ArrayList<Classroom>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Username = findViewById(R.id.UsernameField);
        Password = findViewById(R.id.PasswordField);
        msg=findViewById(R.id.textView);
        msg.setVisibility(TextView.GONE);
        handler=new Handler(getApplicationContext().getMainLooper());
        SIP = findViewById(R.id.ServerIP);
        new Thread(new Runnable(){
            public void run(){
        ServerIP = SIP.getText().toString();
        if (s==null)
            try {
                s = new Socket(ServerIP,9998);
                objectOutputStream = new ObjectOutputStream(s.getOutputStream());
                objectInputStream = new ObjectInputStream(s.getInputStream());
            } catch (IOException e) {
                Log.d("master", e.toString());
            }
            }
        }).start();
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
        ServerIP = SIP.getText().toString();
        new Thread(new Runnable(){
            public void run(){
                Log.d("master", "2");
                if (s==null)
                    try {
                        s = new Socket(ServerIP,9998);
                        objectOutputStream = new ObjectOutputStream(s.getOutputStream());
                        objectInputStream = new ObjectInputStream(s.getInputStream());
                    } catch (IOException e) {
                        Log.d("master", e.toString());
                    }
                LOGIN_TCP Task = new LOGIN_TCP();
                String username_s = Username.getText().toString();
                String password_s = Password.getText().toString();
                Log.d("master", "2.5");
                Person person=new Person(username_s,password_s);
//                Packet send=new Packet("login", person);
                Task.doInBackground(new Packet("login", person));
                Log.d("master", "3");
                while (true){
                    if (LOGIN_TCP.Status==1) {
                        Log.d("test_tcp", "about");
                        Intent i = new Intent(MainActivity.this, Classrooms_Activity.class);
                        startActivity(i);
                        LOGIN_TCP.Status = 0;
                        break;
                    }
                    else if (LOGIN_TCP.Status==0)
                    {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                msg.setVisibility(TextView.VISIBLE);
                            }
                        });
                    }
                }
            }
        }).start();

    }

    public void Register(View v){
        ServerIP = SIP.getText().toString();
        new Thread(new Runnable(){
            public void run(){
                Log.d("master", "2");
                if (s==null)
                    try {
                        s = new Socket(ServerIP,9998);
                        objectOutputStream = new ObjectOutputStream(s.getOutputStream());
                        objectInputStream = new ObjectInputStream(s.getInputStream());
                    } catch (IOException e) {
                        Log.d("master", e.toString());
                    }
                Check_Server_TCP Task = new Check_Server_TCP();
                //String username_s = Username.getText().toString();
                //String password_s = Password.getText().toString();
                Log.d("master", "2.5");
                Task.doInBackground("connect");
                Log.d("master", "3");
                while (true){
                   if (Check_Server_TCP.Status==1) {
                        Log.d("test_tcp", "about");
                        Intent i = new Intent(MainActivity.this, Register_Activity.class);
//                        i.putExtra("username", username_s);
//                        i.putExtra("type", );
                        //i.putExtra("password", password_s);
                        startActivity(i);
                        Check_Server_TCP.Status = 0;
                        break;
                    }
                }
            }
        }).start();
/*        Context context = getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;
        while (STD_TCP.cont==0){
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }*/

    }

}

