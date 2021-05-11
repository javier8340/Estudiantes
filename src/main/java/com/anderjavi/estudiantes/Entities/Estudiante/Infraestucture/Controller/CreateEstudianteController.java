package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Controller;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.Estudiante;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.EstudianteJpa;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.dto.EstudianteInputDto;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.dto.EstudianteOutputDto;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.CreateEstudiantePort;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.DeleteEstudiantePort;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.customError.EstudianteNotCreatedException;
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

    private CreateEstudiantePort createEstudiantePort;

    /*@PostMapping("/api/estudiante/")
    public ResponseEntity<Object> create(@RequestBody EstudianteInputDto estudianteInputDto) {
        try{
            return new ResponseEntity<>(createEstudiantePort.create(estudianteInputDto), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }*/

    @PostMapping("/api/estudiante/")
    public ResponseEntity create(@RequestBody EstudianteInputDto estudianteInputDto){
        EstudianteOutputDto estudianteOutputDto = null;

        try {
            estudianteOutputDto = createEstudiantePort.create(estudianteInputDto);
            return new ResponseEntity<EstudianteOutputDto>(estudianteOutputDto,HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            String message = e.getMostSpecificCause().getMessage();
            return new ResponseEntity<String>("{status:401,message:"+
                    message+
                    "}",HttpStatus.UNAUTHORIZED);
        }catch (Exception e) {
            return new ResponseEntity<String>("{status:401,message:"+e.getCause().getMessage()+"}",HttpStatus.UNAUTHORIZED);
        }
//        return estudianteOutputDto;
    }
}
