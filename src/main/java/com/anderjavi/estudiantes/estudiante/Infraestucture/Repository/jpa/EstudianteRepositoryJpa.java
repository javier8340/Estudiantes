package com.anderjavi.estudiantes.estudiante.Infraestucture.Repository.jpa;

import com.anderjavi.estudiantes.estudiante.Domain.EstudianteJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepositoryJpa extends JpaRepository<EstudianteJpa, String> {
}
