package com.anderjavi.estudiantes.Entities.Estudiante.Domain;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.dto.EstudianteInputDto;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.dto.EstudianteOutputDto;
import com.anderjavi.estudiantes.Generator.StringPrefixedSequenceIdGenerator;
import com.anderjavi.estudiantes.validators.ValidDate;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.security.InvalidParameterException;
import java.util.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "company_email", name = "unique_company_email"),
                @UniqueConstraint(columnNames = "personal_email", name = "unique_personal_email"),
                @UniqueConstraint(columnNames = {"name","surname"}, name = "unique_name_surname")
        }
)
public class EstudianteJpa {

    public EstudianteJpa(EstudianteInputDto estudianteInputDto) {
        this.name = estudianteInputDto.getName();
        this.surname = estudianteInputDto.getSurname();
        this.companyEmail = estudianteInputDto.getCompanyEmail();
        this.personalEmail = estudianteInputDto.getPersonalEmail();
        this.city = estudianteInputDto.getCity();
        this.numHoursWeek = estudianteInputDto.getNumHoursWeek();
        this.coments = estudianteInputDto.getComents();
        this.branch = estudianteInputDto.getBranch();
        this.active = estudianteInputDto.getActive();
        this.setTerminationDate(estudianteInputDto.getTerminationDate());
        this.setCreatedDate(estudianteInputDto.getCreatedDate()); //cambio al setter para añadir restricciones
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
        this.active = estudianteOutputDto.getActive();
        this.setTerminationDate(estudianteOutputDto.getTerminationDate());
        this.setCreatedDate(estudianteOutputDto.getCreatedDate()); //cambio al setter para añadir restricciones
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

    @NotNull
    @Column(name = "name", nullable = false)
    String name;

    @NotNull
    @Column(name = "surname")
    String surname;

    @NotNull
    @Column(name = "company_email")
    String companyEmail;

    @NotNull
    @Column(name = "personal_email")
    String personalEmail;

    @NotNull
    @Column(name = "city")
    String city;

    @NotNull
    @Column(name = "num_hours_week")
    Integer numHoursWeek;
    @Column(name = "coments")
    String coments;

    @NotNull
    @Column(name = "branch")
    Branch branch;

    @NotNull
    @Column(name = "active")
    Boolean active;


    @NotNull
    @Column(name = "created_date")
    Date createdDate;
    @Column(name = "termination_date")
    Date terminationDate;

    public void setIdStudent(String idStudent) {
        if (idStudent == null)
            throw new InvalidParameterException("idStudent no puede ser null");
        this.idStudent = idStudent;
    }

    public void setName(String name) {
        if (name == null)
            throw new InvalidParameterException("name no puede ser null");
        this.name = name;
    }

    public void setSurname(String surname) {
        if (surname == null)
            throw new InvalidParameterException("surname no puede ser null");
        this.surname = surname;
    }

    public void setCompanyEmail(String companyEmail) {
        if (companyEmail == null)
            throw new InvalidParameterException("companyEmail no puede ser null");
        this.companyEmail = companyEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        if (personalEmail == null)
            throw new InvalidParameterException("personalEmail no puede ser null");
        this.personalEmail = personalEmail;
    }

    public void setCity(String city) {
        if (city == null)
            throw new InvalidParameterException("city no puede ser null");
        this.city = city;
    }

    public void setNumHoursWeek(Integer numHoursWeek) {
        if (numHoursWeek == null)
            throw new InvalidParameterException("numHoursWeek no puede ser null");
        this.numHoursWeek = numHoursWeek;
    }



    public void setBranch(Branch branch) {
        if (branch == null)
            throw new InvalidParameterException("branch no puede ser null");
        this.branch = branch;
    }

    public void setActive(Boolean active) {
        if (active == null)
            throw new InvalidParameterException("active no puede ser null");
        this.active = active;
    }

    public void setCreatedDate(Date createdDate) {
        if (this.terminationDate != null){
            if (!this.terminationDate.after(createdDate)){
                throw new InvalidParameterException("create date debe ser inferior a termination date");
            }
        }else{
            throw new InvalidParameterException("terminationDate no puede ser null");
        }
        this.createdDate = createdDate;

    }

    public void setTerminationDate(Date terminationDate) {
        if (this.createdDate != null){
            if (!this.createdDate.before(terminationDate)){
                throw new InvalidParameterException("create date debe ser inferior a termination date");
            }
        }
        this.terminationDate = terminationDate;
    }
}
