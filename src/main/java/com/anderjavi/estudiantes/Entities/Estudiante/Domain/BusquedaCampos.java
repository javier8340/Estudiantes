package com.anderjavi.estudiantes.Entities.Estudiante.Domain;

import lombok.Data;

import java.util.List;

@Data
public class BusquedaCampos {

    private List<String> campos;
    private List<String> valores;

}
