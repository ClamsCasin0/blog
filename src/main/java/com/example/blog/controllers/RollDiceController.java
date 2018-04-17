package com.example.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RollDiceController {
    @GetMapping("/roll-dice")
    public String showGame() {
//        @PathVariable int guess, Model model
//        int rnd = (int)(Math.random() * 6 + 1);
//        model.addAttribute();
//        model.addAttribute();
        return "roll-dice";
    }

//    @GetMapping("/roll-dice/{n}")
//    public void rollDice(@PathVariable int n, Model model) {
//        model.addAttribute("n", n);
//
//    }

//    @GetMapping("/roll-dice/{random}")
//    public String rollRandom(@PathVariable String random, Model model) {
//        model.addAttribute("random", random);
//        return "random";
//    }

    @GetMapping("/roll-dice/{n}")
    public String play(@PathVariable int n, Model model) {
        int rnd = (int)(Math.random() * 6 + 1);
        model.addAttribute("result", (n == rnd));
        model.addAttribute("number", rnd);
//        model.addAttribute("n", n);
        return "roll-dice";
    }

}
