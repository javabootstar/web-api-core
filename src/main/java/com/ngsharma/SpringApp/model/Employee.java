package com.ngsharma.SpringApp.model;

import com.ngsharma.SpringApp.custom.annotation.Mobile;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Size(min = 2, max = 20, message = "{employee.firstname.size}")
    @NotNull(message = "{employee.firstname.not.null}")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Size(min = 2, max = 20, message = "{employee.lastname.size}")
    @NotNull(message = "{employee.lastname.not.null}")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Size(min=10,max=10)
    @Pattern(regexp="(^$|[0-9]{10})")
    private String mobile;

    @NotNull(message = "{employee.professional.not.null}")
    @Size(min = 3, max = 20, message = "{employee.professional.size}")
    private String professional;

    @Column(name = "DOB")
    private LocalDate birth;

    @Embedded
    private Address address;

    @CreatedBy
    @Column(nullable = false, name = "create_by", updatable = false)
    private String createBy;


    @LastModifiedBy
    @Column(nullable = false, name = "lastModified_by")
    private String lastModifiedBy;

    @CreatedDate
    @Column(nullable = false, name = "creation_date", updatable = false)
    private LocalDateTime creationDate;

    @LastModifiedDate
    @Column(nullable = false, name = "lastModified_date")
    private LocalDateTime lastModifiedDate;

    public Employee(){}

    public Employee(String firstName, String lastName, String mobile,String professional, LocalDate birth, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.professional = professional;
        this.birth = birth;
        this.address = address;
    }

    public Employee(Integer id, String firstName, String lastName, String mobile,String professional, LocalDate birth, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.professional = professional;
        this.birth = birth;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", professional='" + professional + '\'' +
                ", birth=" + birth +
                ", address=" + address +
                ", createBy='" + createBy + '\'' +
                ", lastModifiedBy='" + lastModifiedBy + '\'' +
                ", creationDate=" + creationDate +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}
