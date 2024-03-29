package com.fizzbuzz.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FizzBuzz {
	

    @JsonProperty("defaultList")
    private List<Integer> defaultList;
  


	public List<Integer> getDefaultList() {
		return defaultList;
	}

	public void setDefaultList(List<Integer> defaultList) {
		this.defaultList = defaultList;
	}

	@JsonProperty("fizz")
    private List<Integer> Fizz;

    @JsonProperty("buzz")
    private List<Integer> Buzz;

    @JsonProperty("fizzBuzz")
    private List<Integer> FizzBuzz;

    public List<Integer> getFizz() {
        return Fizz;
    }

    public void setFizz(List<Integer> fizz) {
        Fizz = fizz;
    }

    public List<Integer> getBuzz() {
        return Buzz;
    }

    public void setBuzz(List<Integer> buzz) {
        Buzz = buzz;
    }

    public List<Integer> getFizzBuzz() {
        return FizzBuzz;
    }

    public void setFizzBuzz(List<Integer> fizzBuzz) {
        FizzBuzz = fizzBuzz;
    }
}