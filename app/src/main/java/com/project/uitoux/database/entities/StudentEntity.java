package com.project.uitoux.database.entities;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tb_student_details")
public class StudentEntity {

    @PrimaryKey(autoGenerate = true)
    private   long id;

    private String student_name;


    private String status;
    public StudentEntity(long id, String student_name) {
        this.id = id;
        this.student_name = student_name;
        this.status="";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }
}
