package com.easzz.web;

import org.springframework.stereotype.Component;

import javax.ws.rs.Path;

/**
 * Created by easzz on 2017/11/19 10:08
 */
@Component
@Path("/gateway/index")
public class IndexController {

	@Path("/say")
	public String say() {
		System.out.println("say...");
		return "abc";
	}

}
