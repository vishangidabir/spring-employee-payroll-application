package com.bridgelabz.employeepayrollappproject.service;

import com.bridgelabz.employeepayrollappproject.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollappproject.dto.ResponseDTO;
import com.bridgelabz.employeepayrollappproject.email.EmailService;
import com.bridgelabz.employeepayrollappproject.exception.CustomExecption;
import com.bridgelabz.employeepayrollappproject.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollappproject.repository.EmployeePayrollRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
    EmployeePayrollRepo employeePayrollRepo;

    @Autowired
    EmailService emailService;

    public EmployeePayrollData createEmployePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(employeePayrollDTO);
//        emailService.sendEmail(employeePayrollDTO.getEmail(), "Employee added SuccessFully", "Hello " + employeePayrollData.getName() + " your employee record was added successfully");
        return employeePayrollRepo.save(employeePayrollData);
    }


    public EmployeePayrollData updateEmployePayrollData(EmployeePayrollDTO employeePayrollDTO, int id) {
        if (employeePayrollRepo.existsById(id)) {
            EmployeePayrollData employeePayrollData = employeePayrollRepo.findById(id).get();
            employeePayrollData.setName(employeePayrollDTO.getName());
            employeePayrollData.setSalary(employeePayrollDTO.getSalary());
            return employeePayrollRepo.save(employeePayrollData);
        } else {
            throw new CustomExecption("Employee Not found! id " + id);
        }
    }

    public String deleteEmployePayrollData(int id) {
        if (employeePayrollRepo.findById(id).isPresent()) {
            employeePayrollRepo.deleteById(id);
            return "Deleted Successfully!";
        } else {
            throw new CustomExecption("Employee Table is Empty!");
        }
    }

    public List<EmployeePayrollData> findAllEmloyePayrollData() {
        if (!employeePayrollRepo.findAll().isEmpty()) {
            return employeePayrollRepo.findAll();
        } else throw new CustomExecption("Employee Table is Empty!");
    }


    public Optional<EmployeePayrollData> getEmployePayrollDataId(int id) {
        if (employeePayrollRepo.findById(id).isPresent()) {
            return employeePayrollRepo.findById(id);
        } else {
            throw new CustomExecption("Employee is not found! id = " + id + " not found");
        }
    }
}


