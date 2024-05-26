package com.Item.AboutItem.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name= "item_name")
    private String itemName;
    @Column(name= "item_description")
    private String itemDescription;
    @Column(name= "item_number")
    private String itemNumber;
    @Column(name = "item_price")
    private String itemPrice;
    @Column(name = "item_quantity")
    private String itemQuantity;


}
