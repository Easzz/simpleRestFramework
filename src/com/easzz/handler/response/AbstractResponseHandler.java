package com.easzz.handler.response;

import com.easzz.handler.request.IRequestContext;

import java.io.IOException;

/**
 * Created by easzz on 2017/12/10 11:36
 */
public abstract class AbstractResponseHandler implements IResponseHandler {
	private IRequestContext requestContext;

	public AbstractResponseHandler(IRequestContext requestContext) {
		this.requestContext = requestContext;
	}

	public void sendResponse(String text) throws IOException {
		requestContext.getResponse().getWriter().print(text);
	}
}
