package com.example.javaspringboot.java.java8.lambda;
/**
 * @Author Liusl
 * @Date 2020/3/25 22:30
 */
public class FilterEmployeeForAge implements MyPredicate<Employee>{

	@Override
	public boolean test(Employee t) {
		return t.getAge() <= 35;
	}

}
