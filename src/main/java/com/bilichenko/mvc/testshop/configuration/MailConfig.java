package com.bilichenko.mvc.testshop.configuration;

import com.bilichenko.mvc.testshop.utils.MailServiceConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Properties;

@Configuration
@PropertySource("classpath:mail.properties")
public class MailConfig {

    @Bean
    public MailServiceConfigurer getMailConfigurer(Environment env) {
        MailServiceConfigurer configurer = new MailServiceConfigurer();
        configurer.setUsername(env.getProperty("username"));
        configurer.setPassword(env.getProperty("password"));
        configurer.setFrom(env.getProperty("from"));

        Properties prop = new Properties();
        prop.put("mail.smtp.host", env.getProperty("mail.smtp.host"));
        prop.put("mail.smtp.port", env.getProperty("mail.smtp.port"));
        prop.put("mail.smtp.auth", env.getProperty("mail.smtp.auth"));
        prop.put("mail.smtp.socketFactory.port", env.getProperty("mail.smtp.socketFactory.port"));
        prop.put("mail.smtp.socketFactory.class", env.getProperty("mail.smtp.socketFactory.class"));

        configurer.setMailProperties(prop);

        return configurer;
    }
}
