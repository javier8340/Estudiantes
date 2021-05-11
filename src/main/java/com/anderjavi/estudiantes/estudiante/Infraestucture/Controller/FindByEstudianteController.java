package com.anderjavi.estudiantes.estudiante.Infraestucture.Controller;

import com.anderjavi.estudiantes.estudiante.Domain.dto.EstudianteSearchInputDto;
import com.anderjavi.estudiantes.estudiante.Domain.dto.EstudianteOutputDto;
import com.anderjavi.estudiantes.estudiante.Infraestucture.Repository.port.FindByEstudiantePort;
import com.anderjavi.estudiantes.estudiante.application.exceptions.EstudianteNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class FindByEstudianteController {

    FindByEstudiantePort findByEstudiantePort;

    @PostMapping("/api/estudiante/findby")
    public List<EstudianteOutputDto> findBy(@RequestBody EstudianteSearchInputDto estudianteSearchInputDto) {
        if(findByEstudiantePort.findBy(estudianteSearchInputDto).isEmpty()) {
            throw new EstudianteNotFoundException();
        }
        return findByEstudiantePort.findBy(estudianteSearchInputDto);
    }
}
