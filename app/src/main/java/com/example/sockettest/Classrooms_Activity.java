package com.example.sockettest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Classrooms_Activity extends AppCompatActivity {
//    Person p= new Person(null,"ahmed", "1810", "user", "1234");
    RecyclerView Classrooms_Recyclerview;
    String[] Classrooms_names;
    String[] Classrooms_Descriptions;
    String[] Classrooms_Id;
    RecyclerView.LayoutManager CAdapter_layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle extras = getIntent().getExtras();
        Person p = MainActivity.fromServer.person;
//        Person p = new Person(0, "ahmed", "asd", "princ", "123");
//        // test
//        Classroom c = new Classroom();
//        c.setName("test class");
//        c.setDescribtion("hello world");
//        c.setId("123x");
//        p.JoinClassroom(c);
//        p.JoinClassroom(c);
//        p.JoinClassroom(c);
//        p.JoinClassroom(c);
//        p.JoinClassroom(c);
//        p.JoinClassroom(c);
//        p.JoinClassroom(c);
//        p.JoinClassroom(c);
//        p.JoinClassroom(c);
//        p.JoinClassroom(c);
//        Assignment as = new Assignment(new Teacher(), c, "mega", "test");
//        as.setAssignId("123");
//        c.addAssignment(as);
//        // end
            Classrooms_names = new String[p.joined_classes_count];
            Classrooms_Descriptions = new String[p.joined_classes_count];
            Classrooms_Id = new String[p.joined_classes_count];
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_classrooms);

            Classrooms_Recyclerview = findViewById(R.id.Classrooms_Recycleview);
            int i = 0;

            for (Classroom cl : p.getJoinedClasses()) {
                Classrooms_names[i] = cl.getName();
                Classrooms_Descriptions[i] = cl.getDescribtion();
                Classrooms_Id[i] = cl.getId();
                i++;
            }

            Classroom_adapter CAdapter = new Classroom_adapter(this, Classrooms_names, Classrooms_Descriptions, Classrooms_Id);
            Classrooms_Recyclerview.setAdapter(CAdapter);
            CAdapter_layoutManager = new LinearLayoutManager(this);
            Classrooms_Recyclerview.setLayoutManager(CAdapter_layoutManager);
            Classrooms_Recyclerview.setHasFixedSize(true);
    }

    public void PlusButton(View v){
        if (MainActivity.fromServer.person.type==0){
            Intent i = new Intent(this, JoinClass.class);
            startActivity(i);
        }
        else {
            Intent i = new Intent(this, add_classroom.class);
            startActivity(i);
        }
    }
}