package org.javaacademy.car_ru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CarRuApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CarRuApplication.class, args);
    }
}