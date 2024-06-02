package ru.skypro.StreamAPI.Service;

import ru.skypro.StreamAPI.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface Idepartments {
    Employee maxSallary(int departments);

    Employee minSallary(int departments);

    ArrayList<Employee> allEmployee(int departments);



    Map<Integer, List<Employee>> allDep();
}
