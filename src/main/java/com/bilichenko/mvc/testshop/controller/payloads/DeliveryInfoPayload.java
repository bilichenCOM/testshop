package com.bilichenko.mvc.testshop.controller.payloads;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class DeliveryInfoPayload {

    @Length(min = 2, max = 1000, message = "please enter your firs name")
    private String firstName;

    @Length(min = 2, max = 1000, message = "please enter your last name")
    private String lastName;

    @NotBlank
    private String country;

    @Length(min = 2, max = 100, message = "incorrect city name")
    private String city;

    @Pattern(regexp = "(\\w+[\\s\\w]*,?\\s+\\d+)|(\\d+\\s*,?\\s+\\w+[\\w\\s]*)", message = "incorrect street name")
    private String street;

    @Pattern(regexp = "\\d+", message = "incorrect zip-code")
    private String zip;

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "DeliveryInfoPayload{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}