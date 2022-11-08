package com.bridgelabz.employeepayrollappproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component

public class EmployeePayrollDTO {

    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,}$", message = "Not a Valid Name")
    public String name;
    public long salary;
    public String gender;
    public String notes;
//    public String email;
    public LocalDate startDate;
    public String profilePic;
    public List<String> department;
}


