package com.bridgelabz.employeepayrollappproject.service;

import com.bridgelabz.employeepayrollappproject.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollappproject.model.EmployeePayrollData;

import java.util.List;
import java.util.Optional;

public interface IEmployeePayrollService {

    EmployeePayrollData createEmployePayrollData(EmployeePayrollDTO employeePayrollDTO);

    Object updateEmployePayrollData(EmployeePayrollDTO employeePayrollDTO, int id);

    String deleteEmployePayrollData(int id);

    List<EmployeePayrollData> findAllEmloyePayrollData();

    Optional<EmployeePayrollData> getEmployePayrollDataId(int id);

}
