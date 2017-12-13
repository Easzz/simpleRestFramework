package com.easzz.compoent;

import java.lang.reflect.Method;

/**
 * Created by easzz on 2017/11/19 10:42
 */
public class ActionBean {
	private Object o;
	private Method method;

	public ActionBean(Object o, Method method) {
		this.o = o;
		this.method = method;
	}

	public ActionBean() {
	}

	public Object getO() {
		return o;
	}

	public void setO(Object o) {
		this.o = o;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}
}
