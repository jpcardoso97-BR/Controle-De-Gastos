package com.example.controledegastospessoais.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.controledegastospessoais.dao.GastosDAO;
import com.example.controledegastospessoais.modelo.Gastos;

@Database(entities = {Gastos.class},version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    public abstract GastosDAO gastosDAO();

    public static AppDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context, AppDatabase.class, "contro_frota_db").allowMainThreadQueries().build();
        }
        return instance;
    }
}
