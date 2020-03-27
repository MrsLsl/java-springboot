package com.example.javaspringboot.java.pattern.策略模式;

/**
 * 定义活动
 *
 * @Author: Liusl
 * @Date: 2020/3/27 15:25
 */
public interface Strategy {

    /**
     * do operation
     *
     * @param num1
     * @param num2
     * @return int
     */
    int doOperation(int num1, int num2);

}
