package com.project.uitoux;

import android.content.Context;

import com.project.uitoux.database.appdb.Appdb;

public class ResultCalculation {


    private String mark1;
    private String mark2;
    private String mark3;
    private Appdb db;
    private Context context;

    int mark1_int;
    int mark2_int;
    int mark3_int;

    int total = 0;
    String result = "";
    int std_id;


    public ResultCalculation(String mark1, String mark2, String mark3, Context context, String name) {
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
        this.context = context;


        this.mark1_int = Integer.parseInt(mark1);
        this.mark2_int = Integer.parseInt(mark2);
        this.mark3_int = Integer.parseInt(mark3);
        this.total = mark1_int + mark2_int + mark3_int;


        if (mark1_int > 50 && mark2_int > 50 && mark3_int > 50) {
            this.result = "pass";
        } else {
            this.result = "fail";
        }

        db = Appdb.getDb_instance(this.context);

        this.std_id = db.getStudentEntityDao().get_student_id(name);

    }
}
