package com.dev.Coffee.model;

import com.dev.Coffee.entities.ProductEntities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Categories{
    private Long id;

    private String categoriesName;
    private String title;
    private String seo;
    private String description;
    private Boolean status;
    private Integer created_by;
    private Integer updated_by;
    private Date created_date;
    private Date updated_date;

    private Set<ProductEntities> productEntities = new HashSet<ProductEntities>();


}
