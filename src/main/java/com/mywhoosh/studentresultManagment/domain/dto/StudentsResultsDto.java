package com.mywhoosh.studentresultManagment.domain.dto;

import com.mywhoosh.studentresultManagment.base.AbstractBaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentsResultsDto extends AbstractBaseDto {
    private String resultId;
    private String name;
    private String status;
    private String rollNumber;
    private String remaks;
    private int totalMarks;
    private int obtainedMarks;

}