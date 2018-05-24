/**
 * 
 */
package com.perot.training.daythree;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author user
 *
 */
public class InitDestroy implements BeanNameAware, ApplicationContextAware{
    private static final Log logger = LogFactory.getLog(InitDestroy.class);
	
	private String message;
	private ApplicationContext ctx;

	public void init() {
		logger.info("in init message - " + getMessage());
	}
	
	public void destroy() {
		logger.info("in destroy");
//		ctx.getBean("aaa")
	}

	public void setBeanName(String arg0) {
		logger.info("Bean name " + arg0);
	}

	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		ctx=arg0;
		logger.info("app ctx " + arg0.getDisplayName());
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
