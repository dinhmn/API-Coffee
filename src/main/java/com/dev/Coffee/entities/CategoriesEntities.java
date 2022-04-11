package com.dev.Coffee.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "tbl_category")

public class CategoriesEntities{

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String categoriesName;
    private String title;
    private String seo;
    private String description;
    @Column(name = "status", nullable = true)
    private Boolean status = Boolean.TRUE;

    @Column(name = "created_by", nullable = true)
    private Integer created_by;

    @Column(name = "updated_by", nullable = true)
    private Integer updated_by;

    @Column(name = "created_date", nullable = true)
    private Date created_date;

    @Column(name = "updated_date", nullable = true)
    private Date updated_date;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "categoriesEntities")
    private Set<ProductEntities> productEntities = new HashSet<ProductEntities>();
}
