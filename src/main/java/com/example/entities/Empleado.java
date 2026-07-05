package com.example.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.example.model.Genero;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "empleados")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class Empleado implements Serializable{
    private static final long serialVersionUID = 1L;

    
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

	
    private String nombre;
	
	
    private String primerApellido;

   
   
    private String segundoApellido;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    
    private LocalDate fechaAlta;

   
    private BigDecimal salario;

    @NotNull(message = "El departamento es requerido")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Departamento departamento;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "empleado")
    @Builder.Default
    private Set<Telefono> telefonos = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "empleado")
    @Builder.Default
    private Set<Correo> emails = new HashSet<>();

}
