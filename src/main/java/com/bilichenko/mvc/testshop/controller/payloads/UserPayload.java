package com.bilichenko.mvc.testshop.controller.payloads;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UserPayload {

    @Length(min = 2, max = 1000, message = "you should enter your real name")
    private String name;

    @NotBlank(message = "email field is mandatory")
    @Email(message = "please enter correct email")
    private String email;

    @Pattern(regexp = "[a-zA-Z0-9]{6,47}",
            message = "password should consists only from at least 6 latin letters or numbers")
    private String firstPassword;
    private String secondPassword;

    public UserPayload() {}
    public UserPayload(String name, String email, String firstPassword, String secondPassword) {
        this.name = name;
        this.email = email;
        this.firstPassword = firstPassword;
        this.secondPassword = secondPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstPassword() {
        return firstPassword;
    }

    public void setFirstPassword(String firstPassword) {
        this.firstPassword = firstPassword;
    }

    public String getSecondPassword() {
        return secondPassword;
    }

    public void setSecondPassword(String secondPassword) {
        this.secondPassword = secondPassword;
    }

    @Override
    public String toString() {
        return "UserPayload{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", firstPassword='" + firstPassword + '\'' +
                ", secondPassword='" + secondPassword + '\'' +
                '}';
    }
}