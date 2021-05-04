package com.anderjavi.estudiantes.Entities.Estudiante.Domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor @NoArgsConstructor @Data
public class Estudiante {


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
