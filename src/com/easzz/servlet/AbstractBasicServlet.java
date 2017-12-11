package com.easzz.servlet;

import com.easzz.compoent.ComponentsLoader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by easzz on 2017/11/18 19:35
 */
public abstract class AbstractBasicServlet extends HttpServlet {
	private ComponentsLoader componentsLoader;

	@Override
	public void init() throws ServletException {
		//初始化装在bean
		componentsLoader = new ComponentsLoader();
		componentsLoader.init();
	}

	public abstract void service(HttpServletRequest req, HttpServletResponse resp);

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		service(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		service(req, resp);
	}

}
