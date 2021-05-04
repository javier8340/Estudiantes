package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Controller;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.Estudiante;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.DeleteEstudiantePort;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class CreateEstudianteController {

    private CreateEstudianteController createEstudianteController;

    @PostMapping("/api/estudiante/")
    public void create(@RequestBody Estudiante estudiante){
        createEstudianteController.create(estudiante);
    }
}