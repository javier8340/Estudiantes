package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.Estudiante;

public interface UpdateEstudiantePort {

     void update(String id, Estudiante estudiante) throws Exception;
}
