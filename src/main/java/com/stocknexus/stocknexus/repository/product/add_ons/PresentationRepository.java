package com.stocknexus.stocknexus.repository.product.add_ons;


import com.stocknexus.stocknexus.model.product.add_ons.Presentation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PresentationRepository extends JpaRepository<Presentation, Long> {


    List<Presentation> findAllByProductId(Long productId);
}
