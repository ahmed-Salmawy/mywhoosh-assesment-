package com.mywhoosh.studentresultManagment.domain.repoadapter.impl;

import com.mywhoosh.studentresultManagment.base.AbstractBaseRepoAdapter;
import com.mywhoosh.studentresultManagment.domain.dto.StudentDto;
import com.mywhoosh.studentresultManagment.domain.mapper.StudentMapper;
import com.mywhoosh.studentresultManagment.domain.repo.StudentRepo;
import com.mywhoosh.studentresultManagment.domain.repoadapter.StudentRepoAdapter;
import com.mywhoosh.studentresultManagment.presistance.entity.StudentEntity;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepoAdapterImpl extends AbstractBaseRepoAdapter
        <StudentEntity, StudentDto, StudentMapper, StudentRepo> implements StudentRepoAdapter {
    protected StudentRepoAdapterImpl(StudentMapper mapper, StudentRepo repository) {
        super(mapper, repository);
    }

    @Override
    public void delete(StudentDto dto) {

    }


}
