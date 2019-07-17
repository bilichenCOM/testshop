package com.bilichenko.mvc.testshop.utils;

import java.util.Objects;
import java.util.Properties;

public class MailServiceConfigurer {

    private String username;
    private String password;
    private Properties mailProperties;
    private String from;

    public MailServiceConfigurer() {}
    public MailServiceConfigurer(String username, String password, Properties mailProperties) {
        this.username = username;
        this.password = password;
        this.mailProperties = mailProperties;
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

    public Properties getMailProperties() {
        return mailProperties;
    }

    public void setMailProperties(Properties mailProperties) {
        this.mailProperties = mailProperties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MailServiceConfigurer that = (MailServiceConfigurer) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(mailProperties, that.mailProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, mailProperties);
    }

    @Override
    public String toString() {
        return "MailServiceConfigurer{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mailProperties=" + mailProperties +
                '}';
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}