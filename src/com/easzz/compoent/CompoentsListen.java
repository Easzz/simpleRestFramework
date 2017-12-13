package com.easzz.compoent;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.ws.rs.Path;
import java.util.Map;

/**
 * Created by easzz on 2017/11/19 10:26
 * <p>
 * spring bean加载完成后触发此接口
 */
@Component
public class CompoentsListen implements ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		System.out.println("onApplicationEvent start...");
		if (contextRefreshedEvent.getApplicationContext().getParent() == null) {

			//获取包含特定注解的bean
			Map<String, Object> objectMap = contextRefreshedEvent.getApplicationContext().getBeansWithAnnotation(Path.class);
			Action.init(objectMap);
		}
	}
}
