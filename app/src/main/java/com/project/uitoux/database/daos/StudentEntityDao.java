package com.project.uitoux.database.daos;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import com.project.uitoux.database.entities.StudentEntity;

import java.util.List;


@Dao
public interface StudentEntityDao {

    @Query(" Select count(*)  from tb_student_details where student_name=:name")
    public int get_count(String name);

    @Query(" Select id from tb_student_details where student_name=:name")
    public int get_student_id(String name);

    @Query(" Select student_name from tb_student_details where id=:id limit 0,1")
    public String get_student_name(int id);


    @Query(" Select * from tb_student_details")
    public List<StudentEntity> get_all_datas();



    @Query(" Delete from tb_student_details")
    public int del_all();


    @Insert
    public Long insert_student_details(StudentEntity tbl);

    @Query(" Select count(*) from tb_student_details where status ='' " )
    public LiveData<Integer> get_details_of_not_updated_student();


    @Query(" Update tb_student_details  set status='done' where id=:std_id" )
    public int update_status(int std_id);





}
