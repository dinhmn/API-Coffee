package com.dev.Coffee.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "tbl_product")

public class ProductEntities {

    @Id // primary key
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
    private String title;
    @Column(name = "price", precision = 13, scale = 2, nullable = false)
    private BigDecimal price;
    @Column(name = "price_sale", precision = 13, scale = 2, nullable = true)
    private BigDecimal priceSale;
    private String shortDescription;
    private String detailsDescription;
    private String imageProduct;
    private Long quantity;
    private String seo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private CategoriesEntities categoriesEntities;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "productEntities")
    private Set<ProductImageEntities> productImageEntities = new HashSet<ProductImageEntities>();

    public void addProductImage(ProductImageEntities productImg) {
        this.productImageEntities.add(productImg); // thêm product vào trong Set<Product>
        productImg.setProductEntities(this);// product phải thuộc đối tượng category đang xét(đang call vào hàm)

    }
    public void deleteProductImage(ProductImageEntities productImg) {
        this.productImageEntities.remove(productImg);
        productImg.setProductEntities(null);
    }



}
