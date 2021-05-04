package com.anderjavi.estudiantes.Entities.Estudiante.Domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class BusquedaEstudianteInput {
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
