package com.example.services;

import java.util.List;

import com.example.entities.Departamento;

public interface DepartamentoService {

    List <Departamento> findAll();
    void save(Departamento departamento);
    Departamento findById(int id);
}
