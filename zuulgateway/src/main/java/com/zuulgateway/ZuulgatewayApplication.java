package com.zuulgateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulgatewayApplication.class, args);
	}

	@Bean
	public ZuulFilter postFilter(){
		return new ZuulFilter() {
			@Override
			public String filterType() {
				return "pre";
			}

			@Override
			public int filterOrder() {
				return 1;
			}

			@Override
			public boolean shouldFilter() {
				return true;
			}

			@Override
			public Object run() throws ZuulException {
				System.out.println("Pre Filter - run");
				HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
				System.out.println("Request Method : "+request.getMethod());
				System.out.println("Request URL : "+request.getRequestURL().toString());
				return null;
			}
		};
	}

}
