package com.qsheker.school.utils;


import com.qsheker.school.util.HibernateUtil;
import lombok.experimental.UtilityClass;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.testcontainers.containers.PostgreSQLContainer;

@UtilityClass
public class HibernateUtilTest {
    private static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15");
    static {
        if (System.getenv("DISABLE_TESTCONTAINERS") == null) {
            postgres.start();
        }
    }
    public static SessionFactory buildSessionFactory() {
        Configuration configuration = HibernateUtil.buildConfiguration();
        configuration.setProperty("hibernate.connection.url", postgres.getJdbcUrl());
        configuration.setProperty("hibernate.connection.username", postgres.getUsername());
        configuration.setProperty("hibernate.connection.password", postgres.getPassword());
        configuration.configure();

        return configuration.buildSessionFactory();
    }
}
