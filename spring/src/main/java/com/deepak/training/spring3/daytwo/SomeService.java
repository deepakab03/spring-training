package com.deepak.training.spring3.daytwo;

public class SomeService {

    public String fetchValue() {
        return "" + (int) ((Math.random() * 10000));
    }

    @Override
    public String toString() {
        return "someServiceBean string";
    }

}
