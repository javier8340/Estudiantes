package com.anderjavi.estudiantes.Entities.Estudiante.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class EstudianteJpa {

    public EstudianteJpa(Estudiante estudiante){
        this.nombre = estudiante.nombre;
        this.apellido = estudiante.apellido;
        this.correo = estudiante.correo;
        this.fechaEntrada = estudiante.fechaEntrada;
        this.ciudad = estudiante.ciudad;
        this.horasSemanales = estudiante.horasSemanales;
        this.especialidad = estudiante.especialidad;
        this.estado = estudiante.estado;
    }

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String nombre;
    String apellido;
    String correo;
    Date fechaEntrada;
    String ciudad;
    int horasSemanales;
    String especialidad;
    String estado;
}
