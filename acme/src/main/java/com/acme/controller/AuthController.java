package com.acme.controller;

import com.acme.request.model.LoginInput;
import com.acme.request.model.LoginOutput;
import com.acme.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/auth/", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthController {

    @Autowired
    private UserService userService;
    /** The logger. */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping(value = "/login")
    @Operation(summary = "Return a JWT for a username", description = "Returns a JWT with a 15 minute timeout for a user API auth. Valid Demo usernames: 'userEhr', 'userEhrAlaska', 'userGovt', 'userFsa'")
    public LoginOutput login(@RequestBody LoginInput loginInput) {
        return userService.login(loginInput);
    }

}
