package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Controller;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.dto.EstudianteInputDto;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.dto.EstudianteOutputDto;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.CreateEstudiantePort;
import com.anderjavi.estudiantes.exceptions.ExceptionResolver;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Api(tags = "Estudiante")
@AllArgsConstructor
@RestController
public class CreateEstudianteController {

    private final CreateEstudiantePort createEstudiantePort;
    private final ExceptionResolver exceptionResolver;

    @PostMapping("/api/estudiante/")
    public ResponseEntity create(@RequestBody EstudianteInputDto estudianteInputDto){
        ResponseEntity result;
        try {
            EstudianteOutputDto estudianteOutputDto = createEstudiantePort.create(estudianteInputDto);
            result = new ResponseEntity<EstudianteOutputDto>(estudianteOutputDto,HttpStatus.OK);
        }catch (Exception e){
            result = exceptionResolver.resolver(e);
        }
        return result;
    }

}
