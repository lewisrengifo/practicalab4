package com.example.demo.Entity;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "jobs")
public class Jobs {
    @Id
    @OneToMany
    @JoinColumn(name = "job_id")
    @Digits(integer = 10,fraction = 0)
    @Positive
    private Employees job_id;
    @Column(nullable = false)
    @NotBlank
    @Size(max=40)
    private String job_title;
    @Digits(integer = 6, fraction = 0)
    @Positive
    private int min_salary;
    @Digits(integer = 6, fraction = 0)
    @Positive
    private int max_salary;
}
