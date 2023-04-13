package ru.ithub.fitness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.ithub.fitness.service.UserService;

@SpringBootApplication
public class FitnessApplication {
    public static void main(String[] args) {

        SpringApplication.run(FitnessApplication.class, args);
    }
}
