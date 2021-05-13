package com.anderjavi.estudiantes.entities.estudiante.Infraestucture.Controller;

import com.anderjavi.estudiantes.entities.estudiante.Domain.dto.EstudianteOutputDto;
import com.anderjavi.estudiantes.entities.estudiante.Domain.dto.EstudianteSearchInputDto;
import com.anderjavi.estudiantes.entities.estudiante.Infraestucture.Repository.port.FindByEstudiantePort;
import com.anderjavi.estudiantes.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class FindByEstudianteController {

    FindByEstudiantePort findByEstudiantePort;

    @PostMapping("/api/estudiante/findby")
    public List<EstudianteOutputDto> findBy(@RequestBody EstudianteSearchInputDto estudianteSearchInputDto) {
        if(findByEstudiantePort.findBy(estudianteSearchInputDto).isEmpty()) {
            throw new NotFoundException();
        }
        return findByEstudiantePort.findBy(estudianteSearchInputDto);
    }
}
