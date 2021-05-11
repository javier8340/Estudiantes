package com.anderjavi.estudiantes.entities.estudiante.Infraestucture.Controller;

import com.anderjavi.estudiantes.entities.estudiante.Domain.dto.EstudianteOutputDto;
import com.anderjavi.estudiantes.entities.estudiante.Infraestucture.Repository.port.FindByIdEstudiantesPort;
import com.anderjavi.estudiantes.entities.estudiante.application.exceptions.EstudianteNotFoundException;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Estudiante")
@AllArgsConstructor
@RestController
public class FindByIdEstudiantesController {

    private FindByIdEstudiantesPort findByIdEstudiantesPort;

    @GetMapping("/api/estudiante/{id}")
    public EstudianteOutputDto findById(@PathVariable("id") String id) throws EstudianteNotFoundException {
        return findByIdEstudiantesPort.findById(id);
    }
}
