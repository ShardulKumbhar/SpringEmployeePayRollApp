package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePayrollservice implements IEmployeePayrollService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    /**
     * method to add Employee to data base
     * @param employee
     * @return
     */
    @Override
    public Employee addEmp(Employee employee) {
        return employeeRepository.save(employee);
    }

    /**
     * method to edit employee on roll
     * @param employee
     * @return
     */
    @Override
    public Employee editEmp(Employee employee) {
        if (employeeRepository.findById(employee.getId()).isPresent()) {
            return employeeRepository.save(employee);
        }
        return null;
    }


    /**
     * method to find employee by id
     * @param id
     * @return
     */
    @Override
    public Employee findEmpById(Long id) {
        if (employeeRepository.findById(id).isPresent())
            return employeeRepository.findById(id).get();
        return null;
    }

    /**
     * method to see all employee on payroll
     * @return
     */
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    /**
     * method to delete employeee on payroll.
     * @param id
     * @return
     */
    @Override
    public Employee deleteEmpById(Long id) {
        Employee employee = null;
        if (employeeRepository.findById(id).isPresent()) {
            employee = employeeRepository.findById(id).get();
            employeeRepository.deleteById(id);
        }
        return employee;
    }
}
