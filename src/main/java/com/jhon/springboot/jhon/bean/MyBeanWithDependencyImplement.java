package com.jhon.springboot.jhon.bean;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency {

   private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDepency() {
        System.out.println(myOperation.sum(15));
        System.out.println("Hello from bean with dependency");
    }
}
