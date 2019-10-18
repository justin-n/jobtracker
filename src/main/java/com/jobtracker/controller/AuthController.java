package com.jobtracker.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AuthController {

    @PostMapping("/rest/principal")
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping(value = "/rest/authenticationinfo", produces="text/html")
    public String currentUserAuth(Authentication authentication) {

        return
            ("Name:<br />" +
                authentication.getName() + "<br />" +
                "Authorities:<br />" +
                authentication.getAuthorities() + "<br />" +
                "Credentials:<br />" +
                authentication.getCredentials() + "<br />" +
                "Details:<br />" +
                authentication.getDetails() + "<br />" +
                "Is authenticated:<br />" +
                authentication.isAuthenticated() + "<br />" +
                "Class:<br />" +
                authentication.getClass() + "<br />" +
                "Principal:<br />" +
                authentication.getPrincipal());
    }
}
