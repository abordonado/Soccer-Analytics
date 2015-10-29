package es.abordonado.socceranalytics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
public class Application {
    
    @RequestMapping("/")
    String hello() {
        return "Hello Spring Boot";
    }
    
    public static void main(String args[]){
        SpringApplication.run(Application.class, args);
    }
    
}
