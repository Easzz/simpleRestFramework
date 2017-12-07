package com.easzz.compoent;

import java.lang.reflect.Method;

/**
 * Created by easzz on 2017/11/19 10:42
 */
public class ActionBean {
	private Class<?> aClass;
	private Method method;

	public ActionBean(Class<?> aClass, Method method) {
		this.aClass = aClass;
		this.method = method;
	}

	public ActionBean() {
	}

	public Class<?> getaClass() {
		return aClass;
	}

	public void setaClass(Class<?> aClass) {
		this.aClass = aClass;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}
}
