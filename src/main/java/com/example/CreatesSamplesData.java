package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.entities.Correo;
import com.example.entities.Departamento;
import com.example.entities.Empleado;
import com.example.entities.Telefono;
import com.example.model.Genero;
import com.example.services.DepartamentoService;
import com.example.services.EmpleadoService;

@Configuration
public class CreatesSamplesData {
 
    @Bean
    public CommandLineRunner samplesData(EmpleadoService empleadoService,
        DepartamentoService departamentoService){
           
            return args -> {

		
                departamentoService.save(Departamento.builder()
                .nombre("RRHH").build());

		        departamentoService.save(Departamento.builder()
                .nombre("Marketing Digital").build());


                // Crear Empleados
		
		Empleado empleado = Empleado.builder()
        .nombre("Maria Lucia")
        .primerApellido("Antonieta")
        .segundoApellido("Francia")
        .genero(Genero.MUJER)
        .fechaAlta(LocalDate.of(2026, 6, 20))
        .departamento(departamentoService.findById(1))
        .salario(new BigDecimal("3500"))
        .build();


        Telefono telefono = Telefono.builder()
            .numero("1234567789")
            .empleado(empleado)
            .build();

        Correo correo1 = Correo.builder()
            .email("emp2@g.com")
            .empleado(empleado)
            .build();

        Correo correo2 = Correo.builder()
            .email("emp2@gg.com")
            .empleado(empleado)
            .build();

        Correo correo3 = Correo.builder()
            .email("emp2@ggg.com")
            .empleado(empleado)
            .build();

        empleado.setTelefonos(Set.of(telefono));
        empleado.setEmails(Set.of(correo1, correo2, correo3));

        empleadoService.save(empleado);
            };
        }
}
