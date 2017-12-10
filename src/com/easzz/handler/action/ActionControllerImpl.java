package com.easzz.handler.action;

import com.easzz.compoent.Action;
import com.easzz.compoent.ActionBean;
import com.easzz.handler.request.IRequestContext;
import com.easzz.handler.response.AbstractResponseFactory;
import com.easzz.handler.response.IResponseHandler;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by easzz on 2017/12/10 11:28
 * 请求处理的实现类
 */
public class ActionControllerImpl extends AbstractActionController {
	@Override
	public void service(IRequestContext iRequestContext) {
		ActionBean action = Action.getActionBeanMap(iRequestContext.getPath());

		IResponseHandler iResponseHandler = AbstractResponseFactory.buildResponse(iRequestContext);
		ExecutorService executorService= Executors.newFixedThreadPool(10);
		Future<Object> result = executorService.submit(new Callable<Object>() {
			@Override
			public Object call() throws Exception {
				return null;
			}
		});
	}
}
