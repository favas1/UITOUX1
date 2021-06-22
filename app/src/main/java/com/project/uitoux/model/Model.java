package com.project.uitoux.model;

import com.project.uitoux.database.entities.MarkEntity;

import java.io.Serializable;

public class Model {


  private   String name;

  private int mark1;
  private int mark2;
  private int mark3;
  private int total;
  private int rank;

  private int std_id;

    public Model(String name, int mark1, int mark2, int mark3, int total, int rank,int std_id) {
        this.name = name;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
        this.total = total;
        this.rank = rank;
        this.std_id= std_id;
    }

    public int getStd_id() {
        return std_id;
    }

    public void setStd_id(int std_id) {
        this.std_id = std_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark1() {
        return mark1;
    }

    public void setMark1(int mark1) {
        this.mark1 = mark1;
    }

    public int getMark2() {
        return mark2;
    }

    public void setMark2(int mark2) {
        this.mark2 = mark2;
    }

    public int getMark3() {
        return mark3;
    }

    public void setMark3(int mark3) {
        this.mark3 = mark3;
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
}
