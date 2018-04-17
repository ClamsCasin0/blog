package com.example.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{numberA}/and/{numberB}")
    @ResponseBody
    public String add(@PathVariable int numberA, @PathVariable int numberB) {
        return String.valueOf(numberA + numberB);
    }

    @GetMapping("/subtract/{numberA}/from/{numberB}")
    @ResponseBody
    public String subtract(@PathVariable int numberA, @PathVariable int numberB) {
        return String.valueOf(numberB - numberA);
    }

    @GetMapping("/divide/{numberA}/by/{numberB}")
    @ResponseBody
    public String divide(@PathVariable int numberA, @PathVariable int numberB) {
        if(numberB == 0) {
            return "You cannot divide by 0!!!";
        }else {
            return String.valueOf(numberA / numberB);
        }
    }

    @GetMapping("/multiply/{numberA}/and/{numberB}")
    @ResponseBody
    public String multiply(@PathVariable int numberA, @PathVariable int numberB) {
        return String.valueOf(numberA * numberB);
    }

}
