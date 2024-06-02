package ru.skypro.StreamAPI.Service;

import org.springframework.stereotype.Service;
import ru.skypro.StreamAPI.Employee;
import ru.skypro.StreamAPI.Exceptions.EmployeeAlreadyAddedException;
import ru.skypro.StreamAPI.Exceptions.EmployeeNotFoundException;
import ru.skypro.StreamAPI.Exceptions.EmployeeStorageIsFullException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@Service

public class EmployeeImpl implements IEmployee {
    public final Map<String, Employee> employees;

    public EmployeeImpl() {
        this.employees = new HashMap<>();
    }

    final int maxEmployess = 10;

    @Override
    public Employee addEmployee(String firstName, String lastName, int departmnet, int salary) {
        Employee employee = new Employee(salary, departmnet, firstName, lastName);
        if (employees.size() > maxEmployess) {
            throw new EmployeeStorageIsFullException("мест нет!");
        } else if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник есть");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }
    @Override
    public void removeEmployee(String firstName, String lastName) {
        String fullName = firstName + " " + lastName;
        if (employees.containsKey(fullName)) {
            employees.remove(fullName);
        } else throw new EmployeeNotFoundException("Сотрудника нет");
    }

    @Override
    public void findEmployee(String firstName, String lastName) {
        String fullName = firstName + " " + lastName;
        if (employees.containsKey(fullName)) {
            System.out.println(employees.get(fullName.toString()));
        } else throw new EmployeeNotFoundException("Сотрудника нет");
    }
    @Override

    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }








}
