package com.apas;

import com.apas.storage.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 *
 * @author ekaranja
 */
@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties(StorageProperties.class)
public class App extends SpringBootServletInitializer {
    public static void main(String[] arg){
        SpringApplication.run(App.class, arg);
    
    }
    

    
}
