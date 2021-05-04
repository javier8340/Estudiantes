package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Controller;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.Estudiante;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.CreateEstudiantePort;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.DeleteEstudiantePort;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class CreateEstudianteController {

    private CreateEstudiantePort createEstudiantePort;

    @PostMapping("/api/estudiante/")
    public void create(@RequestBody Estudiante estudiante) throws Exception {
        createEstudiantePort.create(estudiante);
    }
}