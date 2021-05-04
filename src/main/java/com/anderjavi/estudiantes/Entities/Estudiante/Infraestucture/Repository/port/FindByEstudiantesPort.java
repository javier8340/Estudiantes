package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.BusquedaCampos;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.Estudiante;

import java.util.List;

public interface FindByEstudiantesPort {
    public List<Estudiante> findBy(BusquedaCampos busquedaCampos);
}
