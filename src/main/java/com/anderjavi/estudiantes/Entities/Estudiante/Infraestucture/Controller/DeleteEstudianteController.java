package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Controller;

import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.DeleteEstudiantePort;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class DeleteEstudianteController {

    private DeleteEstudiantePort deleteEstudiantePort;

    @DeleteMapping("{id_estudiante}")
    public void delete(@PathVariable("id_estudiante") int idEstudiante){
        deleteEstudiantePort.deleteById(idEstudiante);
    }
}
