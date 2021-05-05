package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.jbdc;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.Estudiante;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstudianteListRowMapper implements RowMapper<List<Estudiante>>
{
    @Override
    public List<Estudiante> mapRow(ResultSet rs, int rowNum) throws SQLException {
        ArrayList<Estudiante> listaUsuarios = new ArrayList();
        do
        {
            listaUsuarios.add(new Estudiante(
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("correo"),
                    rs.getDate("fecha_entrada"),
                    rs.getString("ciudad"),
                    rs.getInt("horas_semanales"),
                    rs.getString("especialidad"),
                    rs.getString("estado")));
        } while (rs.next());
        return listaUsuarios;
    }
}
