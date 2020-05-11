package com.example.demo.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Employees {
    @Id
    @Column(name = "employe_id")
    private int id;
    @Size(max=20,message = "El nombre no puede ser mayor a 20 caracteres")
    private String firstName;
    @Column(nullable = false)
    @NotBlank
    @Size(max=25,message = "El apellido no puede ser mayor a 25 caracteres")
    private String lastName;
    @Email
    @NotBlank
    @Column(nullable = false)
    @Size(max=25,message = "El email no puede ser mayor a 25 caracteres")
    private String email;
    @Size(max=20,message = "El Numero no puede ser mayor a 20 caracteres")
    private String phoneNumber;
    @NotBlank
    @Column(nullable = false)
    @DateTimeFormat
    private Date hireDate;
    @ManyToOne
    @JoinColumn(name = "job_id")
    @NotBlank
    private Jobs jobs;
    @Digits(integer = 8,fraction = 2)
    private float salary;
    @Digits(integer = 2,fraction = 2)
    private float commissionPct;
    @OneToOne
    @JoinColumn(name = "manager_id")
    private Employees manager;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departments departments;


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Jobs getJobs() {
        return jobs;
    }

    public void setJobs(Jobs jobs) {
        this.jobs = jobs;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(float commissionPct) {
        this.commissionPct = commissionPct;
    }

    public Employees getManager() {
        return manager;
    }

    public void setManager(Employees manager) {
        this.manager = manager;
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }
}
