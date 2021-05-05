package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.Estudiante;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.EstudianteJpa;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.CreateEstudiantePort;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class CreateEstudianteRepository implements CreateEstudiantePort {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void DynamicRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public EstudianteJpa create(Estudiante estudiante) throws Exception {
        jdbcTemplate.update("INSERT INTO ESTUDIANTE_JPA  (id,nombre, apellido,correo,fecha_entrada,ciudad,horas_semanales,especialidad,estado) " +
                "VALUES (0,?,?,?,?,?,?,?,?)",
                estudiante.getNombre(),estudiante.getApellido(),estudiante.getCorreo(),estudiante.getFechaEntrada(),
                estudiante.getCiudad(),estudiante.getHorasSemanales(),estudiante.getEspecialidad(),estudiante.getEstado());
        return null;
    }
}


