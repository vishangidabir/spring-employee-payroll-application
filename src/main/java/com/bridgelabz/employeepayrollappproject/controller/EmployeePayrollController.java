package com.bridgelabz.employeepayrollappproject.controller;

import com.bridgelabz.employeepayrollappproject.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollappproject.dto.ResponseDTO;
import com.bridgelabz.employeepayrollappproject.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollappproject.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    IEmployeePayrollService employeePayrollService;

    /**
     * Create and add employee details to database
     * this is POST call
     * http://localhost:8080/employeepayrollservice/createEmployee
     */
    @PostMapping("/createEmployee")
    public EmployeePayrollData createEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO empPayrollDTO) {
//        ResponseDTO responseDTO = new ResponseDTO("Added Successfully", employeePayrollService.createEmployePayrollData(empPayrollDTO));
        return employeePayrollService.createEmployePayrollData(empPayrollDTO);
    }

    /**
     * Update employee in database by Id
     * this is PUT call
     * http://localhost:8080/employeepayrollservice/updateEmployee/1
     */

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO, @PathVariable int id) {
        ResponseDTO responseDTO = new ResponseDTO("Updated Employee payroll data Successfully", employeePayrollService.updateEmployePayrollData(employeePayrollDTO, id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Delete employee from database by Id
     * this is DELETE call
     * http://localhost:8080/employeepayrollservice/deleteEmployee/3
     */
    @DeleteMapping("deleteEmployee/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable int id) {
        employeePayrollService.deleteEmployePayrollData(id);
        ResponseDTO responseDTO = new ResponseDTO("Successfully deleted", id);
        return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
    }

    /**
     * gets all employees from database
     * this is GET call
     * http://localhost:8080/employeepayrollservice/findAllEmployee
     */
    @GetMapping("/findAllEmployee")
    public List<EmployeePayrollData> findAllEmployeePayroll() {
//        ResponseDTO responseDTO = new ResponseDTO("Succeeded", employeePayrollService.findAllEmloyePayrollData());
//        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        return employeePayrollService.findAllEmloyePayrollData();
    }

    /**
     * gets employee from database by ID
     * this is GET call
     * http://localhost:8080/employeepayrollservice/findEmployee/1
     */
    @GetMapping("/findEmployee/{id}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable int id) {
        ResponseDTO responseDTO = new ResponseDTO("Succeeded", employeePayrollService.getEmployePayrollDataId(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
