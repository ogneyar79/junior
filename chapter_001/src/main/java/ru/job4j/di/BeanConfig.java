package ru.job4j.di;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {


    @Bean
    public ConsoleInput consoleInput () {
        return new ConsoleInput();
    }
    @Bean
    public Store store(){
        return new Store();
    }

    @Bean
    public StartUI startUI() {
        return new StartUI();
    }

}
