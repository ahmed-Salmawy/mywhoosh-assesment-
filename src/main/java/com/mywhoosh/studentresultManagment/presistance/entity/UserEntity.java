package com.mywhoosh.studentresultManagment.presistance.entity;

import com.mywhoosh.studentresultManagment.base.AbstractBaseEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document("users")
@Data
public class UserEntity extends AbstractBaseEntity  {
    @Id
    private String id;
    private String username;
    private String password;


}
