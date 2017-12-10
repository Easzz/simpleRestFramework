package com.easzz.handler.action;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by easzz on 2017/12/10 11:49
 */
public class AsyncTask implements Callable<Object> {
	private int taskCount;
	private ExecutorService executorService;

	public AsyncTask() {
		executorService = Executors.newFixedThreadPool(taskCount);
	}

	@Override
	public Object call() throws Exception {
		return executorService.submit(new AsyncTask());
	}
}
