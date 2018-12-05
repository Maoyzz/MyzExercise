package com.myz.myzexercise.Practice;

import java.io.Serializable;

public class TestModel1 implements Serializable{
    private int num;

    public TestModel1(int num){
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
