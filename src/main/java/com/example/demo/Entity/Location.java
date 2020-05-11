package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Location {

    @Id
    private int locaction_id;
    @Size(max = 40)
    private String street_address;
    @Size(max = 12)
    private String postal_code;
    @NotBlank
    @Size(max = 30)
    private String city;
    @Size(max = 25)
    private String state_province;
    @Size(max = 2)
    private String country_id;

    public int getLocaction_id() {
        return locaction_id;
    }

    public void setLocaction_id(int locaction_id) {
        this.locaction_id = locaction_id;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState_province() {
        return state_province;
    }

    public void setState_province(String state_province) {
        this.state_province = state_province;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }
}
