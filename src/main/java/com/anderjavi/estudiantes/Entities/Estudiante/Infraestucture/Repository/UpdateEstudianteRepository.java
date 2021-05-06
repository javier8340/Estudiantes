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
        estudianteJpa.setName(estudiante.getName());
        estudianteJpa.setSurname(estudiante.getSurname());
        estudianteJpa.setCompany_email(estudiante.getCompany_email());
        estudianteJpa.setCreatedDate(estudiante.getCreatedDate());
        estudianteJpa.setCity(estudiante.getCity());
        estudianteJpa.setNumHoursWeek(estudiante.getNumHoursWeek());
        estudianteJpa.setBranch(estudiante.getBranch());
        estudianteJpa.setActive(estudiante.isActive());

        estudianteRepositoryJpa.save(estudianteJpa);

    }
}
