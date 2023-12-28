package com.mywhoosh.studentresultManagment.presistance.entity;

import com.mywhoosh.studentresultManagment.base.AbstractBaseEntity;
import com.mywhoosh.studentresultManagment.domain.enums.RemarkEnum;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document("results")
public class StudentResultEntity extends AbstractBaseEntity {
    @Id
    private String Id;

    private Double totalMarks;
    private Double obtainedMarks;
    private Integer rollNumber;
    private Integer grade;
    private RemarkEnum remarks;
    private Integer PositionInClass;

    @Override

    public String getId() {
        return null;
    }
}
