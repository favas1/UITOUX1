package com.project.uitoux.database.daos;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.project.uitoux.database.entities.MarkEntity;

import java.util.List;


@Dao
public interface MarkEntityDao {






    @Query(" Delete from tb_student_marks")
    public int del_all();


    @Insert
    public Long insert_mark_details(MarkEntity tbl);


    @Query(" Select * from tb_student_marks order by total desc ")
    public List<MarkEntity> get_all_datas();



    @Query(" Update tb_student_marks  set rank=:rank where student_id=:std_id" )
    public int update_rank(int std_id,int rank);





    @Query(" Select  * from tb_student_marks   order by total desc ")
    public List<MarkEntity> get_dtas_for_recycle_view();


    @Query(" Update tb_student_marks  set mark_1=:m1,mark_2=:m2,mark_3=:m3,total=:total where student_id=:std_id" )
    public int update_marks(int std_id,int m1,int m2,int m3,int total);




}
