package com.anderjavi.estudiantes.Entities.Estudiante.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor @NoArgsConstructor @Data
public class Estudiante {

    Integer id;
    String nombre;
    String Apellido;
    String correo;
    Date fechaEntrada;
    String ciudad;
    int horasSemanales;
    String especialidad;
    String estado;

}
