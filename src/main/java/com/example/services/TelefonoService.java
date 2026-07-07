package com.example.services;

import java.util.List;

import com.example.entities.Telefono;

public interface TelefonoService {

    List<Telefono> findAll();
    void save(Telefono telefono);
    Telefono findById(int id);
}
