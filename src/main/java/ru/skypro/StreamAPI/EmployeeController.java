package ru.skypro.StreamAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.StreamAPI.Service.EmployeeImpl;

import java.util.Collection;

@RestController
@RequestMapping("/employee")

public class EmployeeController {
    private final EmployeeImpl employeeImpl;

    public EmployeeController(EmployeeImpl employeeImpl) {
        this.employeeImpl = employeeImpl;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam("firstName") String firstName,
                        @RequestParam("lastName") String lastName,
                        @RequestParam("departmnet") int departmnet,
                        @RequestParam("salary") int salary
    ) {
         return employeeImpl.addEmployee(firstName, lastName, departmnet, salary);
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("firstName") String firstName,
                         @RequestParam("lastName") String lastName) {
        employeeImpl.removeEmployee(firstName, lastName);
        return "удален";
    }

    @GetMapping("/find")
    public String find(@RequestParam("firstName") String firstName,
                       @RequestParam("lastName") String lastName) {
        employeeImpl.findEmployee(firstName, lastName);
        String fullName = firstName + " " + lastName;
        return employeeImpl.employees.get(fullName).toString();
    }

    @GetMapping("/findAll")
    public Collection<Employee> find() {
        return employeeImpl.findAll();
    }


}
