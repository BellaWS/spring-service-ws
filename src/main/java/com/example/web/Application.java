package com.example.web;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    @Bean
    MeterRegistryCustomizer<MeterRegistry> configurer(@Value("${spring.application.name}") String applicationName, @Value("${spring.project.name}") String projectName) {
        return (registry) -> registry.config().commonTags("application",applicationName,"app", applicationName,"project",projectName);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}