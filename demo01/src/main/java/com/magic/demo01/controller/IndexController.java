package com.magic.demo01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        String name = "sfsaf";
        System.out.println(name);
        return "Hello World!";
    }

}
