package com.sergio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {

		Employee john = new Employee("John Doe", 30);
		Employee tim = new Employee("Tim Buchalka", 21);
		Employee jack = new Employee("Jack Hill", 40);
		Employee snow = new Employee("Snow White", 22);
		Employee red = new Employee("Red Ridinghood", 35);
		Employee charming = new Employee("Prince Charming", 31);

		List<Employee> employees = new ArrayList<>();
		employees.add(john);
		employees.add(tim);
		employees.add(jack);
		employees.add(snow);
		employees.add(red);
		employees.add(charming);
		
		// even though there is only one statement, we need the curly braces
		// because we are returning a value.
		Function<Employee, String> getLastName = (Employee employee) -> {
			return employee.getName().substring(employee.getName().indexOf(' ') + 1);
		};

		Function<Employee, String> getFirstName = (Employee employee) -> {
			return employee.getName().substring(0, employee.getName().indexOf(' '));
		};
		
	
		String lastName = getLastName.apply(employees.get(1));
//		System.out.println(lastName);
		
//		printEmployeesByAge(employees, "Employees over 30", employee -> employee.getAge() > 30);
//		printEmployeesByAge(employees, "\nEmployees 30 and under", employee -> employee.getAge() <= 30);
//		printEmployeesByAge(employees, "\nEmployees younger than 25", new Predicate<Employee>() {
//			@Override
//			public boolean test(Employee employee) {
//				return employee.getAge() < 25;
//			}
//		});
//		
//		// each variable 'i' is within the scope of a single lambda
//		IntPredicate greaterThan15 = i -> i > 15;
//		IntPredicate lessThan100 = i -> i < 100;
		
//		System.out.println(greaterThan15.test(10));
//		int a = 20;
//		System.out.println(greaterThan15.test(a+5));
//		
//		// chaining predicates
//		System.out.println(greaterThan15.and(lessThan100).test(50));
//		System.out.println(greaterThan15.and(lessThan100).test(15));
//		
//		Random random = new Random();
//		Supplier<Integer> randomSupplier = () -> random.nextInt(1000);	
//		
//		for(int i=0; i<10;i++) {
//			System.out.println(randomSupplier.get());
//		}
//		
//		employees.forEach(employee -> {
//			String lastName = employee.getName().substring(employee.getName().indexOf(' ') + 1);
//			System.out.println("Last name is: " + lastName);
//		});
		
		Random random1 = new Random();
		for(Employee employee : employees) {
			if(random1.nextBoolean()) {
				System.out.println(getAName(getFirstName, employee));
			} else {
				System.out.println(getAName(getLastName, employee));
			}
		}
		
	}
	
	private static String getAName(Function<Employee, String> getName, Employee employee) {
		return getName.apply(employee);
	}
	

	private static void printEmployeesByAge(List<Employee> employees, String ageText,
			Predicate<Employee> ageCondition) {
		System.out.println(ageText);
		System.out.println("******");
		for (Employee employee : employees) {
			if (ageCondition.test(employee)) {
				System.out.println(employee.getName());
			}
		}

		// for(Employee employee : employees) {
		// if(employee.getAge() > 30) {
		// System.out.println(employee.getName());
		// }
		// }

		// employees.forEach(employee -> {
		// System.out.println(employee.getName());
		// System.out.println(employee.getAge());
		// });

		// employees.forEach(new Consumer<Employee>() {
		//
		// @Override
		// public void accept(Employee t) {
		// System.out.println(t.getName());
		// System.out.println(t.getAge());
		// }
		// });
	}
}