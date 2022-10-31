package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Context;
import android.os.Bundle;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    List<Student> students;
    Context ct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        fetchData();
    }

    private void fetchData() {

          Thread thread=new Thread(runnable);
          thread.start();
            }
    Runnable runnable=new Runnable() {
        @Override
        public void run() {

            AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                    AppDatabase.class, "database").build();
            StudentDao studentDao = db.courseDao();
            students = studentDao.getCourse();

            Adapter adapter=new Adapter(students);
            RecyclerView recyclerView;
            recyclerView=findViewById(R.id.recyClerView2);
            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity2.this));
            recyclerView.setAdapter(adapter);

        }
    };



}