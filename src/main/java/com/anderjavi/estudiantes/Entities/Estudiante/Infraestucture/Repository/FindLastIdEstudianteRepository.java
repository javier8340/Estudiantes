package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository;

import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.FindLastIdEstudiantePort;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class FindLastIdEstudianteRepository implements FindLastIdEstudiantePort {

    private JdbcTemplate jdbcTemplate;


    @Autowired
    public void DynamicRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Integer getLastId() {

        return 0;
    }
}
