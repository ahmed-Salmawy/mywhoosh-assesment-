package com.mywhoosh.studentresultManagment.presistance.repoimpl;

import com.mywhoosh.studentresultManagment.base.SequenceGenerator;
import com.mywhoosh.studentresultManagment.security.repo.UserRepository;
import com.mywhoosh.studentresultManagment.presistance.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepoImpl extends AbstractBaseRepo<UserEntity, String> implements UserRepository {


    @Autowired
    protected UserRepoImpl( MongoTemplate mongoTemplate) {
        super(UserEntity.class, mongoTemplate);
    }

    @Override
    public Optional<UserEntity> findById(String id) {
        return Optional.ofNullable(findOne(id));
    }

    @Override
    public Optional<UserEntity> findByUsername(String id) {
        return Optional.empty();
    }
}
