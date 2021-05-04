package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.Estudiante;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.EstudianteJpa;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.dto.BusquedaEstudianteInput;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.FindByEstudiantesPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class FindByEstudiantesRepository implements FindByEstudiantesPort {

    EntityManager entityManager;

    @Override
    public List<Estudiante> findBy(BusquedaEstudianteInput busquedaEstudianteInput) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<EstudianteJpa> criteriaQuery = criteriaBuilder.createQuery(EstudianteJpa.class);

        Root<EstudianteJpa> estudiante = criteriaQuery.from(EstudianteJpa.class);


        Predicate finalPredicate = null;

        if (busquedaEstudianteInput.getNombre() != null){
            Predicate predicado = criteriaBuilder.equal(estudiante.get("nombre"),busquedaEstudianteInput.getNombre());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }

        if (busquedaEstudianteInput.getApellido() != null){
            Predicate predicado = criteriaBuilder.equal(estudiante.get("apellido"),busquedaEstudianteInput.getApellido());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (busquedaEstudianteInput.getCorreo() != null){
            Predicate predicado = criteriaBuilder.equal(estudiante.get("correo"),busquedaEstudianteInput.getCorreo());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (busquedaEstudianteInput.getFechaEntrada() != null){
            Predicate predicado = criteriaBuilder.equal(estudiante.get("fechaEntrada"),busquedaEstudianteInput.getFechaEntrada());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (busquedaEstudianteInput.getCiudad() != null){
            Predicate predicado = criteriaBuilder.equal(estudiante.get("ciudad"),busquedaEstudianteInput.getCiudad());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (busquedaEstudianteInput.getHorasSemanales() != 0){
            Predicate predicado = criteriaBuilder.equal(estudiante.get("horasSemanales"),busquedaEstudianteInput.getHorasSemanales());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (busquedaEstudianteInput.getEspecialidad() != null){
            Predicate predicado = criteriaBuilder.equal(estudiante.get("especialidad"),busquedaEstudianteInput.getEspecialidad());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (busquedaEstudianteInput.getEstado() != null){
            Predicate predicado = criteriaBuilder.equal(estudiante.get("estado"),busquedaEstudianteInput.getEstado());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }


        criteriaQuery.where(finalPredicate);

        TypedQuery<EstudianteJpa> query = entityManager.createQuery(criteriaQuery);

        List<EstudianteJpa> resultado =  query.getResultList();
        return  resultado.stream().map(
                item-> new Estudiante(item))
                .collect(Collectors.toList());


    }
}
