package com.example.sockettest;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Classroom_Overview extends AppCompatActivity {
    RecyclerView Assignment_Recyclerview;
    String[] Assignments_titles, Assignments_desc, Assignments_id, Assignments_deadline;
    RecyclerView.LayoutManager Assign_Adapter_layoutManager;
    View add_b;
    //Classroom c;
    //Bundle extras = getIntent().getExtras();
//    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classroom_overview);
        Bundle extras = getIntent().getExtras();
        //extras = getIntent().getExtras();
        setTitle(extras.getString("classname") + " : " + extras.getString("classid"));
        MainActivity.c = Classroom.findbyid(extras.getString("classid"), MainActivity.fromServer.person.getJoinedClasses());
        add_b=findViewById(R.id.floatingActionButton2);
        if (MainActivity.fromServer.person.type==0) {
//            add_b.setEnabled(false);
            add_b.setVisibility(View.GONE);
        }

            Assignments_titles = new String[MainActivity.c.getAssignmentsCount()];
            Assignments_desc = new String[MainActivity.c.getAssignmentsCount()];
            Assignments_id = new String[MainActivity.c.getAssignmentsCount()];
            Assignments_deadline = new String[MainActivity.c.getAssignmentsCount()];
            Assignment_Recyclerview = findViewById(R.id.Assignment_Recycleview);
            int i = 0;
            try {
                for (Assignment as : MainActivity.c.getListofAssignments()) {

                    Assignments_titles[i] = as.getTitle();
                    Assignments_desc[i] = as.getAssignId();
                    Assignments_id[i] = as.getAssignId();
                    Assignments_deadline[i] = as.getDeadline();
                    i++;
                }
            } catch (Exception ignored) {

            FloatingActionButton TeacherAddClassroom = findViewById(R.id.PLUSsignButton);
        }
//        if

        Assignment_adapter assignment_adapter = new Assignment_adapter(this, Assignments_titles, Assignments_desc, Assignments_id, Assignments_deadline);
        Assignment_Recyclerview.setAdapter(assignment_adapter);
        Assign_Adapter_layoutManager = new LinearLayoutManager(this);
        Assignment_Recyclerview.setLayoutManager(Assign_Adapter_layoutManager);
        Assignment_Recyclerview.setHasFixedSize(true);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                add_b=findViewById(R.id.floatingActionButton2);
//                if (MainActivity.fromServer.person.type==0)
//                {
//                    handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            add_b.setEnabled(false);
//                            add_b.setVisibility(View.GONE);
//                        }
//                    });
//                }
//            }
//        });
    }


    public void addAssignmentToClassroom(View v){
        if (MainActivity.fromServer.person.type==1){
            Intent i = new Intent(this, Add_Assignment.class);
            i.putExtra("classid",MainActivity.c.getId());
            startActivity(i);
        }
    }
}