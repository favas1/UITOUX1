package com.project.uitoux.database.entities;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tb_student_marks")
public class MarkEntity {

    @PrimaryKey(autoGenerate = true)
    private   long mnark_id;

    private   int student_id;


    private   int mark_1;
    private   int mark_2;
    private   int mark_3;
    private   int total;
    private   int rank;
    private   String result;

    public MarkEntity(long mnark_id, int student_id, int mark_1, int mark_2, int mark_3, int total, int rank, String result) {
        this.mnark_id = mnark_id;
        this.student_id = student_id;
        this.mark_1 = mark_1;
        this.mark_2 = mark_2;
        this.mark_3 = mark_3;
        this.total = total;
        this.rank = rank;
        this.result = result;
    }


    public long getMnark_id() {
        return mnark_id;
    }

    public void setMnark_id(long mnark_id) {
        this.mnark_id = mnark_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getMark_1() {
        return mark_1;
    }

    public void setMark_1(int mark_1) {
        this.mark_1 = mark_1;
    }

    public int getMark_2() {
        return mark_2;
    }

    public void setMark_2(int mark_2) {
        this.mark_2 = mark_2;
    }

    public int getMark_3() {
        return mark_3;
    }

    public void setMark_3(int mark_3) {
        this.mark_3 = mark_3;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
