package com.deepak.training.spring3.daytwo;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.deepak.training.spring3.dayone.HelloWorld;

public class InitDestroyEg2 implements InitializingBean, DisposableBean {
	private static final Logger logger = LoggerFactory.getLogger(InitDestroyEg2.class);
	
    private String classpathFileName;
    
    private Resource helloWorldTextFileResource;

    public InitDestroyEg2() {
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("In afterPropertiesSet 2");
        helloWorldTextFileResource = new ClassPathResource(classpathFileName, HelloWorld.class);
    }
    
    @Override
    public void destroy() {
        logger.info("In destroy2");
    }
    
    public String hello() throws IOException {
		String text = IOUtils.toString(helloWorldTextFileResource.getInputStream());
		logger.info("Text2: {}", text);
		
		return text;
	}
    
    public void setClasspathFileName(String classpathFileName) {
        this.classpathFileName = classpathFileName;
    }
}
