package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.BusquedaCampos;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.Estudiante;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.EstudianteJpa;
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
    public List<Estudiante> findBy(BusquedaCampos busquedaCampos) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<EstudianteJpa> criteriaQuery = criteriaBuilder.createQuery(EstudianteJpa.class);

        Root<EstudianteJpa> estudiante = criteriaQuery.from(EstudianteJpa.class);

        Predicate finalPredicate = null;
        for (int i = 0; i < busquedaCampos.getCampos().size(); i++) {
            String campo = busquedaCampos.getCampos().get(i);
            String valor = busquedaCampos.getValores().get(i);

            Predicate predicado = criteriaBuilder.equal(estudiante.get(campo),valor);
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
