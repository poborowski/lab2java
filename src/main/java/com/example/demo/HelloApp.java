package com.example.demo;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloApp {
    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "Hello World";
    }
}
