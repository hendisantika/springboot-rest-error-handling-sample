package com.hendisantika.springbootresterrorhandlingsample.controller;

import com.hendisantika.springbootresterrorhandlingsample.exception.ResourceNotFoundException;
import com.hendisantika.springbootresterrorhandlingsample.model.User;
import com.hendisantika.springbootresterrorhandlingsample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rest-error-handling-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/10/20
 * Time: 06.38
 */
@RestController
@RequestMapping("/api")
@Validated
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/users")
    List<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/users/{id}")
    ResponseEntity<User> getById(@PathVariable("id") @Min(1) int id) {

        User usr = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with ID :" + id + " Not Found!"));

        return ResponseEntity.ok().body(usr);
    }
}
