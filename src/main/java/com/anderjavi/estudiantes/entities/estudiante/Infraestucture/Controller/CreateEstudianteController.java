package com.anderjavi.estudiantes.entities.estudiante.Infraestucture.Controller;


import com.anderjavi.estudiantes.entities.estudiante.Domain.dto.EstudianteInputDto;
import com.anderjavi.estudiantes.entities.estudiante.Domain.dto.EstudianteOutputDto;
import com.anderjavi.estudiantes.entities.estudiante.Infraestucture.Repository.port.CreateEstudiantePort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@Api(tags = "Estudiante")
@AllArgsConstructor
@RestController
public class CreateEstudianteController {

    private final CreateEstudiantePort createEstudiantePort;

    @PostMapping("/api/estudiante/")
    public ResponseEntity<EstudianteOutputDto> create(@RequestBody EstudianteInputDto estudianteInputDto){


            EstudianteOutputDto estudianteOutputDto = createEstudiantePort.create(estudianteInputDto);
        return new ResponseEntity<EstudianteOutputDto>(estudianteOutputDto,HttpStatus.OK);


    }

}
