package com.anderjavi.estudiantes.Entities.Estudiante.Domain.dto;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.Branch;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class EstudianteSearchInputDto {

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
