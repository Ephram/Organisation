package kz.dulatibrayev.organization;

import java.util.Objects;

public class Employee {
	private String name, surname;
	private String position;
	private double salary;

	public Employee(String name, String surname) {
		this.name = name;
		this.surname = surname;

		this.position = "Engineer";
		this.salary = 30000;
	}

	public Employee(String name, String surname, String position, double salary) {
		this.name = name;
		this.surname = surname;
		this.position = position;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(name, other.name) && Objects.equals(surname, other.surname);
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", surname=" + surname + ", position=" + position + ", salary=" + salary
				+ "]";
	}
	
	
	
}
