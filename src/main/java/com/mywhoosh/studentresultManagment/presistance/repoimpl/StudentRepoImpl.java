package com.mywhoosh.studentresultManagment.presistance.repoimpl;

import com.mywhoosh.studentresultManagment.domain.repo.StudentRepo;
import com.mywhoosh.studentresultManagment.presistance.entity.StudentEntity;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepoImpl extends AbstractBaseRepo<StudentEntity, String> implements StudentRepo {
    protected StudentRepoImpl(MongoTemplate mongoTemplate) {
        super(StudentEntity.class, mongoTemplate);
    }
}
