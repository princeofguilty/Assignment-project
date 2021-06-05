package com.example.sockettest;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Classroom_Overview extends AppCompatActivity {
    RecyclerView Assignment_Recyclerview;
    String[] Assignments_titles, Assignments_desc, Assignments_id, Assignments_deadline;
    RecyclerView.LayoutManager Assign_Adapter_layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classroom_overview);
        Bundle extras = getIntent().getExtras();
        setTitle(extras.getString("classname") + " : " + extras.getString("classid"));
        Classroom c = Classroom.findbyid(extras.getString("classid"));
        Assignments_titles = new String[c.getAssignmentsCount()];
        Assignments_desc = new String[c.getAssignmentsCount()];
        Assignments_id = new String[c.getAssignmentsCount()];
        Assignments_deadline = new String[c.getAssignmentsCount()];
        Assignment_Recyclerview = findViewById(R.id.Assignment_Recycleview);
        int i =0;
        try {
            for (Assignment as : c.getListofAssignments()) {

                Assignments_titles[i] = as.getTitle();
                Assignments_desc[i] = as.getAssignId();
                Assignments_id[i] = as.getAssignId();
                Assignments_deadline[i] = as.getDeadline();
                i++;
            }
        }
        catch (Exception ignored){}
        FloatingActionButton TeacherAddClassroom = findViewById(R.id.TeacherAddClassroom);
//        if

        Assignment_adapter assignment_adapter = new Assignment_adapter(this, Assignments_titles, Assignments_desc, Assignments_id, Assignments_deadline);
        Assignment_Recyclerview.setAdapter(assignment_adapter);
        Assign_Adapter_layoutManager = new LinearLayoutManager(this);
        Assignment_Recyclerview.setLayoutManager(Assign_Adapter_layoutManager);
        Assignment_Recyclerview.setHasFixedSize(true);
    }
}