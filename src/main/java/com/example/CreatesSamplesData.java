package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.example.entities.Departamento;
import com.example.entities.Empleado;

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
		
		empleadoService.save(Empleado.builder()
            .nombre("Maria Lucia")
			.primerApellido("Antonieta")
			.segundoApellido("Francia")
			.genero(Genero.MUJER)
			.fechaAlta(LocalDate.of(2026, 6, 20))
			.departamento(departamentoService.findById(1))
			.salario(new BigDecimal(3500))
			.build());
            };
        }
}
