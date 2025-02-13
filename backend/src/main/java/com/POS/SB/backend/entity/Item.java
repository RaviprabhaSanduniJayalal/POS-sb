package com.POS.SB.backend.entity;


import com.POS.SB.backend.entity.enums.MeasuringUnitType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Table(name="Item")

public class Item {

    @Setter
    @Getter

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq")
    @SequenceGenerator(name = "item_seq", sequenceName = "item_sequence", allocationSize = 1)
    private int itemId;


    @Column(name="Item_Name",length = 100,nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name="Measure_Type",length = 100,nullable = false)
    private MeasuringUnitType measuringUnitType;

    @Column(name="Balance_Type",length = 100,nullable = false)
    private Double balanceQty;

    @Column(name="Supplier_Price",length = 100,nullable = false)
    private Double supplierPrice;

    @Column(name="Selling_Price",length = 100,nullable = false)
    private Double sellingPrice;

    @Column(name="Active_State",columnDefinition = "TINYINT default 0")
    private boolean activeState;

    @OneToMany(mappedBy = "items")
    private Set<OrderDetails> orderDetails;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

}
