package com.anderjavi.estudiantes.entities.estudiante.Infraestucture.Repository;

import com.anderjavi.estudiantes.entities.estudiante.Domain.Branch;
import com.anderjavi.estudiantes.entities.estudiante.Domain.EstudianteJpa;
import com.anderjavi.estudiantes.entities.estudiante.Domain.dto.EstudianteInputDto;
import com.anderjavi.estudiantes.entities.estudiante.Infraestucture.Repository.jpa.EstudianteRepositoryJpa;
import com.anderjavi.estudiantes.entities.estudiante.Infraestucture.Repository.port.FindByIdEstudiantesPort;
import com.anderjavi.estudiantes.entities.estudiante.Infraestucture.Repository.port.UpdateEstudiantePort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@AllArgsConstructor
public class UpdateEstudianteRepository  implements UpdateEstudiantePort {


    private final FindByIdEstudiantesPort findByIdEstudiantesPort;
    private final EstudianteRepositoryJpa estudianteRepositoryJpa;

    @Override
    public void update(String id, EstudianteInputDto estudianteInputDto){
        log.debug("editando estudiante " + id);
        checkUpdateable(id);
        EstudianteJpa estudianteJpa = new EstudianteJpa(findByIdEstudiantesPort.findById(id));

        estudianteRepositoryJpa.save(updatedEstudiante(estudianteJpa, estudianteInputDto, id));

    }

    private void checkUpdateable(String estudianteId){
        findByIdEstudiantesPort.findById(estudianteId);
        log.debug("estudiante editar existe");

    }

    private EstudianteJpa updatedEstudiante(EstudianteJpa estudianteJpa, EstudianteInputDto estudianteInputDto, String id) {

        if(estudianteInputDto.getName() != null)
            estudianteJpa.setName(estudianteInputDto.getName());

        if(estudianteInputDto.getSurname() != null)
            estudianteJpa.setSurname(estudianteInputDto.getSurname());

        if(estudianteInputDto.getCompanyEmail() != null)
            estudianteJpa.setCompanyEmail(estudianteInputDto.getCompanyEmail());

        if(estudianteInputDto.getSurname() != null)
            estudianteJpa.setSurname(estudianteInputDto.getSurname());

        if(estudianteInputDto.getCreatedDate() != null)
            estudianteJpa.setCreatedDate(estudianteInputDto.getCreatedDate());

        if(estudianteInputDto.getTerminationDate() != null)
            estudianteJpa.setTerminationDate(estudianteInputDto.getTerminationDate());

        if(estudianteInputDto.getCity() != null )
            estudianteJpa.setCity(estudianteInputDto.getCity());

        if(estudianteInputDto.getNumHoursWeek() != null)
            estudianteJpa.setNumHoursWeek(estudianteInputDto.getNumHoursWeek());

        if(estudianteInputDto.getBranch() != null)
            estudianteJpa.setBranch(Branch.valueOf(estudianteInputDto.getBranch()));

        if(estudianteInputDto.getActive() != null)
            estudianteJpa.setActive(estudianteInputDto.getActive());

        estudianteJpa.setIdStudent(id);

        return estudianteJpa;
    }


}
