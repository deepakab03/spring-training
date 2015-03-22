package com.deepak.training.spring3.daythree;

import org.springframework.beans.factory.annotation.Configurable;

@Configurable("nonSpringBean")
public class NonSpringBeanInjection {

    private String name;
    private int    age;
    private double salary;
    private String designation;

    @Override
    public String toString() {
        String str = String.format("child details - name '%s', age '%d', salary '%f', designation '%s'",
                name, age, salary, designation);
        return str;
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
