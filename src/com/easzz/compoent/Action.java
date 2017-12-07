package com.easzz.compoent;

import javax.ws.rs.Path;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by easzz on 2017/11/19 10:45
 */
public class Action {
	private static Map<String, ActionBean> actionBeanMap;


	public static ActionBean getActionBeanMap(String path) {
		return actionBeanMap.get(path);
	}

	public static void init(Map<String, Object> beanMap) {
		actionBeanMap = new HashMap<>();
		for (String s : beanMap.keySet()) {
			Object o = beanMap.get(s);
			Class<?> clazz = o.getClass();
			String classPath = clazz.getAnnotation(Path.class).value();
			Method[] methods = clazz.getDeclaredMethods();
			for (Method method : methods) {
				if (method.isAnnotationPresent(Path.class)) {
					String methodPath = method.getAnnotation(Path.class).value();
					String path = "/rest" + classPath + methodPath;
					//放入map容器
					System.out.println(path);
					actionBeanMap.put(path, new ActionBean(clazz, method));
				}
			}
		}
		System.out.println("Action.init finished...");
	}
}
