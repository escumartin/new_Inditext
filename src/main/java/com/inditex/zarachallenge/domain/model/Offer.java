package com.inditex.zarachallenge.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "OFFER")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "VALID_FORM")
    private String validFrom;

    @Column(name = "PRICE")
    private double price;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;


}