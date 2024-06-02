package ru.skypro.StreamAPI;

import java.util.Objects;

public class Employee {
    private int salary;
    private int departmnet;
    private String firstName;
    private String lastName;


    public Employee(int salary, int departmnet, String firstName, String lastName) {
        this.salary = salary;
        this.departmnet = departmnet;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDepartmnet() {
        return departmnet;
    }

    public void setDepartmnet(int departmnet) {
        this.departmnet = departmnet;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", departmnet=" + departmnet +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && departmnet == employee.departmnet && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary, departmnet, firstName, lastName);
    }
}
