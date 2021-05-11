package com.anderjavi.estudiantes.estudiante.Infraestucture.Controller;

import com.anderjavi.estudiantes.estudiante.Domain.dto.EstudianteSearchInputDto;
import com.anderjavi.estudiantes.estudiante.Domain.dto.EstudianteOutputDto;
import com.anderjavi.estudiantes.estudiante.Infraestucture.Repository.port.FindByEstudiantePort;
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
