package com.example.exercicio_modulo_44.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class ConfigPostgres {
    @Bean
    public DataSource dataSourcePostgres(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/usuarios");
        dataSource.setUsername("postgres");
        dataSource.setPassword("digao555%");

        return dataSource;
    }
}
