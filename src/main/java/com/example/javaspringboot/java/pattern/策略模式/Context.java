package com.example.javaspringboot.java.pattern.策略模式;

/**
 * @Author: Liusl
 * @Date: 2020/3/27 15:37
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}
