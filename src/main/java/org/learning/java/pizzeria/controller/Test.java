package org.learning.java.pizzeria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Test {
    public  String test(){
        return "pizza-list";
    }
}
