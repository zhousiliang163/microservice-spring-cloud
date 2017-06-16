package com.cy.microservice.consumer.movie.controller;

import com.cy.microservice.consumer.movie.bean.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movie/")
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("getUser")
	@HystrixCommand(fallbackMethod = "getUserFallback", commandProperties = {
		      @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
		    })
	public User getUser() {
		SecurityContext context = SecurityContextHolder.getContext();
		return restTemplate.getForObject("http://MICROSERVICE-PROVIDER-USER/user/getUser", User.class);
	}

	public User getUserFallback() {
		User user = new User();
		user.setName("getUserFallback");
		return user;
	}
}
