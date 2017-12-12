package com.easzz.handler.action;

import com.easzz.compoent.Action;
import com.easzz.compoent.ActionBean;
import com.easzz.handler.request.AbstractRequestContext;
import com.easzz.handler.request.IRequestContext;
import com.easzz.handler.response.AbstractResponseFactory;
import com.easzz.handler.response.IResponseHandler;

import java.lang.reflect.InvocationTargetException;
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

		final ActionBean action = Action.getActionBeanMap(iRequestContext.getPath());

		IResponseHandler iResponseHandler = AbstractResponseFactory.buildResponse(iRequestContext);
		//设置request 线程
		AbstractRequestContext.setCurrentRequestContext(iRequestContext);

		ExecutorService executorService = Executors.newFixedThreadPool(10);
		//执行方法，得到返回值
		//处理返回的数据
		try {
			Future<Object> f = executorService.submit(new AsyncTask() {
				public Object doCall() {
					try {
						return action.getMethod().invoke(action.getO());
					} catch (IllegalAccessException | InvocationTargetException e) {
						e.printStackTrace();
					}
					return null;
				}
			});
			Object v = f.get();
			iResponseHandler.handler(v);
		} catch (Throwable t) {

		} finally {
			AbstractRequestContext.cleanup();
		}
	}
}
