package com.deepak.training.spring3.config.daythree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.deepak.training.spring3.daytwo.SomeService;

@Configurable
//preconstruction?
public class NonSpringBeanInjection {

    private String name;
    private int    age;
    private double salary;
    private String designation;
    
    private SomeService someService;
    
    public NonSpringBeanInjection() {
    }
    
    @Override
    public String toString() {
        String str = String.format("NonSprinbBeanInjected details - name '%s', age '%d', salary '%f', designation '%s'",
                name, age, salary, designation);
        return str;
    }
    
    @Autowired 
    public void setSomeService(SomeService someService) {
        this.someService = someService;
    }

    public SomeService getSomeService() {
        return someService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
