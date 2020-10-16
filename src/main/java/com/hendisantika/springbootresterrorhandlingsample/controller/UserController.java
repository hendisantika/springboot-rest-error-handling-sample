package com.hendisantika.springbootresterrorhandlingsample.controller;

import com.hendisantika.springbootresterrorhandlingsample.exception.ResourceNotFoundException;
import com.hendisantika.springbootresterrorhandlingsample.model.User;
import com.hendisantika.springbootresterrorhandlingsample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.net.URI;
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

    @GetMapping(value = "/user")
    ResponseEntity<User> getByUsername(@RequestParam(required = true) String username) {

        User usr = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException(username + " NOT Found!"));

        return ResponseEntity.ok().body(usr);
    }

    @PostMapping(value = "/users")
    ResponseEntity<?> create(@Valid @RequestBody User user) {

        User addeduser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addeduser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/users/{id}")
    ResponseEntity<User> update(@PathVariable("id") @Min(1) int id, @Valid @RequestBody User user) {

        User puser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with ID :" + id + " Not Found!"));

        user.setId(puser.getId());
        userRepository.save(user);
        return ResponseEntity.ok().body(user);

    }
}
