package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Controller;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.BusquedaCampos;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.Estudiante;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.EstudianteJpa;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.FindByEstudiantesPort;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class FindByEstudianteController {

    FindByEstudiantesPort findByEstudiantesPort;

    @PostMapping("/api/estudiante/findby")
    public List<Estudiante> findById(@RequestBody BusquedaCampos busquedaCampos) throws Exception {
        return findByEstudiantesPort.findBy(busquedaCampos);
    }
}
