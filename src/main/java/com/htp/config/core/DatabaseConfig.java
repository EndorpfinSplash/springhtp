package com.htp.config.core;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import java.util.Objects;

@Configuration
@PropertySource("classpath:database.properties")
public class DatabaseConfig {

    @Autowired
    private Environment properties;

    @Bean(value = "dataSource", destroyMethod = "close")
    @Scope("singleton")
    public BasicDataSource getDatasource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(properties.getProperty("driverName"));
        dataSource.setPassword(properties.getProperty("password"));
        dataSource.setUrl(properties.getProperty("url"));
        dataSource.setInitialSize(Integer.valueOf(Objects.requireNonNull(properties.getProperty("initialSize"))));
        dataSource.setUsername(properties.getProperty("login"));
        dataSource.setMaxActive(Integer.valueOf(Objects.requireNonNull(properties.getProperty("maxActive"))));
        return dataSource;
    }
}
