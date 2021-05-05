package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.Estudiante;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.EstudianteJpa;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.jpa.EstudianteRepositoryJpa;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.FindByIdEstudiantesPort;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.UpdateEstudiantePort;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UpdateEstudianteRepository  implements UpdateEstudiantePort {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void update(int id, Estudiante estudiante) throws Exception {

        jdbcTemplate.update("UPDATE TABLE estudiante_jpa " +
                        "SET nombre = ?," +
                        " apellido = ?," +
                        " correo = ?," +
                        " fecha_entrada = ?," +
                        " ciudad = ?," +
                        " horas_semanales = ?," +
                        " especialidad = ?," +
                        " estado = ?" +
                        " WHERE id = ?",
                estudiante.getNombre(),
                estudiante.getApellido(),
                estudiante.getCorreo(),
                estudiante.getFechaEntrada(),
                estudiante.getCiudad(),
                estudiante.getHorasSemanales(),
                estudiante.getEspecialidad(),
                estudiante.getEstado(),
                id);
    }
}
