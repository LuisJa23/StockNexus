package com.stocknexus.stocknexus.controller.product;

import com.stocknexus.stocknexus.dto.product.ProductRegisterData;
import com.stocknexus.stocknexus.dto.product.ProductResponseData;
import com.stocknexus.stocknexus.service.product.ProductService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    @Transactional
    public ResponseEntity<ProductResponseData> registerProduct(@RequestBody @Valid ProductRegisterData productRegisterData, UriComponentsBuilder uriBuilder){
        var product = productService.registerProduct(productRegisterData);
        var uri = uriBuilder.path("/products/{id}").buildAndExpand(product.id()).toUri();
        return ResponseEntity.created(uri).body(product);
    }
}
