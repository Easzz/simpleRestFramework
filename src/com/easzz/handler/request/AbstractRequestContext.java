package com.easzz.handler.request;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by easzz on 2017/12/10 10:36
 * 使用抽象类来实现请求上下文接口
 * 好处是，以及实现了部分接口，子类再继承此抽象类就不需要重复实现
 */
public abstract class AbstractRequestContext implements IRequestContext {
	//使用ThreadLocal将context保存起来
	public static ThreadLocal<IRequestContext> contextHolder = new ThreadLocal<>();
	private byte[] data = null;

	public static void setCurrentRequestContext(IRequestContext context) {
		if (context == null) {
			System.out.println("request context is null");
			return;
		}
		contextHolder.set(context);
	}

	public static IRequestContext getContextHolder() {
		return contextHolder.get();
	}


	@Override
	public String getPath() {
		return getRequest().getPathInfo();
	}

	@Override
	public byte[] getFormData() {
		readFormData();

		return data;
	}

	private void readFormData() {

		BufferedReader reader = null; // 实例化输入流，并获取网页代码
		try {
			reader = new BufferedReader(new InputStreamReader(getRequest().getInputStream(), "UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String s; // 依次循环，至到读的值为空
		StringBuilder sb = new StringBuilder();
		try {
			while ((s = reader.readLine()) != null) {
				sb.append(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String str = sb.toString();
		data = str.getBytes();
		/*if (data == null) {
			try {
				data = IOUtils.readByte(getRequest().getInputStream());
			} catch (Exception e) {
				throw new RuntimeException("I/O error", e);
			}
		}*/
	}

	public abstract HttpServletRequest getRequest();

	public abstract HttpServletResponse getResponse();

	@Override
	public Format getFormat() {
		String format = getRequest().getParameter("format");
		if (!StringUtils.hasLength(format)) {
			return Format.XML;
		}
		return Format.JSON;

	}

	static public void cleanup() {
		setCurrentRequestContext(null);
	}

}
