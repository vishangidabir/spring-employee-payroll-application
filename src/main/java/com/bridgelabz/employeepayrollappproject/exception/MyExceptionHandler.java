package com.bridgelabz.employeepayrollappproject.exception;

import com.bridgelabz.employeepayrollappproject.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(CustomExecption.class)
    public ResponseEntity<ResponseDTO> employeePayrollException(CustomExecption exeception) {
        ResponseDTO responseDTO = new ResponseDTO("EmployeePayroll Exception! ", exeception.getMessage());
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
