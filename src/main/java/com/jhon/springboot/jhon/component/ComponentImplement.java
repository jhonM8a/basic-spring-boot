package com.jhon.springboot.jhon.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplement implements ComponentDependecy {
    @Override
    public void saludar() {
        System.out.println("Hello wordl!");
    }
}
