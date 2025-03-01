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

        System.out.printf("Email of people whose salary is more than %.2f", minimumSalary);
        filteredEmployeesList.forEach((Employee employee) -> System.out.println(employee.getEmail()));

        // int sum = employees.stream().reduce((Employee previousEmployee,
        // Employee nextEmployee) -> previousEmployee.getSalary() +
        // nextEmployee.getSalary());

        sc.close();
    }
}
