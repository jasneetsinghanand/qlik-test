package com.qlik.controller;

import com.qlik.dto.BooleanDTO;
import com.qlik.services.PalindromeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/")
public class PalindromeController {
    public PalindromeService palindromeService;

    @Autowired
    public PalindromeController(PalindromeService palindromeService) {
        this.palindromeService = palindromeService;
    }

    @RequestMapping(value = "is_palindrome/{str}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public BooleanDTO isPalindrome(@PathVariable("str") String str) throws Exception {
        BooleanDTO response = new BooleanDTO();
        response.setPalindrome(palindromeService.isPalindrome(str));
        return response;
    }

    @RequestMapping(value = "palindrome_counts", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Map<String, Integer> palindromeCounts() {
        return palindromeService.palindromeCount();
    }
}
