package com.anderjavi.estudiantes.Entities.Estudiante.Domain;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    String name;
    String surname;
    String companyEmail;
    String personalEmail;
    String city;
    int numHoursWeek;
    String coments;
    String branch;
    boolean active;
    @JsonFormat(pattern = "MM/dd/yyyy")
    Date createdDate;
    @JsonFormat(pattern = "MM/dd/yyyy")
    Date terminationDate;
}
