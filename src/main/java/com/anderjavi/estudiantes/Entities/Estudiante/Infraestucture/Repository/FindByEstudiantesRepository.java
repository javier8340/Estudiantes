package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.BusquedaCampos;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.Estudiante;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.FindByEstudiantesPort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FindByEstudiantesRepository implements FindByEstudiantesPort {
    @Override
    public List<Estudiante> findBy(BusquedaCampos busquedaCampos) {
        return null; //TODO implement
    }
}
