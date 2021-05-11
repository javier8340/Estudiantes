package com.anderjavi.estudiantes.estudiante.Infraestucture.Repository;

import com.anderjavi.estudiantes.estudiante.Domain.EstudianteJpa;
import com.anderjavi.estudiantes.estudiante.Domain.dto.EstudianteSearchInputDto;
import com.anderjavi.estudiantes.estudiante.Domain.dto.EstudianteOutputDto;
import com.anderjavi.estudiantes.estudiante.Infraestucture.Repository.port.FindByEstudiantePort;
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
public class FindByEstudianteRepository implements FindByEstudiantePort {

    EntityManager entityManager;

    @Override
    public List<EstudianteOutputDto> findBy(EstudianteSearchInputDto estudianteSearchInputDto) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<EstudianteJpa> criteriaQuery = criteriaBuilder.createQuery(EstudianteJpa.class);

        Root<EstudianteJpa> estudiante = criteriaQuery.from(EstudianteJpa.class);
        
        Predicate finalPredicate = getPredicate(estudianteSearchInputDto, criteriaBuilder, estudiante);

        criteriaQuery.where(finalPredicate);

        TypedQuery<EstudianteJpa> query = entityManager.createQuery(criteriaQuery);

        List<EstudianteJpa> resultado =  query.getResultList();
        return  resultado.stream().map(
                item-> new EstudianteOutputDto(item))
                .collect(Collectors.toList());


    }

    private Predicate getPredicate(EstudianteSearchInputDto estudianteSearchInputDto, CriteriaBuilder criteriaBuilder, Root<EstudianteJpa> estudiante) {
        Predicate finalPredicate = null;
        if (estudianteSearchInputDto.getName() != null){
            Predicate predicado = criteriaBuilder.equal(estudiante.get("name"), estudianteSearchInputDto.getName());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }

        if (estudianteSearchInputDto.getSurname() != null){
            Predicate predicado = criteriaBuilder.equal(estudiante.get("surname"), estudianteSearchInputDto.getSurname());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (estudianteSearchInputDto.getCompanyEmail() != null){
            Predicate predicado = criteriaBuilder.equal(estudiante.get("companyEmail"), estudianteSearchInputDto.getCompanyEmail());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (estudianteSearchInputDto.getPersonalEmail() != null){
            Predicate predicado = criteriaBuilder.equal(estudiante.get("personalEmail"), estudianteSearchInputDto.getPersonalEmail());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (estudianteSearchInputDto.getCity() != null){
            Predicate predicado = criteriaBuilder.equal(estudiante.get("city"), estudianteSearchInputDto.getCity());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (estudianteSearchInputDto.getNumHoursWeek() != null){
            Predicate predicado = criteriaBuilder.equal(estudiante.get("numHoursWeek"), estudianteSearchInputDto.getNumHoursWeek());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (estudianteSearchInputDto.getComents() != null){
            Predicate predicado = criteriaBuilder.equal(estudiante.get("coments"), estudianteSearchInputDto.getComents());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (estudianteSearchInputDto.getBranch() != null){
            Predicate predicado = criteriaBuilder.equal(estudiante.get("branch"), estudianteSearchInputDto.getBranch());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (estudianteSearchInputDto.getActive() != null){
            Predicate predicado = criteriaBuilder.equal(estudiante.get("active"), estudianteSearchInputDto.getActive());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (estudianteSearchInputDto.getCreatedDate() != null){
            Predicate predicado = criteriaBuilder.equal(estudiante.get("createdDate"), estudianteSearchInputDto.getCreatedDate());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        if (estudianteSearchInputDto.getTerminationDate() != null){
            Predicate predicado = criteriaBuilder.equal(estudiante.get("terminationDate"), estudianteSearchInputDto.getTerminationDate());

            if (finalPredicate != null){
                finalPredicate = criteriaBuilder.and(finalPredicate,predicado);
            }else{
                finalPredicate = predicado;
            }
        }
        return finalPredicate;
    }
}
