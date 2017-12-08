package com.easzz.servlet;

import com.easzz.handler.ResponseHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by easzz on 2017/12/8 9:12
 */
public class DispatcherServlet extends AbstractBasicServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) {
		ResponseHandler responseHandler = new ResponseHandler(req, resp);
		responseHandler.service();
	}
}
