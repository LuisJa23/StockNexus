package com.stocknexus.stocknexus.model.product;


import com.stocknexus.stocknexus.dto.product.ProductRegisterData;
import com.stocknexus.stocknexus.model.product.add_ons.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "product")

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int lowStockThreshold;

    @Enumerated(EnumType.STRING)
    private Category category;

    public Product(ProductRegisterData productRegisterData) {
        this.name = productRegisterData.name();
        this.category = productRegisterData.category();
        this.lowStockThreshold = Integer.parseInt(productRegisterData.lowStockThreshold());

    }
}
