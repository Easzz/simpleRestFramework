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
		RequestContextImpl requestContext = new RequestContextImpl(request, response);
		service(requestContext);
	}
	public abstract void service(IRequestContext iRequestContext);
}
