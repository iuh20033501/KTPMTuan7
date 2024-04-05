package iuh.fit.edu.vn.registerservice;

import iuh.fit.edu.vn.registerservice.entity.User;
import iuh.fit.edu.vn.registerservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication

public class RegisterServiceApplication {
    @Autowired
    private UserRepository userRepository;
    public static void main(String[] args) {
        SpringApplication.run(RegisterServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner() {
return new CommandLineRunner() {
    @Override
        public void run(String... args) throws Exception {
//        User user = new User(1,"Hung","20033501","hungro8102@gmail.com");
//        User user2 = new User(2,"Oge","oge","oge@oge.com");
//        userRepository.save(user);
//        userRepository.save(user2);
        List<User> list = new ArrayList<>();
        list = userRepository.findAll();
        System.out.println(list);
        }
    };
    }
}
