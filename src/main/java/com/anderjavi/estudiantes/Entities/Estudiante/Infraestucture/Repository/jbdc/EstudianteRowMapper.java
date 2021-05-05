package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.jbdc;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.Estudiante;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstudianteRowMapper implements RowMapper<Estudiante>
{
    @Override
    public Estudiante mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Estudiante(
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("correo"),
                    rs.getDate("fecha_entrada"),
                    rs.getString("ciudad"),
                    rs.getInt("horas_semanales"),
                    rs.getString("especialidad"),
                    rs.getString("estado"));
    }
}
