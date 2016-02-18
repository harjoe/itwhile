package itwhile.spring.factory;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * <p>
 * 获取spring bean的工具类
 * </p>
 * <p>
 * 注：spring-servlet.xml中的bean并不由ApplicationContext管理, 它由DispatcherServlet管理
 * </p>
 * 
 * @author harjoe
 * 
 */
public class BeanFactory implements ApplicationContextAware
{

	private static ApplicationContext APPLICATION_CONTEXT;
	
	public ApplicationContext getApplicationContext(){
		return BeanFactory.APPLICATION_CONTEXT;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		BeanFactory.APPLICATION_CONTEXT = applicationContext;
	}

	/**
	 * 根据提供的bean名称得到相应的类
	 * 
	 * @param name
	 *            bean名称
	 */
	public static Object getBean(String name) {
		return APPLICATION_CONTEXT.getBean(name);
	}

	/**
	 * 根据提供的指定类型的类得到相应的�?
	 * 
	 * @param servName
	 *            bean名称
	 */
	public static <T> T getBean(Class<T> clazz) {
		return APPLICATION_CONTEXT.getBean(clazz);
	}

	/**
	 * 根据提供的bean名称得到对应于指定类型的�?
	 * 
	 * @param name
	 *            bean名称
	 * @param clazz
	 *            返回的bean类型,若类型不匹配,将抛出异�?
	 */
	public static <T> T getBean(String name, Class<T> clazz) {
		return APPLICATION_CONTEXT.getBean(name, clazz);
	}

}
