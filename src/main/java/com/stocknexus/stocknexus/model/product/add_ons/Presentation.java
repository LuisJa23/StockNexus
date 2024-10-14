package com.stocknexus.stocknexus.model.product.add_ons;

import com.stocknexus.stocknexus.dto.product.add_ons.PresentationRegisterData;
import com.stocknexus.stocknexus.model.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "presentation")

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Presentation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String barCode;
    private int quantityUnits;

    @Enumerated(EnumType.STRING)
    private PresentationType presentationType;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Product product;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "batch_presentation",
            joinColumns = @JoinColumn(name = "presentation_id"),
            inverseJoinColumns = @JoinColumn(name = "batch_id")
    )
    private List<Batch> batches;


    public Presentation(PresentationRegisterData presentationRegisterData, Product product){
        this.barCode = presentationRegisterData.barCode();
        this.quantityUnits = presentationRegisterData.quantityUnits();
        this.presentationType = presentationRegisterData.presentationType();
        this.product = product;

    }

}
