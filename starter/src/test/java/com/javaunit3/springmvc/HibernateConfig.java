package com.javaunit3.springmvc;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateConfig {
    @Bean
    public SessionFactory getFactory() throws HibernateException {
        org.hibernate.cfg.Configuration f = new org.hibernate.cfg.Configuration();
        
        SessionFactory factory = f.configure("hibernate.cfg.xml")
        .buildSessionFactory();
        return factory;
    }       
}

    