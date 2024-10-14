package com.stocknexus.stocknexus.dto.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.stocknexus.stocknexus.dto.product.add_ons.PresentationRegisterData;
import com.stocknexus.stocknexus.dto.product.add_ons.PresentationResponseData;
import com.stocknexus.stocknexus.model.product.Product;
import com.stocknexus.stocknexus.model.product.add_ons.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ProductResponseData(
        Long id,
        String name,

        Category category,

        String lowStockThreshold,

        List<PresentationResponseData> presentationList
)

    {
        public ProductResponseData(Product product, List<PresentationResponseData> presentationList) {
        this(product.getId(), product.getName(), product.getCategory(), String.valueOf(product.getLowStockThreshold()), presentationList);
    }

}
