package com.deepak.training.spring3.daytwo;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.deepak.training.spring3.dayone.HelloWorld;

public class InitDestroyEg3 {
	private static final Logger logger = LoggerFactory.getLogger(InitDestroyEg3.class);
	
    private String classpathFileName;
    
    private Resource helloWorldTextFileResource;

    public InitDestroyEg3() {
    }
    
    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        logger.info("In afterPropertiesSet 3");
        helloWorldTextFileResource = new ClassPathResource(classpathFileName, HelloWorld.class);
    }
    
    @PreDestroy
    public void destroy() {
        logger.info("In destroy3");
    }
    
    public String hello() throws IOException {
		String text = IOUtils.toString(helloWorldTextFileResource.getInputStream());
		logger.info("Text3: {}", text);
		
		return text;
	}
    
    public void setClasspathFileName(String classpathFileName) {
        this.classpathFileName = classpathFileName;
    }
}
