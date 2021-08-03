package com.qlik.services.impl;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class PalindromeServiceImplTest {

    public PalindromeServiceImpl palindromeServiceImpl;

    @Before
    public void init() {
        palindromeServiceImpl = new PalindromeServiceImpl();
    }
    @Test
    public void testPalindromeForNullValue(){
        assertEquals(palindromeServiceImpl.isPalindrome(null), false);
    }

    @Test
    public void testPalindromeForSpecialCharacter(){
        assertEquals(palindromeServiceImpl.isPalindrome("&abhba&"), true);
    }

}
