package com.softcodemath.ProvisionInventoryManagement.service;


import com.softcodemath.ProvisionInventoryManagement.dto.ProductRequest;
import com.softcodemath.ProvisionInventoryManagement.entity.Product;
import com.softcodemath.ProvisionInventoryManagement.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product createProduct(ProductRequest productRequest) {

        if(productRepo.existsByName(productRequest.getName())){

            Product findProduct = productRepo.findByName(productRequest.getName());
            findProduct.setAvailableQuantity(findProduct.getAvailableQuantity() + productRequest.getQuantity());
            productRepo.save(findProduct);

            return findProduct;
        }

        Product product = new Product();
        product.setName(productRequest.getName());
        product.setCategoryId(productRequest.getCategoryId());
        product.setPrice(productRequest.getPrice());
        product.setAvailableQuantity(productRequest.getQuantity());

        productRepo.save(product);

        return product;

    }



    public Product getProduct(int id) {

        return productRepo.findById(id).get();
    }
}
