package com.easzz.handler.response;

import com.easzz.handler.request.IRequestContext;

/**
 * Created by easzz on 2017/12/10 11:17
 * 创建返回类型工厂
 */

public abstract class AbstractResponseFactory {
	public static IResponseHandler buildResponse(IRequestContext context) {
		if (IRequestContext.Format.JSON == context.getFormat()) {
			return new JsonResponseHandler(context);
		}
		return null;
	}
}
