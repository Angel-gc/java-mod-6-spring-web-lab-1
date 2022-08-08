package com.example.demo.CustomExceptions;

import org.springframework.http.HttpStatus;

//@ReponseStatus(value = HttpStatus.FORBIDDEN, reason = "Employee isn't authorized")
public class PostStudentException extends Exception{
}
