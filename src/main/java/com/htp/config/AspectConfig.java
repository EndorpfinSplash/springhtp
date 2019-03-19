package com.htp.config;

import com.htp.aspect.LoggingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AspectConfig {

    @Bean("logAspect")
    public LoggingAspect getLoggingAspect() {
        return new LoggingAspect();
    }
}
