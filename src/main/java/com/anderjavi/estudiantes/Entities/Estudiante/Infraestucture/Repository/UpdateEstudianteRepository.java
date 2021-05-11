package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.Branch;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.Estudiante;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.EstudianteJpa;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.dto.EstudianteInputDto;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.jpa.EstudianteRepositoryJpa;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.FindByIdEstudiantesPort;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.UpdateEstudiantePort;
import com.anderjavi.estudiantes.exceptions.UnauthorizedException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

import static java.util.Objects.isNull;

@Repository
@AllArgsConstructor
public class UpdateEstudianteRepository  implements UpdateEstudiantePort {


    private FindByIdEstudiantesPort findByIdEstudiantesPort;
    private EstudianteRepositoryJpa estudianteRepositoryJpa;
    @Override
    public void update(String id, EstudianteInputDto estudianteInputDto) throws Exception {
        checkUpdateable(id);
        EstudianteJpa estudianteJpa = new EstudianteJpa(findByIdEstudiantesPort.findById(id));

        estudianteRepositoryJpa.save(updatedEstudiante(estudianteJpa, estudianteInputDto, id));

    }

    private void checkUpdateable(String estudianteId){
        try {
            findByIdEstudiantesPort.findById(estudianteId);
        }catch (Exception e){
            throw new UnauthorizedException();
        }
    }

    private EstudianteJpa updatedEstudiante(EstudianteJpa estudianteJpa, EstudianteInputDto estudianteInputDto, String id) {

        if(isNotNull(estudianteInputDto.getName()))
            estudianteJpa.setName(estudianteInputDto.getName());

        if(isNotNull(estudianteInputDto.getSurname()))
            estudianteJpa.setSurname(estudianteInputDto.getSurname());

        if(isNotNull(estudianteInputDto.getCompanyEmail()))
            estudianteJpa.setCompanyEmail(estudianteInputDto.getCompanyEmail());

        if(isNotNull(estudianteInputDto.getSurname()))
            estudianteJpa.setSurname(estudianteInputDto.getSurname());

        if(isNotNull(estudianteInputDto.getCreatedDate()))
            estudianteJpa.setCreatedDate(estudianteInputDto.getCreatedDate());

        if(isNotNull(estudianteInputDto.getTerminationDate()))
            estudianteJpa.setTerminationDate(estudianteInputDto.getTerminationDate());

        if(isNotNull(estudianteInputDto.getCity()) )
            estudianteJpa.setCity(estudianteInputDto.getCity());

        if(isNotNull(estudianteInputDto.getNumHoursWeek()))
            estudianteJpa.setNumHoursWeek(estudianteInputDto.getNumHoursWeek());

        if(isNotNull(estudianteInputDto.getBranch()))
            estudianteJpa.setBranch(Branch.valueOf(estudianteInputDto.getBranch()));

        if(isNotNull(estudianteInputDto.getActive()))
            estudianteJpa.setActive(estudianteInputDto.getActive());

        estudianteJpa.setIdStudent(id);

        return estudianteJpa;
    }

    private boolean isNotNull(Object value){
        return value != null;
    }
}
