package com.cy.microservice.consumer.movie.controller;

import javax.servlet.http.HttpServletRequest;

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
public class MovieController01 {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired  
	HttpServletRequest request;

	/**
	 * THREAD/SEMAPHORE
	 * 
	 * @return
	 */
	@GetMapping("getUser")
	@HystrixCommand(fallbackMethod = "getUserFallback", commandProperties = {
		      @HystrixProperty(name="execution.isolation.strategy", value="THREAD")
		    })
	public User getUser(String name) {
		SecurityContext context = SecurityContextHolder.getContext();
		System.out.println("Authentication: " + context.getAuthentication());
		//HttpSession session = request.getSession();
		//System.out.println("session: " + session);
		return restTemplate.getForObject("http://MICROSERVICE-PROVIDER-USER/user/getUser", User.class);
	}

	public User getUserFallback(String name) {
		User user = new User();
		user.setName("getUserFallback");
		return user;
	}
	
	/**
	 * THREAD/SEMAPHORE
	 * 
	 * @return
	 */
	@GetMapping("user")
	@HystrixCommand(fallbackMethod = "getUserFallback", commandProperties = {
		      @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
		    })
	public User user(String name) {
		SecurityContext context = SecurityContextHolder.getContext();
		System.out.println("Authentication: " + context.getAuthentication());
		//HttpSession session = request.getSession();
		//System.out.println("session: " + session);
		return restTemplate.getForObject("http://MICROSERVICE-PROVIDER-USER/user/getUser", User.class);
	}

}
