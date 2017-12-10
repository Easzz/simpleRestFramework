package com.easzz.handler.request;

import com.easzz.utils.IOUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by easzz on 2017/12/10 10:36
 * 使用抽象类来实现请求上下文接口
 * 好处是，以及实现了部分接口，子类再继承此抽象类就不需要重复实现
 */
public abstract class AbstractRequestContext implements IRequestContext {

	@Override
	public String getPath() {
		return getRequest().getPathInfo();
	}

	@Override
	public byte[] getFormData() {
		try {
			return IOUtils.readByte(getRequest().getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
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
}
