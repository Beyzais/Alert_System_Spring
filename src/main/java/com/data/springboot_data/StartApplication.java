package com.data.springboot_data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class StartApplication{

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);

    }

    @Bean
    CommandLineRunner initDatabase(AlertRepository repository){
        return args ->{repository.save(new Alert("Google", "https://www.google.com.tr/", "GET", new Integer("5"), 1));
                       repository.save(new Alert("Instagram", "https://www.instagram.com/?hl=tr", "GET", new Integer("7"), 0));

        };
    }

}

