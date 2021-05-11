package com.anderjavi.estudiantes.entities.estudiante.Infraestucture.Controller;


import com.anderjavi.estudiantes.entities.estudiante.Domain.dto.EstudianteOutputDto;
import com.anderjavi.estudiantes.entities.estudiante.Infraestucture.Repository.port.FindAllEstudiantesPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Estudiante")
@AllArgsConstructor
@RestController
public class FindAllEstudiantesController {

    private FindAllEstudiantesPort findEstudiantePort;

    @GetMapping("/api/estudiante")
    public List<EstudianteOutputDto> findAll() {
        return findEstudiantePort.findAll();
    }
}
