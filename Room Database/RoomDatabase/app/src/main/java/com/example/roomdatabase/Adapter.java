package com.example.roomdatabase;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<Student> student;
    Context context;
    public Adapter(List<Student> students) {
        this.student = students;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.singlerowlayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        String str="";
        str=str+" "+"  "+ student.get(position).getSerialNo()+"  "+ student.get(position).getStudentName()+"  "+ student.get(position).getEmail()+"  "+ student.get(position).getRollNo();
        holder.textView1.setText(str);
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDatabase db= Room.databaseBuilder(holder.textView1.getContext(),AppDatabase.class,"database").allowMainThreadQueries().build();
                StudentDao studentDao = db.courseDao();
                studentDao.DeleteRecord(student.get(position).getSerialNo());
                student.remove(position);
                notifyDataSetChanged();
            }
        });
        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

//        context.startActivity(new Intent(context,MainActivity3.class));
    }

    @Override
    public int getItemCount() {
        return student.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView1;
        Button update;
        Button delete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.textView);
            update=itemView.findViewById(R.id.update);
            delete=itemView.findViewById(R.id.Delete);

        }
    }
}
