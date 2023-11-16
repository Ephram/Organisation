package kz.dulatibrayev.organization;

public class TestOrganisation {
	public static void main(String[] args) {
		Employee employee1 = new Employee("James", "Bond", "Agent", 1_000);
		Employee employee2 = new Employee("Elon", "Musk", "Enterprneur", 1_000_000);
		Employee employee3 = new Employee("Lebron", "James", "Sportsmen", 100_000);
		Employee employee4 = new Employee("Sherlock", "Holmes", "Detective", 100);

		Employee employee5 = new Employee("David", "James", "Driver", 100_000);
		Employee employee6 = new Employee("Andrew", "James", "Programmer", 100_000);

		Employee[] employees = new Employee[6];
		employees[0] = employee1;
		employees[1] = employee2;
		employees[2] = employee3;
		employees[3] = employee4;
		employees[4] = employee5;
		employees[5] = employee6;

		Department department = new Department(employees);

		department.setDepartmentName("Famous");
		System.out.println("salary total of dep " + department.getDepartmentEmployeesSalaryTotal());
		System.out.println(department.getEmployeeByNameAndSurname("James", "Bond"));
//		employees = department.terminateEmployee("James", "Bond", "Agent");

		department.sortEmployeesBySurnameAndName();
		System.out.println("--------------");

		for (int i = 0; i < employees.length; i++) {
			System.out.println(employees[i]);
		}

		department.hireEmployee(employee1);
	}
}
