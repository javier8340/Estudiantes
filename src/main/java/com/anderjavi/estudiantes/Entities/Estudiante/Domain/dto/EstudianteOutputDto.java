package com.anderjavi.estudiantes.Entities.Estudiante.Domain.dto;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.Branch;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.EstudianteJpa;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EstudianteOutputDto {

    public EstudianteOutputDto(EstudianteJpa estudianteJpa){
        this.Id = estudianteJpa.getIdStudent();
        this.name = estudianteJpa.getName();
        this.surname = estudianteJpa.getSurname();
        this.companyEmail = estudianteJpa.getCompanyEmail();
        this.personalEmail = estudianteJpa.getPersonalEmail();
        this.city = estudianteJpa.getCity();
        this.numHoursWeek = estudianteJpa.getNumHoursWeek();
        this.coments = estudianteJpa.getComents();
        this.branch = estudianteJpa.getBranch();
        this.active = estudianteJpa.isActive();
        this.createdDate = estudianteJpa.getCreatedDate();
        this.terminationDate = estudianteJpa.getTerminationDate();
    }

    String Id;
    String name;
    String surname;
    String companyEmail;
    String personalEmail;
    String city;
    int numHoursWeek;
    String coments;
    Branch branch;
    boolean active;
    @JsonFormat(pattern = "MM/dd/yyyy")
    Date createdDate;
    @JsonFormat(pattern = "MM/dd/yyyy")
    Date terminationDate;

}
