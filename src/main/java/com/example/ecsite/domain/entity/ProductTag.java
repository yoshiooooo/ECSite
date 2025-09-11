package com.example.ecsite.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "product_tag")
@Data
public class ProductTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 複合主キーではなく単一IDにする場合（※後述）

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;
}
