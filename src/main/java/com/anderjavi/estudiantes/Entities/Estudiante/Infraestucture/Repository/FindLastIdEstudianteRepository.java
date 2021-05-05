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
        int result = 0;
        try {
            result = jdbcTemplate.queryForObject(
                    "SELECT max(id) FROM estudiante_jpa", Integer.class);
        }catch (Exception ignored){}
        return ++result;
    }
}
