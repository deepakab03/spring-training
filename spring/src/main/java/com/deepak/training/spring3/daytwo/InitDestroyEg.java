package com.deepak.training.spring3.daytwo;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.deepak.training.spring3.dayone.HelloWorld;

public class InitDestroyEg {
	private static final Logger logger = LoggerFactory.getLogger(InitDestroyEg.class);
	
    private String classpathFileName;
    
    private Resource helloWorldTextFileResource;

    public InitDestroyEg() {
        logger.info("in constructor");
    }
    
    public void init() {
        logger.info("In init");
        helloWorldTextFileResource = new ClassPathResource(classpathFileName, HelloWorld.class);
    }
    
    public void destroy() {
        logger.info("In destroy");
    }
    
    public String hello() throws IOException {
		String text = IOUtils.toString(helloWorldTextFileResource.getInputStream());
		logger.info("Text1: {}", text);
		
		return text;
	}
    
    public void setClasspathFileName(String classpathFileName) {
        logger.info("in setter of classpathName");
        this.classpathFileName = classpathFileName;
    }
}
