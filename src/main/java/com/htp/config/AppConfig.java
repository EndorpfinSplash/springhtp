package com.htp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.htp")
@Import(DatabaseConfig.class)
public class AppConfig {

}
