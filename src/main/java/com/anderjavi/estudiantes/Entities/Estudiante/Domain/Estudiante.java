package com.anderjavi.estudiantes.Entities.Estudiante.Domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor @NoArgsConstructor @Data
public class Estudiante {

    public Estudiante(EstudianteJpa estudianteJpa){
        this.id = estudianteJpa.id;
        this.nombre = estudianteJpa.nombre;
        this.apellido = estudianteJpa.apellido;
        this.correo = estudianteJpa.correo;
        this.fechaEntrada = estudianteJpa.fechaEntrada;
        this.ciudad = estudianteJpa.ciudad;
        this.horasSemanales = estudianteJpa.horasSemanales;
        this.especialidad = estudianteJpa.especialidad;
        this.estado = estudianteJpa.estado;
    }

    Integer id;
    String nombre;
    String apellido;
    String correo;
    @JsonFormat(pattern = "MM/dd/yyyy")
    Date fechaEntrada;
    String ciudad;
    int horasSemanales;
    String especialidad;
    String estado;

}
