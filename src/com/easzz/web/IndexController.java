package com.easzz.web;

import com.easzz.handler.request.AbstractRequestContext;
import org.springframework.stereotype.Component;

import javax.ws.rs.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by easzz on 2017/11/19 10:08
 */
@Component
@Path("/gateway/index")
public class IndexController {

	@Path("/say")
	public Map say() {
		String a=new String(AbstractRequestContext.getContextHolder().getFormData());
		System.out.println(a);
		Map<String, String> m = new HashMap<>();
		m.put("name", "123");
		return m;
	}
}
