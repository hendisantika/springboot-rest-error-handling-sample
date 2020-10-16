package com.hendisantika.springbootresterrorhandlingsample.controller;

import com.hendisantika.springbootresterrorhandlingsample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
