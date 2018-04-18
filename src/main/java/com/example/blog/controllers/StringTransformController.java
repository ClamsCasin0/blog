package com.example.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class StringTransformController {
    @GetMapping("/string/reverse/{string}")
    @ResponseBody
    public String reverseString(@PathVariable String string) {
        return reversesString(string);

    }

    @GetMapping("/string/caps/{string}")
    @ResponseBody
    public String capitalizeString(@PathVariable String string) {
        return string.toUpperCase();

    }

    @GetMapping("/string/both/{string}")
    @ResponseBody
    public String capAndRevString(@PathVariable String string) {
        return reversesString(string.toUpperCase());

    }

    //reverses string
    public static String reversesString(final String input)
    {
        final StringBuilder builder = new StringBuilder(input);
        int length = builder.length();
        for (int i = 0; i < length / 2; i++)
        {
            final char current = builder.charAt(i);
            final int otherEnd = length - i - 1;
            builder.setCharAt(i, builder.charAt(otherEnd)); // swap
            builder.setCharAt(otherEnd, current);
        }
        return builder.toString();
    }


}



