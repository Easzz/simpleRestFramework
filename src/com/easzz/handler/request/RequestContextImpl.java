package com.easzz.handler.request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by easzz on 2017/12/10 10:46
 * 请求上下文的实现类，传入request和response
 */
public class RequestContextImpl extends AbstractRequestContext {
	private HttpServletRequest request;
	private HttpServletResponse response;

	public RequestContextImpl(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	@Override
	public HttpServletRequest getRequest() {
		return null;
	}

	@Override
	public HttpServletResponse getResponse() {
		return null;
	}
}
