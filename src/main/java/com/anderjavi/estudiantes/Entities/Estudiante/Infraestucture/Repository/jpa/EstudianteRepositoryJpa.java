package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.jpa;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.EstudianteJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepositoryJpa extends JpaRepository<EstudianteJpa, String> {
}
