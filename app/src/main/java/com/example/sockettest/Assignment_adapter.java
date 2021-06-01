package com.example.sockettest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class Assignment_adapter extends RecyclerView.Adapter<Assignment_adapter.MyViewHolder_Assignment> {
    Context mContext;
    String Class_name[], Assign_description[], Assign_id[], Assign_title[], Deadline[];

    public Assignment_adapter(Context context, String assign_title[], String desc[], String id[], String deadline[])
    {
        mContext = context;
        Assign_title = assign_title;
        Assign_description = desc;
        Assign_id = id;
        Deadline = deadline;
    }

    @NonNull
    @Override
    public MyViewHolder_Assignment onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.assignment_row_item, parent, false);
        MyViewHolder_Assignment myViewHolderAssignment = new MyViewHolder_Assignment(view);
        return myViewHolderAssignment;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder_Assignment holder, int position) {
        holder.assign_title.setText(Assign_title[position]);
        holder.assign_desc.setText(Assign_description[position]);
        holder.assign_id.setText(Assign_id[position]);
        holder.assign_deadline.setText(Deadline[position]);
    }

    @Override
    public int getItemCount() {
        return Assign_title.length;
    }

    public class MyViewHolder_Assignment extends RecyclerView.ViewHolder{
        TextView assign_title, assign_desc, assign_id, assign_deadline;
        ConstraintLayout ASCL;
        public MyViewHolder_Assignment(@NonNull View itemView) {
            super(itemView);
            assign_title = itemView.findViewById(R.id.Assign_title);
            assign_desc = itemView.findViewById(R.id.Assign_description);
            assign_id = itemView.findViewById(R.id.Assign_id);
            assign_deadline = itemView.findViewById(R.id.Assign_date);
            ASCL = (ConstraintLayout) itemView.findViewById(R.id.Assign_info_Constraint);
        }
    }
}
