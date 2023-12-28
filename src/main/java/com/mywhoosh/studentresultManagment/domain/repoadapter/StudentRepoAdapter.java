package com.mywhoosh.studentresultManagment.domain.repoadapter;

import com.mywhoosh.studentresultManagment.base.BaseRepoAdapter;
import com.mywhoosh.studentresultManagment.domain.dto.StudentDto;
import com.mywhoosh.studentresultManagment.domain.dto.StudentsResultsDto;

import java.util.List;

public interface StudentRepoAdapter extends BaseRepoAdapter<StudentDto> {
    StudentDto findByRollNumber(Integer rollNumber);
    public List<StudentsResultsDto> getActiveStudentsWithResults() ;
}
