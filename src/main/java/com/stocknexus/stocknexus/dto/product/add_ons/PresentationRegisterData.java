package com.stocknexus.stocknexus.dto.product.add_ons;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.stocknexus.stocknexus.model.product.add_ons.PresentationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PresentationRegisterData(


        @JsonProperty("productId")
        String productId,

        @NotNull
        @JsonProperty("presentationType")
        PresentationType presentationType,

        @JsonProperty("barCode")
        String barCode,

        @NotNull
        @JsonProperty("quantityUnits")
        int quantityUnits

) {
}
