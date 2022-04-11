package com.dev.Coffee.model;

import com.dev.Coffee.entities.CategoriesEntities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product{

    private Long id;
    private Boolean status;
    private Integer created_by;
    private Integer updated_by;
    private Date created_date;
    private Date updated_date;
    private String title;
    private BigDecimal price;
    private BigDecimal priceSale;
    private String shortDescription;
    private String detailsDescription;
    private String imageProduct;
    private Long quantity;
    private String seo;

    private Long categoriesId;
}
