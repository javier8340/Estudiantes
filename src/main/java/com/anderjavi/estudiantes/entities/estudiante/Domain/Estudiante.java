package com.anderjavi.estudiantes.entities.estudiante.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor @NoArgsConstructor @Data
public class Estudiante {

    public Estudiante(EstudianteJpa estudianteJpa){
        this.name = estudianteJpa.name;
        this.surname = estudianteJpa.surname;
        this.companyEmail = estudianteJpa.companyEmail;
        this.personalEmail = estudianteJpa.personalEmail;
        this.city = estudianteJpa.city;
        this.numHoursWeek = estudianteJpa.numHoursWeek;
        this.coments = estudianteJpa.coments;
        this.branch = estudianteJpa.branch;
        this.active = estudianteJpa.active;
        this.createdDate = estudianteJpa.createdDate;
        this.terminationDate = estudianteJpa.terminationDate;
    }

    private String name;
    private String surname;
    private String companyEmail;
    private String personalEmail;
    private String city;
    private Integer numHoursWeek;
    private String coments;
    private Branch branch;
    private Boolean active;
//    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date createdDate;
//    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date terminationDate;
}
