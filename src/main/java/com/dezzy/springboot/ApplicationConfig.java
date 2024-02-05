package com.dezzy.springboot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ApplicationConfig {

    @Bean
    @Qualifier("bean1")
    public MyFirstComponent firstComponent(){
        return new MyFirstComponent("First Bean");
    }

    @Bean
    @Primary
    public MyFirstComponent secondComponent(){
        return new MyFirstComponent("Second Bean");
    }
}
