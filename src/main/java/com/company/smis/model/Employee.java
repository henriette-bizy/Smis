package com.company.smis.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 10, nullable = false)
    private long id;
    @Column(name = "firstname", length = 100, nullable = false)
    private String firstName;
    @Column(name = "lastname", length = 100, nullable = false)
    private String lastName;
    @Column(name = "telephone", length = 10, nullable = false)
    private Integer telephone;
    @Column(name = "email", length = 50, nullable = false)
    private String email;
    @Column(name = "username", length = 50, nullable = false, unique = true)
    private String username;
    @Column(name = "password", length = 128, nullable = false, unique = true)
    private String password;
    @Column(name = "dob", nullable = false)
    private LocalDate dob;
    @Column(name = "gender", length = 10, nullable = false)
    private String gender;
    @Column(name = "Age", length = 10, nullable = false)
    @Transient
    private Integer age;



    @ManyToOne
    @JoinColumn(name ="did",nullable = false)
    public Department department;


    public Employee() {
    }

    public Employee(long id, String firstName, String lastName, Integer telephone, String email, String username, String password, LocalDate dob, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.email = email;
        this.username = username;
        this.password = password;
        this.dob = dob;
        this.gender = gender;
    }
    public Employee( String firstName, String lastName, Integer telephone, String email, String username, String password, LocalDate dob, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.email = email;
        this.username = username;
        this.password = password;
        this.dob = dob;
        this.gender = gender;
    }

    public Employee(String firstName, String lastName, Integer telephone, String email, String username, String password, LocalDate dob, String gender, Integer age, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.email = email;
        this.username = username;
        this.password = password;
        this.dob = dob;
        this.gender = gender;
        this.age = age;
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        LocalDate date = LocalDate.now();
        Integer age =  null;
        if (this.dob != null) {
           age = Period.between(dob, date).getYears();
        }

        return age;
    }


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}



