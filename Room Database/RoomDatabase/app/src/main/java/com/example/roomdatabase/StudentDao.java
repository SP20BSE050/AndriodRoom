package com.example.roomdatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StudentDao {

    @Query("SELECT * FROM Student")
     List<Student> getCourse();

    @Insert
    void InsertRecord(Student student);

    @Query("Delete FROM Student WHERE SerialNo= :cid")
    void DeleteRecord(int cid);

    @Query("select * FROM Student where SerialNo =:name")
    Student GetStudent(String name);

}
