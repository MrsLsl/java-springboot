package com.example.javaspringboot.java.java8.lambda;
/**
 * @Author Liusl
 * @Date 2020/3/25 22:30
 */
public class FilterEmployeeForSalary implements MyPredicate<Employee> {

	@Override
	public boolean test(Employee t) {
		return t.getSalary() >= 5000;
	}

}
