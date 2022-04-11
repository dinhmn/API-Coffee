package com.dev.Coffee.controller;

import com.dev.Coffee.Implements.ProductServiceImpl;
import com.dev.Coffee.model.Categories;
import com.dev.Coffee.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class ProductController {

    @Autowired
    private final ProductServiceImpl productService;

    public ProductController( ProductServiceImpl productService) {
        this.productService = productService;
    }


    @GetMapping("/product")
    public List<Product> getAllCategory() {
        System.out.println(productService.getAllProducts());
        return productService.getAllProducts();
    }

    @PostMapping("/product")
    public Product createProduct(@RequestBody Product product, @RequestParam("img") MultipartFile productAvatar, // hứng file đẩy lên
                                 @RequestParam("subImg") MultipartFile[] productPictures) throws IOException {
        return productService.createProduct(product, productAvatar, productPictures);
    }

}
