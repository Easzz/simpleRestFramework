package com.easzz.handler.action;

import com.easzz.handler.request.AbstractRequestContext;
import com.easzz.handler.request.IRequestContext;

import java.util.concurrent.Callable;

/**
 * Created by easzz on 2017/12/10 11:49
 */
public abstract class AsyncTask implements Callable<Object> {
	private IRequestContext iRequestContext;

	public AsyncTask() {
		iRequestContext = AbstractRequestContext.getContextHolder();
	}

	@Override
	public Object call() throws Exception {
		//设置当前线程request
		try {
			AbstractRequestContext.setCurrentRequestContext(iRequestContext);
			return doCall();
		} finally {
			AbstractRequestContext.cleanup();
		}
	}

	public abstract Object doCall();
}
