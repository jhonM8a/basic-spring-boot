package com.jhon.springboot.jhon.bean;

public class MyOperationImplement implements MyOperation {
    @Override
    public Integer sum(Integer numb) {
        return numb + 1;
    }
}
