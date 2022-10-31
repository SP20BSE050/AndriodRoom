package com.example.roomdatabase;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity

public class Student {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    public int SerialNo;

    @ColumnInfo()
    public String StudentName;

    @ColumnInfo
    public String Email;

    @ColumnInfo
    public String RollNo;

    public Student() {
    }

    public Student(String StudentName, String Email, String rollNo) {

        this.StudentName = StudentName;
        this.Email = Email;
        this.RollNo = rollNo;
    }



    public int getSerialNo() {
        return SerialNo;
    }

    public void setSerialNo(int serialNo) {
        this.SerialNo = serialNo;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        this.StudentName = studentName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getRollNo() {
        return RollNo;
    }

    public void setRollNo(String rollNo) {
        RollNo = rollNo;
    }
}
