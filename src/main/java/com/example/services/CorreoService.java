package com.example.services;

import java.util.List;

import com.example.entities.Correo;


public interface CorreoService {

    List<Correo> findAll();
    void save(Correo correo);
    Correo findById(int id);
}
