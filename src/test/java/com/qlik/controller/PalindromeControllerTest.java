package com.qlik.controller;

import com.qlik.controller.PalindromeController;
import com.qlik.services.impl.PalindromeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PalindromeControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @InjectMocks
    public PalindromeController palindromeController;

    @Mock
    PalindromeServiceImpl palindromeService;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(palindromeController).build();
    }

    @Test
    public void test_IsPalindrome_true() throws Exception {
        when(palindromeService.isPalindrome("level")).thenReturn(true);

        mockMvc.perform(get("/is_palindrome/{str}", "level"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("palindrome", is(true)));
        verify(palindromeService, times(1)).isPalindrome("level");
    }

    @Test
    public void test_IsPalindrome_false() throws Exception {
        when(palindromeService.isPalindrome("noway")).thenReturn(false);

        mockMvc.perform(get("/is_palindrome/{str}", "noway"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("palindrome", is(false)));
        verify(palindromeService, times(1)).isPalindrome("noway");
    }
    @Test
    public void testPalindromeCounts() throws Exception {
        Map<String,Integer> mockRes = new HashMap<>();
        mockRes.put("level", 3);
        mockRes.put("kayak", 2);
        when(palindromeService.palindromeCount()).thenReturn(mockRes);

        mockMvc.perform(get("/palindrome_counts"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("level", is(3)))
                .andExpect(jsonPath("kayak", is(2)));

        verify(palindromeService, times(1)).palindromeCount();
    }
}