package com.thunder.rest.webservices.restfulwebservices.dynamicfiltering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class DynamicFilterController {
	
	// field1, field2
	@GetMapping("/filtering-dynamic")
	public MappingJacksonValue retrieveDynamicSomeBean() {
		DynamicSomeBean someBean = 
				new DynamicSomeBean("value1", "value2", "value3");
		
		SimpleBeanPropertyFilter filter = 
				SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	// field2, field3
			@GetMapping("/filter-listdynamic")
			public MappingJacksonValue retrieveListOfSomeBeans() {
				List<DynamicSomeBean> list = Arrays.asList(new DynamicSomeBean("value1", "value2", "value3"),
						new DynamicSomeBean("value11", "value22", "value33"),
						new DynamicSomeBean("value111", "value222", "value333"));

				SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");

				FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

				MappingJacksonValue mapping = new MappingJacksonValue(list);

				mapping.setFilters(filters);

				return mapping;
			}
		
	
////	// field1, field2
//	@GetMapping("/filtering-listdynamicone")
//	public List<DynamicSomeBean> retrieveListOfSomeBeanOne() {
//		
//		return Arrays.asList(new DynamicSomeBean("value1", "value2", "value3"), 
//				new DynamicSomeBean("value11", "value22", "value33"),
//				new DynamicSomeBean("value111", "value222", "value333"));
//	}
	
	
	

}
