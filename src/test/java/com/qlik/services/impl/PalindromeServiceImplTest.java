package com.qlik.services.impl;

import com.qlik.exceptions.InvalidStringInputException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class PalindromeServiceImplTest {

    public PalindromeServiceImpl palindromeServiceImpl;

    @Before
    public void init() {
        palindromeServiceImpl = new PalindromeServiceImpl();
    }

    @Test(expected = InvalidStringInputException.class)
    public void testPalindromeForNullValue() throws Exception {
        assertEquals(palindromeServiceImpl.isPalindrome(null), false);
    }

    @Test(expected = InvalidStringInputException.class)
    public void testPalindromeForSpecialCharacter() throws Exception {
        palindromeServiceImpl.isPalindrome("&abhba&");
    }

    @Test
    public void testPalindromeTrue() throws Exception {
        assertTrue(palindromeServiceImpl.isPalindrome("level"));
    }

    @Test
    public void testPalindromeFalseWithCapitalCharacters() throws Exception {
        assertFalse(palindromeServiceImpl.isPalindrome("Level"));
    }

    @Test
    public void testPalindromeFalseSimple() throws Exception {
        assertFalse(palindromeServiceImpl.isPalindrome("notapalindrome"));
    }

}
