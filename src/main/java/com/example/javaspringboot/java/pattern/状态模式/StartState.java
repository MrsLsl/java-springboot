package com.example.javaspringboot.java.pattern.状态模式;

/**
 * @Author: Liusl
 * @Date: 2020/3/27 15:43
 */
public class StartState implements State{
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }
}
