package com.example.ecsite.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "cart")
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 外部キー：user_account.id を参照
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserAccount user;

    // デフォルト値はDB側で設定される（CURRENT_TIMESTAMP）
    @Column(name = "created_at", columnDefinition = "timestamp")
    private LocalDateTime createdAt;
}
