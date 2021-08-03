package com.qlik.services;


import java.util.Map;

public interface PalindromeService {

    public boolean isPalindrome(String str) throws Exception;

    public Map<String, Integer> palindromeCount();
}
