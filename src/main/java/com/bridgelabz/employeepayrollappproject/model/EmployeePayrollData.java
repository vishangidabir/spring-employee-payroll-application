package com.bridgelabz.employeepayrollappproject.model;

import com.bridgelabz.employeepayrollappproject.dto.EmployeePayrollDTO;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
public class EmployeePayrollData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String name;
    public String gender;
    @ElementCollection
    @CollectionTable(name = "department", joinColumns = @JoinColumn(name = "id"))
    public List<String> department;
    public long salary;
    public LocalDate startDate;
    public String notes;
    public String profilePic;
//    public String email;

//    public EmployeePayrollData(int id, String name, String gender, int salary, LocalDate startDate, String profilePic, String notes, List<String> department) {
//        this.id = id;
//        this.name = name;
//        this.gender = gender;
//        this.salary = salary;
//        this.startDate = startDate;
//        this.profilePic = profilePic;
//        this.notes = notes;
//        this.department = department;
//    }

    public EmployeePayrollData() {
    }

    public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO, String gender, LocalDate startDate, String profilePic, String notes) {
        this.name = employeePayrollDTO.getName();
        this.salary = employeePayrollDTO.getSalary();
        this.department = employeePayrollDTO.getDepartment();
        this.gender = gender;
        this.startDate = startDate;
        this.profilePic = profilePic;
        this.notes = notes;
    }

    public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        this.name = employeePayrollDTO.getName();
        this.gender = employeePayrollDTO.getGender();
        this.notes = employeePayrollDTO.getNotes();
        this.startDate = employeePayrollDTO.getStartDate();
        this.profilePic = employeePayrollDTO.getProfilePic();
        this.salary = employeePayrollDTO.getSalary();
        this.department = employeePayrollDTO.getDepartment();
//        this.email = employeePayrollDTO.getEmail();
    }

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<String> getDepartment() {
        return department;
    }

    public void setDepartment(List<String> department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                ", startDate=" + startDate +
                ", profilePic=" + profilePic +
                ", notes='" + notes + '\'' + '}';
    }
}