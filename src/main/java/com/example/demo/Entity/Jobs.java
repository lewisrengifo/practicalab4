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

    public Employees getJob_id() {
        return job_id;
    }

    public void setJob_id(Employees job_id) {
        this.job_id = job_id;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public int getMin_salary() {
        return min_salary;
    }

    public void setMin_salary(int min_salary) {
        this.min_salary = min_salary;
    }

    public int getMax_salary() {
        return max_salary;
    }

    public void setMax_salary(int max_salary) {
        this.max_salary = max_salary;
    }
}
