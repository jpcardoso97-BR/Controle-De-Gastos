package com.example.controledegastospessoais.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.controledegastospessoais.modelo.Gastos;

import java.util.List;
@Dao
public interface GastosDAO {
    @Insert
    void insert(Gastos gastos);
    @Delete
    void delete(Gastos gastos);
    @Update
    void update(Gastos gastos);

    List<Gastos> getAll();
}
