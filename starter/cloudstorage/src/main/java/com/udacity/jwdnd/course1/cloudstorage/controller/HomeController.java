package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.models.File;
import com.udacity.jwdnd.course1.cloudstorage.models.User;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    private final FileService fileService;
    private UserMapper userMapper;

    public HomeController(
            FileService fileService,
            UserMapper userMapper
    ){
        this.fileService = fileService;
        this.userMapper = userMapper;
    }

    @RequestMapping("/home")
    public String getHomePage (Authentication authentication, Model model) {
        String loggedInUserName = (String) authentication.getPrincipal();
        User user = userMapper.getUser(loggedInUserName);

        model.addAttribute("files", fileService.getUploadedFiles(user.getUserId()));
        return "home";
    }
}
