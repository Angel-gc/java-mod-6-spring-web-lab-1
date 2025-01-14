package com.example.demo.configuration;

//import org.springframework.context.annotation.Conditional''
import com.example.demo.service.ApiError;
import com.example.demo.service.CustomRestExceptionHandler;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    public ModelMapper getMapper(){
        return new ModelMapper();
    }
    @Bean
    public ApiError getApiError() {
        return new ApiError();
    }
    @Bean
    public CustomRestExceptionHandler customRestExceptionHandler(){
        return new CustomRestExceptionHandler();
    }
}
