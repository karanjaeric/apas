package com.apas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 *
 * @author ekaranja
 */
@SpringBootApplication
@EnableJpaAuditing

public class App extends SpringBootServletInitializer {
    public static void main(String[] arg){
        SpringApplication.run(App.class, arg);
    
    }
    

    
}
