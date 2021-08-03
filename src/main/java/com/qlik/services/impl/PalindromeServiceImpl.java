package com.qlik.services.impl;

import com.qlik.exceptions.InvalidStringInputException;
import com.qlik.services.PalindromeService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PalindromeServiceImpl implements PalindromeService {

    public static Map<String, Integer> palindromeFreq = new HashMap<String,Integer>();

    /** This method is called by controller to */
    @Override
    public boolean isPalindrome(String str) throws Exception, InvalidStringInputException {
        validStringCheck(str);
        if(!checkPalindrome(str)) {
            return false;
        }
        // Save the string
        if(palindromeFreq.containsKey(str)){
            palindromeFreq.put(str, palindromeFreq.get(str)+1);
        } else {
            palindromeFreq.put(str, 1);
        }
        // Given string is a palindrome
        return true;
    }

    @Override
    public Map<String, Integer> palindromeCount() {
        return palindromeFreq;
    }

    private void validStringCheck(String str) throws InvalidStringInputException {
        // Allow only alphanumeric
        String pattern= "^[a-zA-Z0-9]*$";
        if(!str.matches(pattern)) {
            throw new InvalidStringInputException(str);
        }
    }

    private boolean checkPalindrome(String str) throws Exception {
        boolean res = true;
        try {
            // Pointers at beginning and end of string
            int i = 0, j = str.length() - 1;

            // While there are characters to compare
            while (i < j) {
                // If there is a mismatch
                if (str.charAt(i) != str.charAt(j)) {
                    res = false;
                    break;
                }
                i++;
                j--;
            }
        } catch(Exception e) {
            throw new Exception("Exception during string traversing");
        }
        return res;
    }
}
