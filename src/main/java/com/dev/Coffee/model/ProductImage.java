package com.dev.Coffee.model;

import com.dev.Coffee.entities.ProductEntities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductImage {

    private Long id;
    private Boolean status;
    private Integer created_by;
    private Integer updated_by;
    private Date created_date;
    private Date updated_date;
    private String title;
    private String path;

    private ProductEntities productEntities;
}
