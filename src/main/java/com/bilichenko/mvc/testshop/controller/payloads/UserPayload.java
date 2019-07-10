package com.bilichenko.mvc.testshop.controller.payloads;

public class UserPayload {

    private String name;
    private String email;
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