package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.Estudiante;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.EstudianteJpa;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.jpa.EstudianteRepositoryJpa;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.FindByIdEstudiantesPort;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.UpdateEstudiantePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UpdateEstudianteRepository  implements UpdateEstudiantePort {


    private FindByIdEstudiantesPort findByIdEstudiantesPort;
    private EstudianteRepositoryJpa estudianteRepositoryJpa;
    @Override
    public void update(int id, Estudiante estudiante) throws Exception {
        EstudianteJpa estudianteJpa = findByIdEstudiantesPort.findById(id);
        estudianteJpa.setNombre(estudiante.getNombre());
        estudianteJpa.setApellido(estudiante.getApellido());
        estudianteJpa.setCorreo(estudiante.getCorreo());
        estudianteJpa.setFechaEntrada(estudiante.getFechaEntrada());
        estudianteJpa.setCiudad(estudiante.getCiudad());
        estudianteJpa.setHorasSemanales(estudiante.getHorasSemanales());
        estudianteJpa.setEspecialidad(estudiante.getEspecialidad());
        estudianteJpa.setEstado(estudiante.getEstado());

        estudianteRepositoryJpa.save(estudianteJpa);

    }
}
