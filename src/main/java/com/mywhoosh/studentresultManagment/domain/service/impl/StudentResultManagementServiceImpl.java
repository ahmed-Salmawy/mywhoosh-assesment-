package com.mywhoosh.studentresultManagment.domain.service.impl;

import com.mywhoosh.studentresultManagment.base.AbstractBaseService;
import com.mywhoosh.studentresultManagment.domain.dto.StudentDto;
import com.mywhoosh.studentresultManagment.domain.dto.StudentRequestDto;
import com.mywhoosh.studentresultManagment.domain.repoadapter.StudentRepoAdapter;
import com.mywhoosh.studentresultManagment.domain.service.StudentResultManagementService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class StudentResultManagementServiceImpl extends AbstractBaseService<StudentDto, StudentRepoAdapter> implements StudentResultManagementService {
    protected StudentResultManagementServiceImpl(StudentRepoAdapter repoAdapter) {
        super(repoAdapter);
    }


    @Override
    public String addNewStudent(StudentRequestDto studentRequest) {
        try {
            StudentDto studentDto = StudentDto.builder().grade(studentRequest.getGrade())
                    .name(studentRequest.getName())
                    .fatherName(studentRequest.getFatherName())
                    .rollNumber(studentRequest.getRollNumber()).build();
            repoAdapter.create(studentDto);
            return "Student added successfully :) ";
        } catch (DuplicateKeyException e) {
            return " Student registered before";
        }

    }


}
