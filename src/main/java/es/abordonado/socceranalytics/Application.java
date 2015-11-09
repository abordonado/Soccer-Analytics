package es.abordonado.socceranalytics;

import es.abordonado.socceranalytics.domain.User;
import es.abordonado.socceranalytics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application implements CommandLineRunner {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("/")
    String hello() {
        return "Hello Spring Boot";
    }
    
    public static void main(String args[]) throws Exception {
        SpringApplication.run(Application.class, args);
    }
    
    @Override
    public void run(String... args) {
        System.out.println("Adding User");
        int userId = userService.addUser(new User("dude@dude.com", "thedude"));
        System.out.println("Getting User");
        User user = userService.getUser(userId);
        System.out.println("Got User: " + user.getUserName());
    }
    
}
