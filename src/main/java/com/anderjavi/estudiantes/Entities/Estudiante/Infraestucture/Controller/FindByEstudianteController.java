package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Controller;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.dto.EstudianteSearchInputDto;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.dto.EstudianteOutputDto;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.FindByEstudiantePort;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class FindByEstudianteController {

    FindByEstudiantePort findByEstudiantePort;

    @PostMapping("/api/estudiante/findby")
    public List<EstudianteOutputDto> findById(@RequestBody EstudianteSearchInputDto estudianteSearchInputDto) throws Exception {
        return findByEstudiantePort.findBy(estudianteSearchInputDto);
    }
}
