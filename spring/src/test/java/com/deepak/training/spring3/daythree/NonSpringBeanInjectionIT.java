package com.deepak.training.spring3.daythree;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deepak.training.spring3.config.daythree.DayTwoAspectJLoadTimeWeavingConfig;
import com.deepak.training.spring3.config.daythree.NonSpringBeanInjection;

/**
 * Don't forge to add -javaagent:/path to aspectjweaver.jar to make this work.
 * 
 * @author abrahd2
 */
@ContextConfiguration(classes = DayTwoAspectJLoadTimeWeavingConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class NonSpringBeanInjectionIT {

    @Test
    public void nameAliasTest() throws IOException {
        NonSpringBeanInjection bean = new NonSpringBeanInjection();
        assertThat(bean.getSomeService(), is(not(nullValue())));
        // assertThat(bean.getName(), is("Tarun"));
    }
}
