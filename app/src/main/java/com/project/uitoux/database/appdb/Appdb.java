package com.project.uitoux.database.appdb;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.project.uitoux.Constants;
import com.project.uitoux.database.daos.MarkEntityDao;
import com.project.uitoux.database.daos.StudentEntityDao;
import com.project.uitoux.database.entities.MarkEntity;
import com.project.uitoux.database.entities.StudentEntity;


@Database(version = 3,entities = {StudentEntity.class, MarkEntity.class})
public abstract  class Appdb extends RoomDatabase {


  private static Appdb db;

  public abstract StudentEntityDao getStudentEntityDao();
  public abstract MarkEntityDao getMarkEntityDao();




  public static synchronized Appdb getDb_instance(Context context)
  {

    if(db==null)
    {
      db = Room.databaseBuilder(context.getApplicationContext(),
              Appdb.class, Constants.Database_Name)
              .fallbackToDestructiveMigration()
              .allowMainThreadQueries()
              .build();



    }


    return db;

  }



}
