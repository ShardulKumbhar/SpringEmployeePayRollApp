package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    /**
     * Autowired interface
     */
    @Autowired
    private IEmployeePayrollService employeePayrollService;

    /**
     * created http request to add person to payroll.
     * http://localhost:8080/employee/add
     * json format to add in json:-
     * "firstName" : "Shardul",
     *     "lastName" : "Kumbhar",
     *     "salary" : 100
     */
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeePayrollService.addEmp(employee);
    }

    /**
     * Request to edit payroll person
     * http://localhost:8080/employee/edit
     * @param employee
     * @return employee json on successful edition
     */
    @PutMapping("/edit")
    public Employee editEmployeeBy(@RequestBody Employee employee) {
        return employeePayrollService.editEmp(employee);
    }

    /**
     * to find employee by id
     * http://localhost:8080/employee/find/2
     * @param id
     * @return returns employeejson if found in database .
     */
    @GetMapping("/find/{id}")
    public Employee findEmployeeById(@PathVariable(value = "id") Long id) {
        return employeePayrollService.findEmpById(id);
    }

    /**
     * to find all emplyee on payroll
     * http://localhost:8080/employee/findall
     * @return ret list of employee details
     */
    @GetMapping("/findall")
    public List<Employee> findAllEmployeeData() {
        return employeePayrollService.findAll();
    }


    /**
     * to dele emplyee on payroll.
     * http://localhost:8080/employee/delete
     * @param id
     * @return-Employee to me deleted
     */
    @DeleteMapping("/delete")
    public Employee deleteEmployeeById(@RequestParam Long id) {
        return employeePayrollService.deleteEmpById(id);
    }
}
