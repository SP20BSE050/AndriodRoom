package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Handler handler=new Handler();
    EditText name2;
    EditText email2;
    EditText RollNo;
    Button button;
    Button button2;
    EditText TextView;
    Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name2=findViewById(R.id.name2);
        email2=findViewById(R.id.email2);
        RollNo =findViewById(R.id.Mar2);
//         button=findViewById(R.id.UpdateRecord);
         button2=findViewById(R.id.Fetch);
         search=findViewById(R.id.Searchbutton);
         TextView=findViewById(R.id.searchView);





         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                bgthreads bgthreadss=new bgthreads();
                bgthreadss.start();
             }
         });






         button2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 startActivity(new Intent(getApplicationContext(), MainActivity2.class));

             }
         });
         search.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                         AppDatabase.class, "database").build();
                 StudentDao studentDao = db.courseDao();
                 String data=TextView.getText().toString();
               Student student=  studentDao.GetStudent(data);
               String str=student.StudentName.toString()+" "+student.Email.toString()+" "+student.RollNo.toString();
               TextView.setText(str);



             }
         });

    }

public  class bgthreads extends Thread{



    @Override
    public void run() {

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database").build();
        StudentDao studentDao = db.courseDao();
        studentDao.InsertRecord(new Student(name2.getText().toString(),email2.getText().toString(), RollNo.getText().toString()));

        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(),"Inserted Successfully",Toast.LENGTH_SHORT).show();
                name2.setText("");
                email2.setText("");
                RollNo.setText("");
            }
        });
    }

}
}
