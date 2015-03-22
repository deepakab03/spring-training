package com.deepak.training.spring3.daytwo;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deepak.training.spring3.config.daytwo.DayTwoConfig;

@ContextConfiguration(classes=DayTwoConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ScopeIT {

    @Autowired private SomeService someService;
    @Autowired private SomeService someService2;
    @Autowired private SomeService someService3;
    
    @Autowired private AnotherService anotherService;
    @Autowired private AnotherService anotherService2;
    @Autowired private AnotherService anotherService3;
    
    @Autowired private ThirdService thirdServiceA;
    @Autowired private ThirdService thirdServiceB;
    
    @Autowired private ApplicationContext ctx;
    
    @Test public void
    whenTestIfMemoryRefIsSame_givenSomeServiceIsSingelton_willBeTrue() {
        assertThat(someService, is(sameInstance(someService2)));
        assertThat(someService, is(sameInstance(someService3)));
        
        assertThat(someService, is(sameInstance(ctx.getBean(SomeService.class))));
    }
    
    @Test public void
    whenTestIfMemoryRefIsSame_givenAnotherServiceIsPrototype_willBeFalse() {
        assertThat(anotherService, is(not(sameInstance(anotherService2))));
        assertThat(anotherService, is(not(sameInstance(anotherService3))));
        assertThat(anotherService, is(not(sameInstance(ctx.getBean(AnotherService.class)))));
    }
    
    @Test public void
    whenTestIfMemoryRefIsSame_given2DifferentSpringBeansOfSameClass_willBeFalse() {
        assertThat(thirdServiceA, is(not(sameInstance(thirdServiceB))));
    }
}
