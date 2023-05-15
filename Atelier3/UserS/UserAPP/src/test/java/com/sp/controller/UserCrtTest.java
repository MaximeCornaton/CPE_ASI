/**
 * 
 */
package com.sp.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sp.model.User;
import com.sp.service.UserService;

/**
 * @author paulaubry
 *
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = UserCrt.class)
class UserCrtTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService uService;
	
	private User mockUser;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		mockUser = new User(1,"Paul","Aubry","password",2000);
	}


	/**
	 * Test method for {@link com.sp.controller.UserCrt#getUser(int)}.
	 * @throws Exception 
	 */
	@Test
	final void testGetUser() throws Exception {
        Mockito.when(uService.getUser(50)).thenReturn(mockUser);
        
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/50").accept(MediaType.APPLICATION_JSON);
        
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        
        String expectedJsonResponse = new ObjectMapper().writeValueAsString(mockUser);
        String actualJsonResponse = result.getResponse().getContentAsString();

        assertEquals(expectedJsonResponse, actualJsonResponse);

        verify(uService, times(1)).getUser(50);
	}

}
