package com.example.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import me.paulschwarz.springdotenv.DotenvPropertySource;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
public class BookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingApplication.class, args);
    }

    // Optional: Load .env variables early into Spring Environment
    public ApplicationListener<ApplicationEnvironmentPreparedEvent> dotenvLoader() {
        return event -> {
            ConfigurableEnvironment env = event.getEnvironment();
            DotenvPropertySource.addToEnvironment(env);
        };
    }
}