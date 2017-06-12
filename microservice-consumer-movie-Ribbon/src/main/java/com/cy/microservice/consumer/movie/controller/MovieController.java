package com.cy.microservice.consumer.movie.controller;

import com.cy.microservice.consumer.movie.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movie/")
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@GetMapping("getUser")
	public User getUser() {
		ServiceInstance serviceInstance = this.loadBalancerClient.choose("MICROSERVICE-PROVIDER-USER");
		System.out.println("111" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":"
				+ serviceInstance.getPort());
		return restTemplate.getForObject("http://MICROSERVICE-PROVIDER-USER/user/getUser", User.class);
	}

	@GetMapping("test")
	public String test() {
		ServiceInstance serviceInstance = this.loadBalancerClient.choose("MICROSERVICE-PROVIDER-USER");
		System.out.println("111" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":"
				+ serviceInstance.getPort());

		// ServiceInstance serviceInstance2 =
		// this.loadBalancerClient.choose("microservice-provider-user2");
		// System.out.println("222" + ":" + serviceInstance2.getServiceId() +
		// ":" + serviceInstance2.getHost() + ":" + serviceInstance2.getPort());

		return "1";
	}
}
