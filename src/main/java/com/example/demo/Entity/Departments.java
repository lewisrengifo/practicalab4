package com.example.demo.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Departments {

    @Id
    private int department_id;

    @NotBlank
    @Size(max = 30, message = "el nombre no puede tener más de 30 caracteres")
    private String department_name;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employees manager;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
    @NotBlank
    @Size(max = 2, message = "no debe tener mas de 2 caracteres")
    private String department_short_name;

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public Employees getManager() {
        return manager;
    }

    public void setManager(Employees manager) {
        this.manager = manager;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getDepartment_short_name() {
        return department_short_name;
    }

    public void setDepartment_short_name(String department_short_name) {
        this.department_short_name = department_short_name;
    }
}
