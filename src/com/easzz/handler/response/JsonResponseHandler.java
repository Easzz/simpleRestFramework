package com.easzz.handler.response;

import com.alibaba.fastjson.JSON;
import com.easzz.handler.request.IRequestContext;

import java.io.IOException;

/**
 * Created by easzz on 2017/12/10 11:40
 */
public class JsonResponseHandler extends AbstractResponseHandler {
	public JsonResponseHandler(IRequestContext requestContext) {
		super(requestContext);
	}

	@Override
	public void handler(Object o) {
		String s = JSON.toJSONString(o);
		try {
			this.sendResponse(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
