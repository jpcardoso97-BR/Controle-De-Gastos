package com.example.controledegastospessoais.dao;

import com.example.controledegastospessoais.modelo.Gastos;

import java.util.List;

public interface GastosDAO {
    void insert(Gastos gastos);
    void delete(Gastos gastos);
    void update(Gastos gastos);
    List<Gastos> getAll();
}
