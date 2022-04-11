package com.dev.Coffee.services;

import com.dev.Coffee.model.ProductImage;

import java.util.List;

public interface ProductImagesService {

    ProductImage createProductImage(ProductImage productImage);
    List<ProductImage> getAllProductImages();
    boolean deleteProductImage();
    ProductImage getProductImage();
    ProductImage uploadProductImage();

}
