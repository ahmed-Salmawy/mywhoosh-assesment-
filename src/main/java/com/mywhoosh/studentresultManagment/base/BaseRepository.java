package com.mywhoosh.studentresultManagment.base;

import java.util.List;

public interface BaseRepository<E extends AbstractBaseEntity,ID> {
    E save(E E);

    List<E> saveAll(List<E> personEntities);

    List<E> findAll();

    List<E> findAll(List<ID> ids);

    E findById(ID id);

    long count();

    long delete(ID id);

    long delete(List<ID> ids);

    long deleteAll();

    E update(E E);

    long update(List<E> personEntities);
}
