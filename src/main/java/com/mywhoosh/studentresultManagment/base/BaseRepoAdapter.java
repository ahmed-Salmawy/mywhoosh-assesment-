package com.mywhoosh.studentresultManagment.base;

public interface BaseRepoAdapter  <D extends AbstractBaseDto>{

      String create(D dto);
      void update(D dto);
      void delete(D dto);
      D retrieve(String id);
}
