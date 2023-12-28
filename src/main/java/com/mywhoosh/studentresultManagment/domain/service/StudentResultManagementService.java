package com.mywhoosh.studentresultManagment.domain.service;

import com.mywhoosh.studentresultManagment.base.BaseService;
import com.mywhoosh.studentresultManagment.domain.dto.StudentRequestDto;

public interface StudentResultManagementService extends BaseService {

   String addNewStudent(StudentRequestDto studentRequest);
}
