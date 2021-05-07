package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Controller;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.Estudiante;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.EstudianteJpa;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.CreateEstudiantePort;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.DeleteEstudiantePort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
@Api(tags = "Estudiante")
@AllArgsConstructor
@RestController
public class CreateEstudianteController {

    private CreateEstudiantePort createEstudiantePort;

    @PostMapping("/api/estudiante/")
    public EstudianteJpa create(@RequestBody Estudiante estudiante) throws Exception {
        return createEstudiantePort.create(estudiante);
    }
}