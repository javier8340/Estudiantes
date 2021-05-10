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

@Repository
@AllArgsConstructor
public class UpdateEstudianteRepository  implements UpdateEstudiantePort {


    private FindByIdEstudiantesPort findByIdEstudiantesPort;
    private EstudianteRepositoryJpa estudianteRepositoryJpa;
    @Override
    public void update(String id, EstudianteInputDto estudianteInputDto) throws Exception {
        checkUpdateable(id);
        EstudianteJpa estudianteJpa = new EstudianteJpa(findByIdEstudiantesPort.findById(id));
        estudianteJpa.setName(estudianteInputDto.getName());
        estudianteJpa.setSurname(estudianteInputDto.getSurname());
        estudianteJpa.setCompanyEmail(estudianteInputDto.getCompanyEmail());
        estudianteJpa.setCreatedDate(estudianteInputDto.getCreatedDate());
        estudianteJpa.setCity(estudianteInputDto.getCity());
        estudianteJpa.setNumHoursWeek(estudianteInputDto.getNumHoursWeek());
        estudianteJpa.setBranch(estudianteInputDto.getBranch());
        estudianteJpa.setActive(estudianteInputDto.isActive());
        estudianteJpa.setIdStudent(id);

        estudianteRepositoryJpa.save(estudianteJpa);

    }

    private void checkUpdateable(String estudianteId){
        try {
            findByIdEstudiantesPort.findById(estudianteId);
        }catch (Exception e){
            throw new UnauthorizedException();
        }
    }
}
