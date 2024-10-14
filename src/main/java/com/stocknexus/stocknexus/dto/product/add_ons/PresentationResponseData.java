package com.stocknexus.stocknexus.dto.product.add_ons;

import com.stocknexus.stocknexus.model.product.add_ons.Presentation;
import com.stocknexus.stocknexus.model.product.add_ons.PresentationType;

public record PresentationResponseData(
        String productId,
        PresentationType presentationType,
        String barCode,
        int quantityUnits
) {
    public PresentationResponseData(Presentation presentation) {
        this(presentation.getProduct().getId().toString(), presentation.getPresentationType(), presentation.getBarCode(), presentation.getQuantityUnits());
    }
}
