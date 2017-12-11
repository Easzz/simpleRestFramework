package com.easzz.servlet;

import com.easzz.handler.action.AbstractActionController;
import com.easzz.handler.action.ActionControllerImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by easzz on 2017/12/8 9:12
 * 入口servlet，用于转发请求
 */
public class DispatcherServlet extends AbstractBasicServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) {
		AbstractActionController actionController = new ActionControllerImpl();
		actionController.handlerService(req, resp);
	}
}
