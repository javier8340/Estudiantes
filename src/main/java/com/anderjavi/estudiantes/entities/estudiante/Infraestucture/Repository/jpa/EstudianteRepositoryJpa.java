package com.anderjavi.estudiantes.entities.estudiante.Infraestucture.Repository.jpa;


import com.anderjavi.estudiantes.entities.estudiante.Domain.EstudianteJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepositoryJpa extends JpaRepository<EstudianteJpa, String> {
}
