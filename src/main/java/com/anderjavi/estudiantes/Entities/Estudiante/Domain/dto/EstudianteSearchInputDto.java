package com.anderjavi.estudiantes.Entities.Estudiante.Domain.dto;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.Branch;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class EstudianteSearchInputDto {

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
