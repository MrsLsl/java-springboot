package com.example.javaspringboot.java.pattern.状态模式;

/**
 * @Author: Liusl
 * @Date: 2020/3/27 15:43
 */
public class Context {
    private State state;

    public Context(){
        state = null;
    }

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return state;
    }
}
