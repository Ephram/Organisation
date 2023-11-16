package kz.dulatibrayev.organization;

import java.util.Arrays;
import java.util.Comparator;

public class Department {
	private String departmentName;
	private Employee[] employees;

	public Department(String departmentName) {
		this.departmentName = departmentName;
		employees = new Employee[0];
	}

	public Department(Employee[] employees) {
		this.employees = employees;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	// создайте метод, возвращающий общее число работников
	// подразделения;
	public int getDepartmentEmployeeTotal() {
		return this.employees.length;
	}

	// создайте метод, возвращающий суммарную зарплату всех
	// работников, относящихся к данному подразделению
	public double getDepartmentEmployeesSalaryTotal() {
		double totalSalary = 0;
		for (int i = 0; i < employees.length; i++) {
			totalSalary = totalSalary + employees[i].getSalary();
		}
		return totalSalary;
	}

	// создайте метод, возвращающий ссылку на работника по фамилии и
	// имени;

	public Employee getEmployeeByNameAndSurname(String name, String surname) {

		for (int i = 0; i < employees.length; i++) {
			Employee tempEmployee = employees[i];
			if (tempEmployee.getSurname().contentEquals(surname) && tempEmployee.getName().contentEquals(name)) {
				return tempEmployee;
			}
		}
		return null;
	}

//			создайте метод увольнения работника (принимает в качестве входных
//			параметров фамилию, имя, должность работника, которого нужно
//			удалить, удаляет соответствующий этим данным элемент из массива
//			работников);

	public Employee[] terminateEmployee(String name, String surname, String position) {
		int terminatedEmployeeNumber = -1;

		for (int i = 0; i < employees.length; i++) {
			Employee tempEmployee = employees[i];
			if (tempEmployee.getSurname().contentEquals(surname) && tempEmployee.getName().contentEquals(name)
					&& tempEmployee.getPosition().contentEquals(position)) {
				terminatedEmployeeNumber = i;
				break;
			}
		}

		if (terminatedEmployeeNumber != -1) {
			Employee[] employeeArr = new Employee[employees.length - 1];
			for (int i = 0, j = 0; i < employees.length; i++) {
				if (i != terminatedEmployeeNumber) {
					employeeArr[j] = employees[i];
					j++;
				}
			}
			return employeeArr;
		}
		return employees;
	}

//	создайте метод приема работника на работу (принимает в качестве
//	входных параметров ссылку на экземпляр класса Employee,
//	расширяет массив работников путем добавления нового элемента в

	public void hireEmployee(Employee employee) {
		Employee[] tempEmployees = new Employee[employees.length + 1];

		for (int i = 0; i < employees.length; i++) {
			tempEmployees[i] = employees[i];
		}
		tempEmployees[employees.length] = employee;

		this.employees = tempEmployees;
	}

//	создайте метод, возвращающий массив работников отдела;
	public Employee[] getEmployees() {
		return this.employees;
	}

//	создайте метод, возвращающий массив работников отдела,
//	отсортированный по фамилиям (и если одинаковые фамилии – то по
//	именам);

	public void sortEmployeesBySurnameAndName() {
		EmployeeComparatorbySurnameAndName comparator = new EmployeeComparatorbySurnameAndName();
		Arrays.sort(employees, comparator);
	}

}

class EmployeeComparatorbySurnameAndName implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		int res = o1.getSurname().compareTo(o2.getSurname());

		if (res != 0) {
			return res;
		}
		return o1.getName().compareTo(o2.getName());
	}

}
