package com.fizzbuzz.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fizzbuzz.model.FizzBuzz;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@RestController
public class FizzBuzzController {
    @RequestMapping(value = "/fizzbuzz/{number}", method = RequestMethod.GET, produces = "application/json")
    public String fizzBuzz(@PathVariable("number") int upperLimit, HttpServletResponse response) {
      
        FizzBuzz fizzBuzzObj = new FizzBuzz();
        List<Integer> fizzList = new ArrayList<>(),
                      buzzList = new ArrayList<>(), 
                      defaultList=new ArrayList<>(),
                      fizzBuzzList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
          if (upperLimit<=100) {
            IntStream.range(1, upperLimit)
            .forEach(i -> {
            	
                    if (((i % 5) == 0) && ((i % 3) == 0)) {
                    	fizzBuzzList.add(i);
                    	  fizzBuzzObj.setFizzBuzz(fizzBuzzList);
                    }
                    else if ((i % 3) == 0) {
                    	fizzList.add(i);
                    	 fizzBuzzObj.setFizz(fizzList);
                    }
                    else if ((i % 5) == 0) {
                    	buzzList.add(i);
                    	fizzBuzzObj.setBuzz(buzzList);
                    }
                    else {
                    	defaultList.add(i);
                    	fizzBuzzObj.setDefaultList(defaultList); 
                    }
                
            });  
           return objectMapper.writeValueAsString(fizzBuzzObj);
          }
          else {

        	  return "out of range, please give input within 100";
        			  
          }
        } catch (JsonProcessingException e) {
            e.getMessage();
        }

        return null;
    }

  
}