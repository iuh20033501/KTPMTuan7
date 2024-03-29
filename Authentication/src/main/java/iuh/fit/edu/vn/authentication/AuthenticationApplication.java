package iuh.fit.edu.vn.authentication;

import iuh.fit.edu.vn.authentication.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AuthenticationApplication {
@Autowired
private AuthenticationRepository authenticationRepository;
    public static void main(String[] args) {
        SpringApplication.run(AuthenticationApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

            }
        };
    }
}
