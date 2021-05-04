package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Controller;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.Estudiante;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.CreateEstudiantePort;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.UpdateEstudiantePort;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UpdateEstudianteController {

    private UpdateEstudiantePort updateEstudiantePort;

    @PutMapping("/api/estudiante/{id}")
    public void create(@RequestBody Estudiante estudiante, @PathVariable int id) throws Exception {
        updateEstudiantePort.update(id,estudiante);
    }

}
