package com.stocknexus.stocknexus.service.product.add_ons;

import com.stocknexus.stocknexus.dto.product.add_ons.PresentationRegisterData;
import com.stocknexus.stocknexus.dto.product.add_ons.PresentationResponseData;
import com.stocknexus.stocknexus.model.product.Product;
import com.stocknexus.stocknexus.model.product.add_ons.Presentation;
import com.stocknexus.stocknexus.repository.product.add_ons.PresentationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PresentationService {

    @Autowired
    private PresentationRepository presentationRepository;

    public PresentationResponseData registerPresentation(PresentationRegisterData presentationRegisterData, Product product) {

        var presentation = new Presentation(presentationRegisterData, product);
        presentationRepository.save(presentation);
        return new PresentationResponseData(presentation);
    }
}
