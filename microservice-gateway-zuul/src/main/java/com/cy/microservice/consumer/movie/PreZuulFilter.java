package com.cy.microservice.consumer.movie;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PreZuulFilter extends ZuulFilter {
	private final static Logger LOGGER = LoggerFactory.getLogger(PreZuulFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		HttpServletRequest servletRequest = RequestContext.getCurrentContext().getRequest();
        String host = servletRequest.getRemoteHost();
        PreZuulFilter.LOGGER.info("request host : " + host);
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
