package com.inditex.zarachallenge.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SIZE")
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SIZE_ID")
    private Long sizeId;

    @Column(name = "SIZE")
    private String size;

    @Column(name = "AVAILABILITY")
    private boolean availability;

    @Column(name = "LAST_UPDATED")
    private String lastUpdated;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;


}