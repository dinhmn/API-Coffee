package com.dev.Coffee.Implements;

import com.dev.Coffee.entities.ProductImageEntities;
import com.dev.Coffee.model.ProductImage;
import com.dev.Coffee.services.ProductImagesService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ProductImageServiceImpl implements ProductImagesService {
    @Override
    public ProductImage createProductImage(ProductImage productImage) {
        return null;
    }

    @Override
    public List<ProductImage> getAllProductImages() {
        return null;
    }

    @Override
    public boolean deleteProductImage() {
        return false;
    }

//    public void delete(ProductImageEntities productImageEntities){
//        productImageEntities.
//    }

    @Override
    public ProductImage getProductImage() {
        return null;
    }

    @Override
    public ProductImage uploadProductImage() {
        return null;
    }

    public boolean isEmptyUploadFile(MultipartFile[] images) {
        if (images == null || images.length <= 0)
            return true;

        if (images.length == 1 && images[0].getOriginalFilename().isEmpty())
            return true;

        return false;
    }

    public boolean isEmptyUploadFile(MultipartFile image) {
        return image == null || image.getOriginalFilename().isEmpty();
    }
}
