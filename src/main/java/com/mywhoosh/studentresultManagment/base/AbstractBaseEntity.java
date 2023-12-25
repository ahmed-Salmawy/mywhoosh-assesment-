package com.mywhoosh.studentresultManagment.base;

import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public abstract class AbstractBaseEntity implements Serializable {

    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private String updatedBy;
    private String createdBy;

    public abstract String getId();




}
