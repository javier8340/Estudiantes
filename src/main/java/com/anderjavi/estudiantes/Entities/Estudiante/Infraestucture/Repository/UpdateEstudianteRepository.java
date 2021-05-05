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
        Estudiante estudianteDeBd = findByIdEstudiantesPort.findById(id);
        estudianteDeBd.setNombre(estudiante.getNombre());
        estudianteDeBd.setApellido(estudiante.getApellido());
        estudianteDeBd.setCorreo(estudiante.getCorreo());
        estudianteDeBd.setFechaEntrada(estudiante.getFechaEntrada());
        estudianteDeBd.setCiudad(estudiante.getCiudad());
        estudianteDeBd.setHorasSemanales(estudiante.getHorasSemanales());
        estudianteDeBd.setEspecialidad(estudiante.getEspecialidad());
        estudianteDeBd.setEstado(estudiante.getEstado());

        estudianteRepositoryJpa.save(new EstudianteJpa(estudianteDeBd));

    }
}
