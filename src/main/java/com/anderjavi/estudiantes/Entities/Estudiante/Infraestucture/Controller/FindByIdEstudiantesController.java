package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Controller;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.EstudianteJpa;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.FindAllEstudiantesPort;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.FindByIdEstudiantesPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Estudiante")
@AllArgsConstructor
@RestController
public class FindByIdEstudiantesController {

    private FindByIdEstudiantesPort findByIdEstudiantesPort;

    @GetMapping("/api/estudiante/{id}")
    public EstudianteJpa findById(@PathVariable("id") String id) throws Exception {
        return findByIdEstudiantesPort.findById(id);
    }
}
