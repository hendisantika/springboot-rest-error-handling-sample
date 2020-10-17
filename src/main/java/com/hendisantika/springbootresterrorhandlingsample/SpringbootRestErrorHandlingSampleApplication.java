package com.hendisantika.springbootresterrorhandlingsample;

import com.hendisantika.springbootresterrorhandlingsample.model.User;
import com.hendisantika.springbootresterrorhandlingsample.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootRestErrorHandlingSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRestErrorHandlingSampleApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {
        return args -> {
            userRepository.save(new User("naruto", "12345"));
            userRepository.save(new User("sasuke", "12345"));
            userRepository.save(new User("sakura", "12345"));
            userRepository.save(new User("kakashi", "12345"));
            userRepository.save(new User("minato", "12345"));
            userRepository.save(new User("kushina", "12345"));
        };
    }


}
