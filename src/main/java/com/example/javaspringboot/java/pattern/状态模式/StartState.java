package com.example.javaspringboot.java.pattern.状态模式;

import lombok.NoArgsConstructor;

/**
 * @Author: Liusl
 * @Date: 2020/3/27 15:43
 */
@NoArgsConstructor
public class StartState implements State{
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }
}
