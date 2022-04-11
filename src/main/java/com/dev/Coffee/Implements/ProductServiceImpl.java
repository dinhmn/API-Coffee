package com.dev.Coffee.Implements;

import com.dev.Coffee.entities.ProductEntities;
import com.dev.Coffee.entities.ProductImageEntities;
import com.dev.Coffee.model.Product;
import com.dev.Coffee.model.ProductImage;
import com.dev.Coffee.repository.ProductRepository;
import com.dev.Coffee.services.ProductService;
import com.github.slugify.Slugify;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import javax.persistence.Table;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    public String UPLOAD_FOLDER_ROOT = "D:/apiImage/";

    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final  ProductImageServiceImpl productImageServiceImpl;


    public ProductServiceImpl(ProductRepository productRepository, ProductImageServiceImpl productImageServiceImpl) {
        this.productRepository = productRepository;
        this.productImageServiceImpl = productImageServiceImpl;
    }

    @Override
    public Product createProduct(Product product, MultipartFile productAvatar, MultipartFile[] productPictures) throws IOException {
        ProductEntities productEntities = new ProductEntities();
        BeanUtils.copyProperties(product, productEntities);

        if(!productImageServiceImpl.isEmptyUploadFile(productAvatar)){
            String pathToFile = UPLOAD_FOLDER_ROOT + "product/avatar/" + productAvatar.getOriginalFilename();

            productAvatar.transferTo(new File(pathToFile));

            productEntities.setImageProduct("product/avatar/" + productAvatar.getOriginalFilename());
        }

        if(!productImageServiceImpl.isEmptyUploadFile(productPictures)){

            for (MultipartFile pic:
                    productPictures) {
                pic.transferTo(new File(UPLOAD_FOLDER_ROOT + "product/pictures" + pic.getOriginalFilename()));

                ProductImageEntities pi = new ProductImageEntities();
                pi.setDownloadURL("product/pictures/" + pic.getOriginalFilename());
                pi.setPathName(pic.getOriginalFilename());


                productEntities.addProductImage(pi);
            }

        }

        productEntities.setCreated_date(new Date());
        productEntities.setSeo(new Slugify().slugify(productEntities.getTitle()));
        productRepository.save(productEntities);

        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        List<ProductEntities> productEntities = productRepository.findAll();
        List<Product> products = productEntities
                .stream()
                .map(pro -> new Product(
                        pro.getId(),
                        pro.getStatus(),
                        pro.getCreated_by(),
                        pro.getUpdated_by(),
                        pro.getCreated_date(),
                        pro.getUpdated_date(),
                        pro.getTitle(),
                        pro.getPrice(),
                        pro.getPriceSale(),
                        pro.getShortDescription(),
                        pro.getDetailsDescription(),
                        pro.getImageProduct(),
                        pro.getQuantity(),
                        pro.getSeo(),
                        pro.getCategoriesEntities().getId()
                )).collect(Collectors.toList());

        return products;
//        return productEntities;
    }

    @Override
    public boolean deleteProduct(Long id) {
        ProductEntities productEntities = productRepository.findById(id).get();
        productRepository.delete(productEntities);
        return true;
    }

    @Override
    public Product getProductById(Long id) {
        ProductEntities productEntities = productRepository.findById(id).get();
        Product product = new Product();

        BeanUtils.copyProperties(productEntities, product);
        return product;
    }

    @Override
    public Product updateProductById(Long id, Product product, MultipartFile productAvatar,MultipartFile[] productPictures)
            throws IllegalStateException, IOException{
        ProductEntities productEntities = productRepository.findById(id).get();

        if(!productImageServiceImpl.isEmptyUploadFile(productAvatar)){

            new File(UPLOAD_FOLDER_ROOT + product.getImageProduct()).delete();

            productAvatar.transferTo(new File(UPLOAD_FOLDER_ROOT + "product/avatar/" + productAvatar.getOriginalFilename()));
            productEntities.setImageProduct("product/avatar/" + productAvatar.getOriginalFilename());
        } else {
            productEntities.setImageProduct(product.getImageProduct());
        }

//        if(!productImageServiceImpl.isEmptyUploadFile(productPictures)){
//            if (productEntities.getProductImageEntities() != null && productEntities.getProductImageEntities().size() > 0)
////                productInDb.getProductImages().size() > 0
//            {
//                for(ProductImageEntities pie : productEntities.getProductImageEntities()){
//                    new File(UPLOAD_FOLDER_ROOT + pie.getDownloadURL()).delete();


//                    if (productInDb.getProductImages() != null && productInDb.getProductImages().size() > 0) {
//                        for (ProductImage opi : productInDb.getProductImages()) {
//                            // xóa avatar trong folder lên
//                            new File(UPLOAD_FOLDER_ROOT + opi.getPath()).delete();
//
//                            productImagesService.delete(opi);
//                        }
//                    }
//
//                    // thêm pictures mới
//                    for (MultipartFile pic : productPictures) {
//                        pic.transferTo(new File(UPLOAD_FOLDER_ROOT + "product/pictures/" + pic.getOriginalFilename()));
//
//                        ProductImage pi = new ProductImage();
//                        pi.setPath("product/pictures/" + pic.getOriginalFilename());
//                        pi.setTitle(pic.getOriginalFilename());
//
//                        p.addProductImage(pi);
//                    }
//                }
//            }
//        }

        productEntities.setImageProduct(product.getImageProduct());
        productEntities.setSeo(product.getSeo());
        productEntities.setStatus(product.getStatus());
        productEntities.setDetailsDescription(product.getDetailsDescription());
        productEntities.setShortDescription(product.getShortDescription());
        productEntities.setPrice(product.getPrice());
        productEntities.setPriceSale(product.getPriceSale());
        productEntities.setQuantity(product.getQuantity());
        productEntities.setTitle(product.getTitle());
        productEntities.setUpdated_by(product.getUpdated_by());
        productEntities.setUpdated_date(new Date());
        productEntities.setCategoriesEntities(productEntities.getCategoriesEntities());

        productRepository.save(productEntities);
        return product;
    }
}
