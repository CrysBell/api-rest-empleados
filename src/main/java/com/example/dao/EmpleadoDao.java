package com.example.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entities.Empleado;



public interface EmpleadoDao  extends JpaRepository<Empleado, Integer>{
    // Metodo 1. Recupera los eempleados paginados
    @Query(value = "select e from Empleado e left join fetch e.departamento", 
        countQuery = "select count(e) from Empleado e"
    )
    public Page<Empleado> findAll(Pageable pageable);

    // Metodo 2. Recupera los productos ordenados, sin paginacion
    @Query(value = "select e from Empleado e left join fetch e.departamento")
    public List<Empleado> findAll(Sort sort);

    // Metodo 3. Dado el id de un empleado que se recibe como parametro
    // recupera el producto con su departamento correspondiente
    @Query(value = "select e from Empleado e left join fetch e.departamento where e.id = :id")
    public Empleado findById(int id);
}
