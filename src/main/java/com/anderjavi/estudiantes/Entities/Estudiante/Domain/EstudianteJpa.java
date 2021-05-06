package com.anderjavi.estudiantes.Entities.Estudiante.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class EstudianteJpa {

    public EstudianteJpa(Estudiante estudiante){
        this.name = estudiante.name;
        this.surname = estudiante.surname;
        this.company_email = estudiante.company_email;
        this.personal_email = estudiante.personal_email;
        this.city = estudiante.city;
        this.numHoursWeek = estudiante.numHoursWeek;
        this.coments = estudiante.coments;
        this.branch = estudiante.branch;
        this.active = estudiante.active;
        this.createdDate = estudiante.createdDate;
        this.terminationDate = estudiante.terminationDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    @GenericGenerator(
            name = "student_sequence",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "student_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "0"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            })
    @Column(name = "id_student")
    Integer id_student;
    @Column(name = "name", nullable = false)
    String name;
    @Column(name = "surname", nullable = false)
    String surname;
    @Column(name = "company_email", nullable = false)
    String company_email;
    @Column(name = "personal_email", nullable = false)
    String personal_email;
    @Column(name = "city", nullable = false)
    String city;
    @Column(name = "numHoursWeek", nullable = false)
    int numHoursWeek;
    @Column(name = "coments")
    String coments;
    @Column(name = "branch", nullable = false)
    String branch;
    @Column(name = "active", nullable = false)
    boolean active;
    @Column(name = "createdDate", nullable = false)
    Date createdDate;
    @Column(name = "terminationDate")
    Date terminationDate;
}
