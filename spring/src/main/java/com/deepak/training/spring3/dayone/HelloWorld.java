package com.deepak.training.spring3.dayone;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class HelloWorld  {
	private static final Logger logger = LoggerFactory.getLogger(HelloWorld.class);
	
    private String classpathFileName;
    
    private HelloWorld2 helloWorld2;

    public String hello() throws IOException {
        Resource helloWorldTextFileResource = new ClassPathResource(classpathFileName, getClass());
		String text = IOUtils.toString(helloWorldTextFileResource.getInputStream());
		logger.info("Text: {}", text);
		
		helloWorld2.sayHelloAgain();
		
		return text;
	}
    
    public String getMessage() throws IOException {
        return hello();
    }

    public void setClasspathFileName(String classpathFileName) {
        logger.info("in setter");
        this.classpathFileName = classpathFileName;
    }

    public HelloWorld2 getHelloWorld2() {
        return helloWorld2;
    }

//    @Autowired
    public void setHelloWorld2(HelloWorld2 helloWorld2) {
        this.helloWorld2 = helloWorld2;
    }
}
