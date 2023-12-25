package com.mywhoosh.studentresultManagment.base;

import org.springframework.data.mongodb.repository.MongoRepository;

public abstract class AbstractBaseRepoAdapter <E extends AbstractBaseEntity,D extends AbstractBaseDto
        ,M extends BaseMapper<E,D>,R extends BaseRepository>
implements BaseRepoAdapter<D>
{

    protected final M mapper;
    protected final R repository;
    protected AbstractBaseRepoAdapter(M mapper, R repository) {
        this.mapper = mapper;
        this.repository = repository;

    }





}
