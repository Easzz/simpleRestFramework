import org.springframework.web.context.ContextLoader;

/**
 * Created by easzz on 2017/11/18 19:47
 */
public class ComponentsLoader {
	public synchronized void init() {
		//获取spring 容器中的 bean
		String[] beanDefinitionNames = ContextLoader.getCurrentWebApplicationContext().getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}
	}
}
