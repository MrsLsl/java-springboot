package com.example.javaspringboot.java.pattern.状态模式;

/**
 * @Author: Liusl
 * @Date: 2020/3/27 15:44
 */
public class StopState implements State{
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }

    public String toString(){
        return "Stop State";
    }
}
