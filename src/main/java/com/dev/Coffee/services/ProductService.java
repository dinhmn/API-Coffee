package com.dev.Coffee.services;

import com.dev.Coffee.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    Product createProduct(Product product, MultipartFile productAvatar, MultipartFile[] productPictures) throws IOException;
    List<Product> getAllProducts();
    boolean deleteProduct(Long id);
    Product getProductById(Long id);
    Product updateProductById(Long id, Product product, MultipartFile productAvatar,MultipartFile[] productPictures) throws IOException;

}
