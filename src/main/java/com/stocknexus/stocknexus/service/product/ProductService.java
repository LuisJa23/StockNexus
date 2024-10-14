package com.stocknexus.stocknexus.service.product;

import com.stocknexus.stocknexus.dto.product.ProductRegisterData;
import com.stocknexus.stocknexus.dto.product.ProductResponseData;
import com.stocknexus.stocknexus.dto.product.add_ons.PresentationRegisterData;
import com.stocknexus.stocknexus.dto.product.add_ons.PresentationResponseData;
import com.stocknexus.stocknexus.model.product.Product;
import com.stocknexus.stocknexus.model.product.add_ons.Presentation;
import com.stocknexus.stocknexus.repository.product.ProductRepository;
import com.stocknexus.stocknexus.service.product.add_ons.PresentationService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PresentationService presentationService;





    @Transactional
    public ProductResponseData registerProduct(ProductRegisterData productRegisterData) {
        try {

            var product = new Product(productRegisterData);


           productRegisterData.presentationList()
                    .forEach(presentation -> presentationService.registerPresentation(presentation, product));

            productRepository.save(product);

            var presentationList = productRegisterData.presentationList()
                    .stream()
                    .map(presentation -> new PresentationResponseData(new Presentation(presentation, product)))
                    .collect(Collectors.toList());

            return new ProductResponseData(product, presentationList);
        } catch (Exception e) {
            throw new RuntimeException("Error registering product or presentations", e);
            // Manejo de excepción (personalizar según necesidades)
            //throw new ProductRegistrationException("Error registering product or presentations", e);
        }
    }

}
