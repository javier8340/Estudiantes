package com.anderjavi.estudiantes.Entities.Estudiante.Domain;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.dto.EstudianteInputDto;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.dto.EstudianteOutputDto;
import com.anderjavi.estudiantes.Generator.StringPrefixedSequenceIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class EstudianteJpa {

    public EstudianteJpa(EstudianteInputDto estudianteInputDto){
        this.name = estudianteInputDto.getName();
        this.surname = estudianteInputDto.getSurname();
        this.companyEmail = estudianteInputDto.getCompanyEmail();
        this.personalEmail = estudianteInputDto.getPersonalEmail();
        this.city = estudianteInputDto.getCity();
        this.numHoursWeek = estudianteInputDto.getNumHoursWeek();
        this.coments = estudianteInputDto.getComents();
        this.branch = estudianteInputDto.getBranch();
        this.active = estudianteInputDto.isActive();
        this.createdDate = estudianteInputDto.getCreatedDate();
        this.terminationDate = estudianteInputDto.getTerminationDate();
    }
    public EstudianteJpa(EstudianteOutputDto estudianteOutputDto){
        this.name = estudianteOutputDto.getName();
        this.surname = estudianteOutputDto.getSurname();
        this.companyEmail = estudianteOutputDto.getCompanyEmail();
        this.personalEmail = estudianteOutputDto.getPersonalEmail();
        this.city = estudianteOutputDto.getCity();
        this.numHoursWeek = estudianteOutputDto.getNumHoursWeek();
        this.coments = estudianteOutputDto.getComents();
        this.branch = estudianteOutputDto.getBranch();
        this.active = estudianteOutputDto.isActive();
        this.createdDate = estudianteOutputDto.getCreatedDate();
        this.terminationDate = estudianteOutputDto.getTerminationDate();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estudiantes_seq")
    @GenericGenerator(
            name = "estudiantes_seq",
            strategy = "com.anderjavi.estudiantes.Generator.StringPrefixedSequenceIdGenerator",
            parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "EST"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")
            })
    @Column(name = "id_student")
    String idStudent;
    @Column(name = "name", nullable = false)
    String name;
    @Column(name = "surname", nullable = false)
    String surname;
    @Column(name = "company_email", nullable = false)
    String companyEmail;
    @Column(name = "personal_email", nullable = false)
    String personalEmail;
    @Column(name = "city", nullable = false)
    String city;
    @Column(name = "num_hours_week", nullable = false)
    int numHoursWeek;
    @Column(name = "coments")
    String coments;
    @Column(name = "branch", nullable = false)
    String branch;
    @Column(name = "active", nullable = false)
    boolean active;
    @Column(name = "created_date", nullable = false)
    Date createdDate;
    @Column(name = "termination_date")
    Date terminationDate;
}
