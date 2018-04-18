package com.example.blog.services;

import org.springframework.stereotype.Service;

@Service
public class StringTransformSvc {

    public String getFirstLetter(String word) {
        return word.substring(0,1);
    }

    public String getLastLetter(String word) {
        return word.substring(word.length() - 2, word.length() - 1);
    }

    public String getWordInCaps(String word) {
        return word.toUpperCase();
    }
}
