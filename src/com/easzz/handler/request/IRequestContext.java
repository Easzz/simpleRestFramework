package com.easzz.handler.request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by easzz on 2017/12/10 10:24
 */

public interface IRequestContext {
	/**
	 * 返回出去的数据类，json或者xml
	 */
	enum Format {
		JSON, XML
	}

	/**
	 * 获取请求的路径，servlet映射之后的路径
	 *
	 * @return
	 */
	String getPath();

	/**
	 * 获取提交过来的表单数据
	 *
	 * @return
	 */
	byte[] getFormData();

	/**
	 * 获取request对象
	 *
	 * @return
	 */
	HttpServletRequest getRequest();

	/**
	 * 获取response对象
	 *
	 * @return
	 */
	HttpServletResponse getResponse();

	/**
	 * 获取返回的数据类型，xml，json
	 * @return
	 */
	Format getFormat();


}
