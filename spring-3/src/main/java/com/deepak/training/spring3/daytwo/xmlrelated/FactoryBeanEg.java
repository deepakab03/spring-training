package com.deepak.training.spring3.daytwo.xmlrelated;

import java.util.Collections;
import java.util.List;

public class FactoryBeanEg {

    public List<String> createInstance() {
        return Collections.singletonList("" + Math.random());
    }
}
