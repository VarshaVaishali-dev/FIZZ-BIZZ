package com.fizzbuzz.restfizzbuzzsample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.fizzbuzz.controller.FizzBuzzController;
import com.fizzbuzz.model.FizzBuzz;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebMvcTest(FizzBuzzController.class)

public class RestFizzbuzzSampleApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private FizzBuzz fizzBuzzinstance;
	@Test
	
		    public void greetingShouldReturnDefaultMessage() throws Exception {

	        //Create a post request with an accept header for application\json
	        RequestBuilder requestBuilder = MockMvcRequestBuilders
	                .get("/fizzbuzz/1")
	                .contentType(MediaType.APPLICATION_JSON);

	        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	        MockHttpServletResponse response = result.getResponse();

	        //Assert that the return status is OK
	        assertEquals(HttpStatus.OK.value(), response.getStatus());
	    }
	
}
