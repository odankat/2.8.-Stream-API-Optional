package ru.skypro.StreamAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.skypro.StreamAPI.Service.Idepartments;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")


public class DepartmentController {
    public DepartmentController(Idepartments idepartments) {
        this.idepartments = idepartments;
    }
    private final Idepartments idepartments;
    @GetMapping("/max-salary")

    public Employee maxSalary(@RequestParam("departament") int departament) {
        return idepartments.maxSallary(departament);
    }
    @GetMapping("/min-salary")
    public Employee minSalary(@RequestParam("departament") int departament) {
        return idepartments.minSallary(departament);
    }

    @GetMapping("/all")
    public ArrayList<Employee> allEmployee(@RequestParam("departament") int departament) {
        return idepartments.allEmployee(departament);
    }

    @GetMapping("/allDep")
    public Map<Integer, List<Employee>> allDep() {
        return idepartments.allDep();
    }

    }

