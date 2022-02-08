package com.jhon.springboot.jhon.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImplement implements ComponentDependecy{
    @Override
    public void saludar() {
        System.out.println("Hello men!!");
    }
}
