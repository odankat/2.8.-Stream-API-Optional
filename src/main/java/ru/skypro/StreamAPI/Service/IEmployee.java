package ru.skypro.StreamAPI.Service;

import ru.skypro.StreamAPI.Employee;

import java.util.Collection;

public interface IEmployee {

    Employee addEmployee(String firstName, String lastName, int departmnet, int salary);

    void removeEmployee(String firstName, String lastName);


    void findEmployee(String firstName, String lastName);

    Collection<Employee> findAll();
}
