package com.example.demo.configuration;

//import org.springframework.context.annotation.Conditional''
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    public ModelMapper getMapper(){
        return new ModelMapper();
    }
}
