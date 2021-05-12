package com.anderjavi.estudiantes.entities.estudiante.Infraestucture.Controller;


import com.anderjavi.estudiantes.entities.estudiante.Domain.dto.EstudianteInputDto;
import com.anderjavi.estudiantes.entities.estudiante.Infraestucture.Repository.port.UpdateEstudiantePort;
import com.anderjavi.estudiantes.entities.estudiante.application.exceptions.UpdateException;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = "Estudiante")
@RestController
@AllArgsConstructor
public class UpdateEstudianteController {

    private UpdateEstudiantePort updateEstudiantePort;

    @PutMapping("/api/estudiante/{id}")
    public void create(@RequestBody EstudianteInputDto estudianteInputDto, @PathVariable String id) {
        try{
        updateEstudiantePort.update(id,estudianteInputDto);
        } catch (Exception e) {
            log.error("Error al actualizar estudiante -> " + e.getMessage());
            throw new UpdateException(estudianteInputDto, id);
        }
    }
}
