package com.jhon.springboot.jhon.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency {

   private MyOperation myOperation;
   Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);
   public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDepency() {
       LOGGER.info("Init printWithDepency");
        System.out.println(myOperation.sum(15));
        System.out.println("Hello from bean with dependency");
    }
}
