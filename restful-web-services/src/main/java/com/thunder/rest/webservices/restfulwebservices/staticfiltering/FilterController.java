package com.thunder.rest.webservices.restfulwebservices.staticfiltering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {
	
	@GetMapping("/filtering")
	public SomeBean retrieveSomeBean() {
		return new SomeBean("value1", "value2", "value3");
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> retrieveListOfSomeBean() {
		return Arrays.asList(
				new SomeBean("value1", "value2", "value3"),
				new SomeBean("value11", "value22", "value33"),
				new SomeBean("value11", "value22", "value33"));
	}

}
