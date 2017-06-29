package com.cy.microservice.consumer.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {

	@Autowired
	private Environment env;
	
	@GetMapping("getValue")
	public String getValue(String key){ 
		return env.getProperty(key);
	}
}
