package com.example.sockettest;

import com.example.sockettest.*;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class Classroom_adapter extends RecyclerView.Adapter<Classroom_adapter.MyViewHolder> {
    Context mContext;
    String Class_name[], Class_description[], Class_id[];

    public Classroom_adapter(Context context, String names[], String desc[], String id[])
    {
        mContext = context;
        Class_name = names;
        Class_description = desc;
        Class_id = id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.classroom_row_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Classroom_adapter.MyViewHolder holder, int position) {
        holder.name_view.setText(Class_name[position]);
        holder.desc_view.setText(Class_description[position]);
        holder.id_view.setText(Class_id[position]);
        holder.CL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("test_x", Class_name[position] + (position));
                Intent i = new Intent(v.getContext(), Classroom_Overview.class);
                i.putExtra("classname",Class_name[position]);
                i.putExtra("classid",Class_id[position]);
                i.putExtra("classdescription",Class_description[position]);
                v.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return Class_name.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name_view, desc_view, id_view;
        ConstraintLayout CL;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name_view = itemView.findViewById(R.id.Class_name);
            desc_view = itemView.findViewById(R.id.Class_description);
            id_view = itemView.findViewById(R.id.Class_id);
            CL = (ConstraintLayout) itemView.findViewById(R.id.Class_Constraint);
        }
    }
}
