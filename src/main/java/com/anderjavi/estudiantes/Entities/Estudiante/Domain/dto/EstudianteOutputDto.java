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
        this.active = estudianteJpa.getActive();
        this.createdDate = estudianteJpa.getCreatedDate();
        this.terminationDate = estudianteJpa.getTerminationDate();
    }

    private String Id;
    private String name;
    private String surname;
    private String companyEmail;
    private String personalEmail;
    private String city;
    private Integer numHoursWeek;
    private String coments;
    private Branch branch;
    private Boolean active;
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date createdDate;
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date terminationDate;

}
