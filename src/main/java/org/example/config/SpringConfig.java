package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Scanner;

@Configuration
@ComponentScan("org.example")
@PropertySource("application.properties")
public class SpringConfig {

    @Bean
    public Scanner scanner(){
        return new Scanner(System.in);
    }


}
