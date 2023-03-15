package com.javaunit3.springmvc;

import org.hibernate.SessionFactory;

public class HibernateConfig {
    SessionFactory factory = new org.hibernate.cfg.Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(MovieEntity.class)
        .buildSessionFactory();
}
