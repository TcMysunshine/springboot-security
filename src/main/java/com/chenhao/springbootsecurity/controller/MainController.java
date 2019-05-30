package com.chenhao.springbootsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping(value="loginPage")
    public String loginPage(){
        return "loginPage.html";
    }
    @GetMapping(value="loginError")
    public String loginError(){
        return "loginError.html";
    }
    @RequestMapping(value = "hello")
    @ResponseBody
    public String hello(){
        return "Hello world";
    }
    @GetMapping(value = "loginSuccess")
    public String loginSuccess(){
        return "loginSuccess";
    }
    @PreAuthorize("hasAuthority('viewBook')")
    @GetMapping(value = "viewBook")
    @ResponseBody
    public String viewBook(){
        return "viewBook";
    }
    @PreAuthorize("hasAuthority('addBook')")
    @GetMapping(value = "addBook")
    @ResponseBody
    public String addBook(){
        return "addBook";
    }
}
