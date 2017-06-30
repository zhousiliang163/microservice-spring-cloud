package com.cy.microservice.consumer.movie.feign;

import com.cy.microservice.consumer.movie.bean.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("MICROSERVICE-PROVIDER-USER")
public interface UserFeignClient {

   @RequestMapping(value = "/user/postUser", method = RequestMethod.POST)
	public User postUser(@RequestBody User user);
   
   @RequestMapping(value = "/user/getUser", method = RequestMethod.GET)
	public User getUser();
   
   @RequestMapping(value = "/user/test", method = RequestMethod.GET)
   public String test(@RequestParam("name") String name);
}
