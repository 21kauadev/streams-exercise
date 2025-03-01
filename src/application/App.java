package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>();

        System.out.print("How many employees? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Data for Employee #" + (i + 1));
            System.out.print("Enter Employee name: ");
            sc.nextLine();
            String employeeName = sc.nextLine();

            System.out.print("Enter Employee email: ");
            String employeeEmail = sc.nextLine();

            System.out.print("Enter Employee salary: ");
            double employeeSalary = sc.nextDouble();

            employees.add(new Employee(employeeName, employeeEmail, employeeSalary));
        }

        System.out.print("Enter minimum salary: ");
        double minimumSalary = sc.nextDouble();

        // aqui começa o uso de stream, lambdas, pipelines

        List<Employee> filteredEmployeesList = employees.stream()
                .filter((employee) -> employee.getSalary() >= minimumSalary).collect(Collectors.toList());

        System.out.printf("Email of people whose salary is more than %.2f%n:", minimumSalary);
        filteredEmployeesList.forEach((Employee employee) -> System.out.println(employee.getEmail()));

        // pipeline aqui. (cadeia de operaçoes de stream)
        // operações intermediarias (filter e map)
        // operação terminal (não retorna uma stream) - reduce

        double salarySum = employees.stream()
                .filter((Employee employee) -> employee.getName().charAt(0) == 'M')
                .map((Employee employee) -> employee.getSalary())
                .reduce(0.0, (employeeSalary1, employeeSalary2) -> employeeSalary1 + employeeSalary2);

        System.out.printf("Sum of salary of people whose name starts with 'M': %.2f%n", salarySum);

        sc.close();
    }
}
