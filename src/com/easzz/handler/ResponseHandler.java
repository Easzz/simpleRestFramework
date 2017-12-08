package com.easzz.handler;

import com.alibaba.fastjson.JSON;
import com.easzz.compoent.Action;
import com.easzz.compoent.ActionBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by easzz on 2017/11/19 12:21
 */
public class ResponseHandler {
	private HttpServletRequest request;
	private HttpServletResponse response;

	public ResponseHandler(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	public void service() {
		String requestURI = request.getRequestURI();
		ActionBean actionBeanMap = Action.getActionBeanMap(requestURI);
		try {
			Object o = actionBeanMap.getaClass().newInstance();
			String invoke = (String) actionBeanMap.getMethod().invoke(o);
			String s = JSON.toJSONString(invoke);
			try {
				response.getWriter().print(s);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("doPost return:" + invoke);

		} catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
			e.printStackTrace();
		}
	}

}

