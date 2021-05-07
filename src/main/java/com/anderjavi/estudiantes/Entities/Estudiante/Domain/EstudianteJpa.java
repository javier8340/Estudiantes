package com.anderjavi.estudiantes.Entities.Estudiante.Domain;

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

    public EstudianteJpa(Estudiante estudiante){
        this.name = estudiante.name;
        this.surname = estudiante.surname;
        this.companyEmail = estudiante.companyEmail;
        this.personalEmail = estudiante.personalEmail;
        this.city = estudiante.city;
        this.numHoursWeek = estudiante.numHoursWeek;
        this.coments = estudiante.coments;
        this.branch = estudiante.branch;
        this.active = estudiante.active;
        this.createdDate = estudiante.createdDate;
        this.terminationDate = estudiante.terminationDate;
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
    Integer idStudent;
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
