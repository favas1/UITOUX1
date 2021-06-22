package com.project.uitoux;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.project.uitoux.adapters.AdapterMarklist;
import com.project.uitoux.database.appdb.Appdb;
import com.project.uitoux.database.entities.MarkEntity;
import com.project.uitoux.database.entities.StudentEntity;
import com.project.uitoux.interfaces.MainActivityInterface;
import com.project.uitoux.model.Model;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements MainActivityInterface {

    private com.google.android.material.floatingactionbutton.FloatingActionButton fab_add;
    private RecyclerView recv;
    private Appdb db;
    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();
        Constants.setMainActivityInterface(MainActivity.this);
        db = Appdb.getDb_instance(getApplicationContext());
        show_the_list();
        show_live();

        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);


                final View customLayout
                        = getLayoutInflater()
                        .inflate(
                                R.layout.custom_layout_add_student_detils,
                                null);

                builder.setView(customLayout);
                EditText edt_name = customLayout.findViewById(R.id.edt_name);
                EditText edt_mark1 = customLayout.findViewById(R.id.edt_mark1);
                EditText edt_mark2 = customLayout.findViewById(R.id.edt_mark2);
                EditText edt_mark3 = customLayout.findViewById(R.id.edt_mark3);
                Button btn_save = customLayout.findViewById(R.id.btn_save);

                btn_save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        if (!edt_name.getText().toString().trim().equals("") && !edt_mark1.getText().toString().trim().equals("") && !edt_mark2.getText().toString().trim().equals("") && !edt_mark3.getText().toString().trim().equals("")) {

                            if (db.getStudentEntityDao().get_count(edt_name.getText().toString().trim()) == 0) {
                                db.getStudentEntityDao().insert_student_details(new StudentEntity(0, edt_name.getText().toString().trim()));

                                //  int std_id=  db.getStudentEntityDao().get_student_id(edt_name.getText().toString().trim());

                                ResultCalculation resultCalculation = new ResultCalculation(edt_mark1.getText().toString().trim(), edt_mark2.getText().toString().trim(), edt_mark3.getText().toString().trim(), getApplicationContext(), edt_name.getText().toString().trim());

                                db.getMarkEntityDao().insert_mark_details(new MarkEntity(0, resultCalculation.std_id, resultCalculation.mark1_int, resultCalculation.mark2_int, resultCalculation.mark3_int, resultCalculation.total, 0, resultCalculation.result));


                                dialog.cancel();

                            } else {
                                showSnack_W(getString(R.string.marks_of_this_std_saved_before));
                            }


                        } else {
                            showSnack_W(getString(R.string.all_fields_are_mandatory));
                        }

                        hideSoftKeyboard(MainActivity.this, v);


                    }
                });


                dialog = builder.create();
                dialog.show();

            }
        });
    }

    private void init() {
        fab_add = findViewById(R.id.fab_add);
        recv = findViewById(R.id.recv);


    }

    public void show_live() {

        LiveData<Integer> liveData = db.getStudentEntityDao().get_details_of_not_updated_student();
        liveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {

                if (integer != null && integer > 0) {

                 update_ranks();

                }
            }
        });


    }


    private void show_the_list() {


        List<Model> list = new ArrayList<>();

        for (MarkEntity row : db.getMarkEntityDao().get_dtas_for_recycle_view()) {
            list.add(new Model(db.getStudentEntityDao().get_student_name(row.getStudent_id()), row.getMark_1(), row.getMark_2(), row.getMark_3(), row.getTotal(), row.getRank(),row.getStudent_id()));
        }




     AdapterMarklist adp = new AdapterMarklist(getApplicationContext(), list);

        LinearLayoutManager lm = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recv.setLayoutManager(lm);
        recv.setAdapter(adp);



    }


    @Override
    public void update_marks(int id, int mark1, int mark2, int mark3) {


        int total=mark1+mark2+mark3;
        db.getMarkEntityDao().update_marks(id,mark1,mark2,mark3,total);
        update_ranks();

    }


    private  void update_ranks()
    {
        int rank = 0;
        for (MarkEntity row : db.getMarkEntityDao().get_all_datas()) {
            rank = rank + 1;
            int std_id = row.getStudent_id();

            db.getMarkEntityDao().update_rank(std_id, rank);
            db.getStudentEntityDao().update_status(std_id);

        }

        show_the_list();


    }


}