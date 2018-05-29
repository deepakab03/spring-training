package com.deepak.training.spring3.dayone;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component
//@Repository //gives spring exception translation for jpa dao's, not required for spring-jpa however
//@Service
//@Named
public class AnnotatedHelloWorld {
	private static final Logger logger = LoggerFactory.getLogger(AnnotatedHelloWorld.class);
	
	@Autowired
//	@javax.annotation.Resource
//	@Inject
    private String classpathFileName3;
	
	private AnnotatedHelloWorld2 annotatedHelloWorld2;;

    public String hello() throws IOException {
		Resource helloWorldTextFileResource = new ClassPathResource(classpathFileName3, getClass());
		
		String text = IOUtils.toString(helloWorldTextFileResource.getInputStream());
		logger.info("Text: {}", text);
		
		annotatedHelloWorld2.sayHelloAgain();
		
		return text;
	}

    public void setClasspathFileName(String classpathFileName) {
        this.classpathFileName3 = classpathFileName;
    }

    public AnnotatedHelloWorld2 getAnnotatedHelloWorld2() {
        return annotatedHelloWorld2;
    }

    @Autowired
    public void setAnnotatedHelloWorld2(AnnotatedHelloWorld2 annotatedHelloWorld2) {
        this.annotatedHelloWorld2 = annotatedHelloWorld2;
    }

}
