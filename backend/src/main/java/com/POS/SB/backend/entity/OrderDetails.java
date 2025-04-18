package com.POS.SB.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="order_details")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetails {
    @Id
    @Column(name = "order_details_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderDetailsId;

    @Column(name="Item_Name",length = 100,nullable = false)
    private String itemName;

    @Column(name="qty",length = 100,nullable = false)
    private Double qty;

    @Column(name="amount",length = 100,nullable = false)
    private Double amount;

    @ManyToOne
    @JoinColumn(name="order_id",nullable = false)
    private Order orders;

    @ManyToOne
    @JoinColumn(name="item_id",nullable = false)
    private Item items;
}
