package com.dev.Coffee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Contact {
    private Long id;
    private Boolean status;
    private Integer created_by;
    private Integer updated_by;
    private Date created_date;
    private Date updated_date;
    private String name;
    private String email;
    private String message;
}
