package com.deepak.training.spring3.daytwo;

public class AnotherService {

    private SomeService someService;

    public AnotherService(SomeService someService) {
        super();
        this.someService = someService;
    }

    @Override
    public String toString() {
        return "anotherServiceBean string " + someService.fetchValue();
    }

}
