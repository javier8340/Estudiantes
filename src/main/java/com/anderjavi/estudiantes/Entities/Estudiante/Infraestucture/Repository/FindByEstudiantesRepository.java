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
        
        Predicate finalPredicate = getPredicate(busquedaEstudianteInput, criteriaBuilder, estudiante);

        criteriaQuery.where(finalPredicate);

        TypedQuery<EstudianteJpa> query = entityManager.createQuery(criteriaQuery);

        List<EstudianteJpa> resultado =  query.getResultList();
        return  resultado.stream().map(
                item-> new Estudiante(item))
                .collect(Collectors.toList());


    }

    private Predicate getPredicate(BusquedaEstudianteInput busquedaEstudianteInput, CriteriaBuilder criteriaBuilder, Root<EstudianteJpa> estudiante) {
        Predicate finalPredicate = null;
        if (busquedaEstudianteInput.getName() != null){
            Predicate predicado = criteriaBuilder.equal(estudiante.get("nombre"), busquedaEstudianteInput.getName());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }

        if (busquedaEstudianteInput.getSurname() != null){
            Predicate predicado = criteriaBuilder.equal(estudiante.get("apellido"), busquedaEstudianteInput.getSurname());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (busquedaEstudianteInput.getCompany_email() != null){
            Predicate predicado = criteriaBuilder.equal(estudiante.get("correo"), busquedaEstudianteInput.getCompany_email());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (busquedaEstudianteInput.getCreatedDate() != null){
            Predicate predicado = criteriaBuilder.equal(estudiante.get("fechaEntrada"), busquedaEstudianteInput.getCreatedDate());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (busquedaEstudianteInput.getCity() != null){
            Predicate predicado = criteriaBuilder.equal(estudiante.get("ciudad"), busquedaEstudianteInput.getCity());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (busquedaEstudianteInput.getNumHoursWeek() != 0){
            Predicate predicado = criteriaBuilder.equal(estudiante.get("horasSemanales"), busquedaEstudianteInput.getNumHoursWeek());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (busquedaEstudianteInput.getBranch() != null){
            Predicate predicado = criteriaBuilder.equal(estudiante.get("especialidad"), busquedaEstudianteInput.getBranch());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (busquedaEstudianteInput.isActive()){
            Predicate predicado = criteriaBuilder.equal(estudiante.get("estado"), busquedaEstudianteInput.isActive());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        return finalPredicate;
    }
}
