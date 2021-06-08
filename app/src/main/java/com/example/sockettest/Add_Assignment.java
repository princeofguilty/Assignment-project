package com.example.sockettest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class Add_Assignment extends AppCompatActivity {
    private DatePickerDialog dpd;
    private Button button;
    EditText addAssTitle;
    EditText addAssDiscreption;
    String id;
    Classroom c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_assignment);
        button=findViewById(R.id.button4);
        addAssTitle= findViewById(R.id.addAssTitle);
        addAssDiscreption= findViewById(R.id.addAssDiscreption);
        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker dp, int year, int month, int day) {
                month=month+1;
                String date=makeDateString(day,month,year);
                button.setText(date);
            }
        };
        Calendar cal=Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        month=month+1;
        int day=cal.get(Calendar.DAY_OF_MONTH);
        int style= AlertDialog.THEME_HOLO_LIGHT;
        dpd=new DatePickerDialog(this,style,dateSetListener,year,month,day);
        dpd.getDatePicker().setMinDate(System.currentTimeMillis());
        button.setText(makeDateString(day,month,year));

        Bundle extras = getIntent().getExtras();
        id=extras.getString("classid");
        c = Classroom.findbyid(id, MainActivity.fromServer.person.getJoinedClasses());
        Classroom c = Classroom.findbyid(extras.getString("classid"), MainActivity.fromServer.person.getJoinedClasses());
    }

    private String makeDateString(int day, int month, int year) {
        return day+"/"+month+"/"+year;
    }

    public void datePicker(View v)
    {
        dpd.show();
    }

    public void AddAssignmentButton(View v){
        new Thread(new Runnable() {
            @Override
            public void run() {
        Assignment a=new Assignment();
        a.setTitle(addAssTitle.getText().toString());
        a.setDescription(addAssDiscreption.getText().toString());
        a.setDeadline(button.getText().toString());
        a.setAssignId(id);
        c.addAssignment(a);
                Packet assign=new Packet("addassignment",a);
                Send_Receive_TCP s = new Send_Receive_TCP();
                s.doInBackground(assign);
                if (MainActivity.fromServer.msg=="t")
                MainActivity.c=MainActivity.fromServer.c;
            }
        });
    }
}