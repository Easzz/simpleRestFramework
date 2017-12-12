package com.easzz.handler.action;

import com.easzz.handler.request.IRequestContext;
import com.easzz.handler.request.RequestContextImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by easzz on 2017/12/10 11:20
 */
public abstract class AbstractActionController {


	public void handlerService(HttpServletRequest request, HttpServletResponse response) {
		IRequestContext requestContext = new RequestContextImpl(request, response);
		/*String a=new String(requestContext.getFormData());
		System.out.println("aaa:"+a);*/

		service(requestContext);
	}

	public abstract void service(IRequestContext iRequestContext);
}
