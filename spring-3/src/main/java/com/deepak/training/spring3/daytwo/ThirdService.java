package com.deepak.training.spring3.daytwo;

public class ThirdService {

    private SomeService someService;

    public ThirdService(SomeService someService) {
        super();
        this.someService = someService;
    }

    @Override
    public String toString() {
        return "thirdServiceBean string " + someService.fetchValue();
    }

}
