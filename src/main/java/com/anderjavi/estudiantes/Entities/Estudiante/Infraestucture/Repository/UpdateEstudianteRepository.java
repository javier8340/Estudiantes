package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.Branch;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.EstudianteJpa;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.dto.EstudianteInputDto;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.jpa.EstudianteRepositoryJpa;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.FindByIdEstudiantesPort;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.UpdateEstudiantePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UpdateEstudianteRepository  implements UpdateEstudiantePort {


    private final FindByIdEstudiantesPort findByIdEstudiantesPort;
    private final EstudianteRepositoryJpa estudianteRepositoryJpa;

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
            //TODO cambiar a exeption Resolver
        }
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
