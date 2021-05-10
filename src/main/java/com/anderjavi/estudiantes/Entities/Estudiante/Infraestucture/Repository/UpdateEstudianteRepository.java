package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.Estudiante;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.EstudianteJpa;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.dto.EstudianteInputDto;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.jpa.EstudianteRepositoryJpa;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.FindByIdEstudiantesPort;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.UpdateEstudiantePort;
import com.anderjavi.estudiantes.exceptions.UnauthorizedException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

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

        if(estudianteInputDto.getName() != null) {
            estudianteJpa.setName(estudianteInputDto.getName());
        }
        if(estudianteInputDto.getSurname() != null) {
            estudianteJpa.setSurname(estudianteInputDto.getSurname());
        }
        if(estudianteInputDto.getCompanyEmail() != null) {
            estudianteJpa.setCompanyEmail(estudianteInputDto.getCompanyEmail());
        }
        if(estudianteInputDto.getSurname() != null) {
            estudianteJpa.setSurname(estudianteInputDto.getSurname());
        }
        if(estudianteInputDto.getCreatedDate() != null) {
            estudianteJpa.setCreatedDate(estudianteInputDto.getCreatedDate());
        }
        if(estudianteInputDto.getTerminationDate() != null) {
            estudianteJpa.setTerminationDate(estudianteInputDto.getTerminationDate());
        }
        if(estudianteInputDto.getCity() != null) {
            estudianteJpa.setCity(estudianteInputDto.getCity());
        }
        if(estudianteInputDto.getNumHoursWeek() != 0) {
            estudianteJpa.setNumHoursWeek(estudianteInputDto.getNumHoursWeek());
        }
        if(estudianteInputDto.getBranch() != null) {
            estudianteJpa.setBranch(estudianteInputDto.getBranch());
        }

        estudianteJpa.setActive(estudianteInputDto.isActive());

        estudianteJpa.setIdStudent(id);

        return estudianteJpa;
    }
}
