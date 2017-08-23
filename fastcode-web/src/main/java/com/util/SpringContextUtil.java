package com.util;

import org.springframework.context.ApplicationContext;
/**
 * 上下文获取工具类
 * @author mengfeiyang
 *
 */
public class SpringContextUtil {
	  private static ApplicationContext applicationContext;

	  public static void setApplicationContext(ApplicationContext context) {
	    applicationContext = context;
	  }
	  
	   public static <T> T getBean(String beanId,Class clazz) {
	    return (T)applicationContext.getBean(beanId,clazz);
	  }
}
