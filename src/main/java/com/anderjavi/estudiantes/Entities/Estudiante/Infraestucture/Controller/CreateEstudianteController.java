package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Controller;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.dto.EstudianteInputDto;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.dto.EstudianteOutputDto;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.CreateEstudiantePort;
import com.anderjavi.estudiantes.exceptions.resolver.ExceptionResolver;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
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
    public ResponseEntity<EstudianteOutputDto> create(@RequestBody EstudianteInputDto estudianteInputDto){


            EstudianteOutputDto estudianteOutputDto = createEstudiantePort.create(estudianteInputDto);
        return new ResponseEntity<EstudianteOutputDto>(estudianteOutputDto,HttpStatus.OK);


    }

}
