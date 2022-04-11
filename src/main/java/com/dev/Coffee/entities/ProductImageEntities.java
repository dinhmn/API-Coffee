package com.dev.Coffee.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "tbl_product_images")
public class ProductImageEntities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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

    private String pathName;
    private String downloadURL;
    private Long size;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private ProductEntities productEntities;



}
