package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.Estudiante;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.dto.BusquedaEstudianteInput;

import java.util.List;

public interface FindByEstudiantesPort {
    public List<Estudiante> findBy(BusquedaEstudianteInput busquedaEstudianteInput);
}
