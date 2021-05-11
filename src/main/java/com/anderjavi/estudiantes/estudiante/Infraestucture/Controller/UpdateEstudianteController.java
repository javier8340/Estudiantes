package com.anderjavi.estudiantes.estudiante.Infraestucture.Controller;

import com.anderjavi.estudiantes.estudiante.Domain.dto.EstudianteInputDto;
import com.anderjavi.estudiantes.estudiante.Infraestucture.Repository.port.UpdateEstudiantePort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Estudiante")
@RestController
@AllArgsConstructor
public class UpdateEstudianteController {

    private UpdateEstudiantePort updateEstudiantePort;

    @PutMapping("/api/estudiante/{id}")
    public void create(@RequestBody EstudianteInputDto estudianteInputDto, @PathVariable String id) throws Exception {
        updateEstudiantePort.update(id,estudianteInputDto);
    }

}
