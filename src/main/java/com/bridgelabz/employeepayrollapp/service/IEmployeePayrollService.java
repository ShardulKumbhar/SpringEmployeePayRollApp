package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEmployeePayrollService {
    Employee addEmp(Employee employee);

    Employee deleteEmpById(Long id);

    Employee editEmp(Employee employee);

    Employee findEmpById(Long id);

    List<Employee> findAll();
}
