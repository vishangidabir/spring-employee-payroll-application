package com.bridgelabz.employeepayrollappproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ResponseDTO {

    String message;
    Object data;
}



