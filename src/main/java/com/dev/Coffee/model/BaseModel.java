package com.dev.Coffee.model;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public abstract class BaseModel {
    private Long id;
    private Boolean status;
    private Integer created_by;
    private Integer updated_by;
    private Date created_date;
    private Date updated_date;
}
