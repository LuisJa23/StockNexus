package com.stocknexus.stocknexus.dto.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.stocknexus.stocknexus.dto.product.add_ons.PresentationRegisterData;
import com.stocknexus.stocknexus.model.product.add_ons.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ProductRegisterData(
        @NotBlank
        @JsonProperty("name")
        String name,

        @NotNull
        @JsonProperty("category")
        Category category,

        @JsonProperty("lowStockThreshold")
        String lowStockThreshold,

        @NotNull
        @JsonProperty("presentationList")
        List<PresentationRegisterData> presentationList





        ){

}

