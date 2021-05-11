package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Controller;

import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.jpa.EstudianteRepositoryJpa;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.DeleteEstudiantePort;
import com.anderjavi.estudiantes.exceptions.ExceptionResolver;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Estudiante")
@AllArgsConstructor
@RestController
public class DeleteEstudianteController {

    private DeleteEstudiantePort deleteEstudiantePort;
    private ExceptionResolver exceptionResolver;

    @DeleteMapping("/api/estudiante/{id_estudiante}")
    public ResponseEntity<String> delete(@PathVariable("id_estudiante") String idEstudiante){
        ResponseEntity<String> result;
        try {
            deleteEstudiantePort.deleteById(idEstudiante);
            result = new ResponseEntity<String>("ok", HttpStatus.OK);
        }catch (Exception e){
            result = exceptionResolver.resolver(e);
        }
        return result;
    }
}
