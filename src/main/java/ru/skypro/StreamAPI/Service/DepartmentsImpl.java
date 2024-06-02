package ru.skypro.StreamAPI.Service;

import org.springframework.stereotype.Service;
import ru.skypro.StreamAPI.Employee;
import ru.skypro.StreamAPI.Exceptions.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentsImpl implements Idepartments{
    public DepartmentsImpl(IEmployee iEmployee) {
        this.iEmployee = iEmployee;
    }
    private final IEmployee iEmployee;

    @Override
    public Employee maxSallary(int departments) {
       return iEmployee.findAll().stream()
                .filter(employee -> employee.getDepartmnet() == departments)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(()-> new EmployeeNotFoundException("сотрудника нет"));
    }

    @Override
    public Employee minSallary(int departments) {
        return iEmployee.findAll().stream()
                .filter(employee -> employee.getDepartmnet() == departments)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("сотрудников нет"));
    }



    @Override
    public ArrayList<Employee> allEmployee(int departments) {
        return iEmployee.findAll().stream()
                .filter(employee -> employee.getDepartmnet() == departments)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Map<Integer, List<Employee>> allDep() {
                return iEmployee.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmnet));

    }




}
