package com.bridgelabz.employeepayrollappproject.repository;

import com.bridgelabz.employeepayrollappproject.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePayrollRepo extends JpaRepository<EmployeePayrollData, Integer> {

}


