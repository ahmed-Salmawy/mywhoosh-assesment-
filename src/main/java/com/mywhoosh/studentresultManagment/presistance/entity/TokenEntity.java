package com.mywhoosh.studentresultManagment.presistance.entity;


import com.mywhoosh.studentresultManagment.base.AbstractBaseEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;


@Document("user_tokens")
@Data
public class TokenEntity extends AbstractBaseEntity {

    @Id
    private String id;
    private String token;
    private String username;
    boolean expired;
    public boolean revoked;

    @DocumentReference(lazy = true)
    public UserEntity user;
}
