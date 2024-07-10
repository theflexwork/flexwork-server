package io.flexwork.web.rest;

import io.flexwork.domain.User;
import io.flexwork.service.SignupService;
import io.flexwork.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SignupWorkflowController {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private SignupService signupService;

    public SignupWorkflowController(SignupService signupService) {
        this.signupService = signupService;
    }

    @PostMapping("/signup")
    public void signup(@RequestBody User user) {
        signupService.signup(user);
    }

    @GetMapping("/signup")
    public String hello() {
        return "Hello";
    }
}
