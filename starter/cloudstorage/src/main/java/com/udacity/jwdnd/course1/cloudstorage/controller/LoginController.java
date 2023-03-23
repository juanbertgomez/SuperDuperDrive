package com.udacity.jwdnd.course1.cloudstorage.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class LoginController {

    @GetMapping()
    public String login() {return "login"; }

}
