package com.mywhoosh.studentresultManagment.domain.controller;

import com.mywhoosh.studentresultManagment.base.AbstractBaseController;
import com.mywhoosh.studentresultManagment.domain.dto.*;
import com.mywhoosh.studentresultManagment.domain.service.StudentResultManagementService;
import jakarta.validation.Valid;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.util.HtmlUtils;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class StudentResultManagementController extends AbstractBaseController<StudentResultManagementService> {
    public StudentResultManagementController(StudentResultManagementService service) {
        super(service);
    }


    @MessageMapping("/student")
    @SendTo("/topic/students")
    public MessageResponseDto addStudent(@Valid StudentRequestDto requestDto) throws Exception {
        String result = service.addNewStudent(requestDto);
        return new MessageResponseDto(result);
    }
   /* @MessageExceptionHandler(MethodArgumentNotValidException.class)
    @SendToUser("/queue/errors")
    public MessageResponseDto handleValidationException(MethodArgumentNotValidException ex) {
        // Log or handle the validation exception as needed
        // You can access the validation errors using ex.getBindingResult()

        List<String> errorMessages = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());

        return new MessageResponseDto("Validation failed".concat(errorMessages.toString()));
    }*/


    @MessageMapping("/result")
    @SendTo("/topic/students")
    public MessageResponseDto saveResult(StudentResultRequestDto resultRequestDto) throws Exception {

        return new MessageResponseDto(service.saveStudentResult(resultRequestDto));
    }


    @MessageMapping("/delete-student")
    @SendTo("/topic/students")
    public MessageResponseDto deleteStudent(DeleteStudentRequestDto deleteStudentRequestDto) throws Exception {

        return new MessageResponseDto(service.deleteStudent(deleteStudentRequestDto));
    }

}
